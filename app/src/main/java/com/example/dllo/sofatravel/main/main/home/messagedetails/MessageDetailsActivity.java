package com.example.dllo.sofatravel.main.main.home.messagedetails;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.home.imessageconcreteness.MessageConcreActivity;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionBean;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.example.dllo.sofatravel.main.main.tools.listviewutils.CommonAdapter;
import com.example.dllo.sofatravel.main.main.tools.listviewutils.MyViewHolder;

/**
 * Created by dllo on 16/7/20.
 */
public class MessageDetailsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private TextView titleCity;
    private ListView messageLv;

    @Override
    public int getLayout() {
        return R.layout.activity_message_details;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.messageDetail_back);
        titleCity = (TextView) findViewById(R.id.messageDetail_city);
        messageLv = (ListView) findViewById(R.id.messageDetail_lv);
        back.setOnClickListener(this);
        titleCity.setOnClickListener(this);
    }

    @Override
    public void initData() {
        titleCity.setText(getIntent().getStringExtra("city"));
        //数据解析
        MyOkHttp();
    }

    private void MyOkHttp() {

        int messageId = getIntent().getIntExtra("messageId", 0);
        String url = "http://www.shafalvxing.com/space/getSharedSpaceByCity." +
                "do?bizParams=%7B%22cityId%22%3A%22" + messageId + "%22%2C%22endPrice%22%3A0%2C%22page%22%3A%221%22%2C%22startPrice%22%3" +
                "A0%2C%22userToken%22%3A%22MzdlNGY1MzE2ZjI4MjZiNzNlNjRjNmRkMzFlOTM5YTczZGRhYzI1NmI1ZWExNzI4%22%7D";
        OkSingle.getInstance().getRequestAsync(url,
                MessageBean.class, new OkSingle.OnTrue<MessageBean>() {
                    @Override
                    public void hasData(final MessageBean data) {
                        messageLv.setAdapter(new CommonAdapter<MessageBean.DataBean.ResultBean>
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
            case R.id.messageDetail_city:

                break;
        }
    }
}
