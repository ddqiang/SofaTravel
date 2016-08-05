package com.example.dllo.sofatravel.main.main.home.messagedetails;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.home.imessageconcreteness.MessageConcreActivity;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionBean;
import com.example.dllo.sofatravel.main.main.tools.alipay.Merchant;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.example.dllo.sofatravel.main.main.tools.alipay.OrderUtils;
import com.example.dllo.sofatravel.main.main.tools.listviewutils.CommonAdapter;
import com.example.dllo.sofatravel.main.main.tools.listviewutils.MyViewHolder;
import com.fuqianla.paysdk.FuQianLaPay;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by dllo on 16/7/20.
 */
public class MessageDetailsActivity extends BaseActivity implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2 {

    private ImageView mBack, mMap;
    private TextView mTitleCity;
    private ListView mMessageLv;
    private PullToRefreshListView mPullToRefreshListView;

    @Override
    public int getLayout() {
        return R.layout.activity_message_details;
    }

    @Override
    public void initView() {
        mBack = (ImageView) findViewById(R.id.messageDetail_back);
        mTitleCity = (TextView) findViewById(R.id.messageDetail_city);
        mMap = (ImageView) findViewById(R.id.messageDetail_map);
        mPullToRefreshListView = (PullToRefreshListView) findViewById(R.id.messageDetail_lv);
        //实现下拉效果
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        mMap.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mTitleCity.setOnClickListener(this);
        mPullToRefreshListView.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        mTitleCity.setText(getIntent().getStringExtra("city"));
        mMessageLv = mPullToRefreshListView.getRefreshableView();
        //数据解析
        MyOkHttp();
    }

    private void MyOkHttp() {
        int messageId = getIntent().getIntExtra("messageId", 0);
        OkSingle.getInstance().getOwnerMessageDetail(messageId, MessageBean.class, new OkSingle.OnTrue<MessageBean>() {
            @Override
            public void hasData(final MessageBean data) {
                mMessageLv.setAdapter(new CommonAdapter<MessageBean.DataBean.ResultBean>
                        (MessageDetailsActivity.this, data.getData().getResult(), R.layout.messagedetail_lv_item) {
                    @Override
                    public void convert(MyViewHolder holder, final MessageBean.DataBean.ResultBean resultBean) {
                        holder.setShowImage(R.id.message_showIv, resultBean.getPictureList().get(0));
                        holder.setText(R.id.message_name, resultBean.getOwnerName());
                        holder.setHeadImage(R.id.message_head, resultBean.getOwnerPic());
                        holder.setAgeText(R.id.message_age, String.valueOf(resultBean.getAge()));

                        if (resultBean.getSex() == 1) {
                            holder.setSexText(R.id.message_sex, "男");
                        } else {
                            holder.setSexText(R.id.message_sex, "女");
                        }
                        CollectionBean bean = new CollectionBean();
                        bean.setOwnerAge(resultBean.getAge());
                        bean.setOwnerHead(resultBean.getOwnerPic());
                        bean.setOwnerJob(resultBean.getProfession());
                        bean.setOwnerName(resultBean.getOwnerName());
                        String sex;
                        if (resultBean.getSex() == 1) {
                            sex = "男";
                        } else {
                            sex = "女";
                        }
                        bean.setOwnerSex(sex);
                        bean.setPrice(resultBean.getPrice());
                        bean.setResponseRate(resultBean.getReplyRate());
                        bean.setSpaceId(resultBean.getSpaceId());
                        bean.setSpaceImage(resultBean.getPictureList().get(0));
                        bean.setTitle(resultBean.getTitle());
                        holder.collectionImage(R.id.item_message_detail_collection_image, bean);
                        holder.setTitleText(R.id.message_title, resultBean.getTitle());
                        holder.setJobText(R.id.message_job, resultBean.getProfession());
                        holder.setPriceText(R.id.message_price, String.valueOf(resultBean.getPrice()));
                        holder.setresponseRateText(R.id.message_response_rate, String.valueOf(resultBean.getReplyRate()));

                        holder.setMyOnClick(new MyOnClick() {
                            @Override
                            public void onClick(int pos) {
                                Intent intent = new Intent(MessageDetailsActivity.this, MessageConcreActivity.class);
                                intent.putExtra("spaceId", data.getData().getResult().get(pos).getSpaceId());
                                startActivity(intent);
                            }
                        });
                        mPullToRefreshListView.onRefreshComplete();
                    }
                });
            }

        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {
                Toast.makeText(MessageDetailsActivity.this, "请求错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.messageDetail_back:

                finish();
                break;
            case R.id.messageDetail_map:
                topay();

                break;
        }
    }

    private void topay() {
        FuQianLaPay pay = new FuQianLaPay.Builder(this)
                .partner(Merchant.MERCHANT_NO)//商户号
                .alipay(true)
                .orderID(OrderUtils.getOutTradeNo())//订单号
                .amount(Double.parseDouble("0.01"))//金额
                .subject("意外怀孕怎么办??到大连天伦不孕不育医院")//商品名称
                .body("你负责来,我们负责生")//商品交易详情
                .notifyUrl(Merchant.MERCHANT_NOTIFY_URL)
                .build();
        pay.startPay();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mPullToRefreshListView.setRefreshing(true);
        MyOkHttp();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
//        page = page + 10;
        MyOkHttp();
        mPullToRefreshListView.setRefreshing(true);
        mPullToRefreshListView.onRefreshComplete();
    }
}
