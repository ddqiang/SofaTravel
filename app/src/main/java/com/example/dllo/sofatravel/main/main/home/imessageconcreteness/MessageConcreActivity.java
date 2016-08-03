package com.example.dllo.sofatravel.main.main.home.imessageconcreteness;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.example.dllo.sofatravel.main.main.tools.alipay.Merchant;
import com.example.dllo.sofatravel.main.main.tools.alipay.OrderUtils;
import com.fuqianla.paysdk.FuQianLaPay;
import com.youth.banner.Banner;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


/**
 * Created by dllo on 16/7/21.
 */
public class MessageConcreActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back, share;
    private TextView price, reservations;
    private Banner banner;
    private TextView title, room, bed, azonic, name, context, posOne, posTwo, posThree, description;
    private ImageView head;
    private LinearLayout linearLayout;
    int spaceId = getIntent().getIntExtra("spaceId", 0);

    @Override
    public int getLayout() {
        return R.layout.activity_message_concreteness;
    }

    @Override
    public void initView() {
        banner = (Banner) findViewById(R.id.message_concre_banner);
        back = (ImageView) findViewById(R.id.message_concre_back);
        price = (TextView) findViewById(R.id.message_concre_price);
        title = (TextView) findViewById(R.id.message_concre_title);
        name = (TextView) findViewById(R.id.message_concre_ownerName);
        head = (ImageView) findViewById(R.id.message_concre_head);
        context = (TextView) findViewById(R.id.message_concre_context);
        posOne = (TextView) findViewById(R.id.message_concre_posOne);
        posTwo = (TextView) findViewById(R.id.message_concre_posTwo);
        posThree = (TextView) findViewById(R.id.message_concre_posThree);
        description = (TextView) findViewById(R.id.message_concre_description);
        linearLayout = (LinearLayout) findViewById(R.id.message_concre_linearLayout);
        share = (ImageView) findViewById(R.id.message_concre_share);
        reservations = (TextView) findViewById(R.id.message_concre_reservations);
        reservations.setOnClickListener(this);
        share.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void initData() {
        //数据解析n
        messageConvreOk();
    }

    private void messageConvreOk() {

        OkSingle.getInstance().getMessageConcre(spaceId,
                MessageConBean.class, new OkSingle.OnTrue<MessageConBean>() {
                    @Override
                    public void hasData(MessageConBean data) {
                        String[] imageURL = new String[data.getData().getPictureList().size()];
                        for (int i = 0; i < data.getData().getPictureList().size(); i++) {
                            imageURL[i] = data.getData().getPictureList().get(i);
                        }
                        banner.setDelayTime(Integer.MAX_VALUE);
                        banner.setImages(imageURL);
                        price.setText(String.valueOf(data.getData().getPrice()));
                        title.setText(data.getData().getTitle());
                        Glide.with(MessageConcreActivity.this).load(data.getData().getOwnerPic()).into(head);
                        name.setText(data.getData().getOwnerName());
                        context.setText(data.getData().getOwnerDescription());
                        if (data.getData().getLabelList() != null) {
                            posOne.setText(data.getData().getLabelList().get(0).getLabelName());
                            posTwo.setText(data.getData().getLabelList().get(1).getLabelName());
                            posThree.setText(data.getData().getLabelList().get(2).getLabelName());
                            description.setText(data.getData().getDescription());
                        } else {
                            linearLayout.setVisibility(View.GONE);
                        }
                    }
                }, new OkSingle.OnError() {
                    @Override
                    public void noHasData() {
                        Toast.makeText(MessageConcreActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_concre_back:
                finish();
                break;
            case R.id.message_concre_share:
                ShareSDK.initSDK(this);
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//                oks.setTitle(getString(R.string.share));
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl(" http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
                        + spaceId + "%7D");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl(" http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
                        + spaceId + "%7D");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl(" http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
                        + spaceId + "%7D");
                // 启动分享GUI
                oks.show(this);
                break;
            case R.id.message_concre_reservations:
                topay();
                break;
        }
    }

    private void topay() {
        FuQianLaPay pay = new FuQianLaPay.Builder(this)
              .partner(Merchant.MERCHANT_NO)//商户号
                .alipay(true)
              .orderID(OrderUtils.getOutTradeNo())//订单号
                .amount(Double.parseDouble("0.1"))//金额
                .subject("卫龙")//商品名称
                .body("辣条,好 尅")//商品交易详情
               .notifyUrl(Merchant.MERCHANT_NOTIFY_URL)
                .build();
        pay.startPay();
    }
}