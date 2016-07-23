package com.example.dllo.sofatravel.main.main.home.imessageconcreteness;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.home.messagedetails.MessageDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.youth.banner.Banner;


/**
 * Created by dllo on 16/7/21.
 */
public class MessageConcreActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private TextView price;
    private Banner banner;
    private TextView title, room, bed, azonic, name, context, posOne, posTwo, posThree;
    private ImageView head;
    private LinearLayout linearLayout;


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
        linearLayout = (LinearLayout) findViewById(R.id.message_concre_linearLayout);
        back.setOnClickListener(this);

    }

    @Override
    public void initData() {
        //数据解析n
        messageConvreOk();

        //详情界面 图片数组解析
        myBannerImageOk();
    }

    private void myBannerImageOk() {

    }

    private void messageConvreOk() {
        OkSingle.getInstance().getMessageConcre(getIntent().getIntExtra("spaceId", 0), MessageConBean.class, new OkSingle.OnTrue<MessageConBean>() {
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
//        String url = " http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
//                + getIntent().getIntExtra("spaceId", 0) + "%7D";
//        OkSingle.getInstance().getRequestAsync(url, MessageConBean.class, new OkSingle.OnTrue<MessageConBean>() {
//            @Override
//            public void hasData(MessageConBean data) {
//                String[] imageURL = new String[data.getData().getPictureList().size()];
//                for (int i = 0; i < data.getData().getPictureList().size(); i++) {
//                    imageURL[i] = data.getData().getPictureList().get(i);
//                }
//
//                banner.setDelayTime(Integer.MAX_VALUE);
//                banner.setImages(imageURL);
//                price.setText(String.valueOf(data.getData().getPrice()));
//                title.setText(data.getData().getTitle());
//                Glide.with(MessageConcreActivity.this).load(data.getData().getOwnerPic()).into(head);
//                name.setText(data.getData().getOwnerName());
//                context.setText(data.getData().getOwnerDescription());
//                if (data.getData().getLabelList() != null) {
//                    posOne.setText(data.getData().getLabelList().get(0).getLabelName());
//                    posTwo.setText(data.getData().getLabelList().get(1).getLabelName());
//                    posThree.setText(data.getData().getLabelList().get(2).getLabelName());
//                } else {
//                    linearLayout.setVisibility(View.GONE);
//                }
//            }
//        }, new OkSingle.OnError() {
//            @Override
//            public void noHasData() {
//                Toast.makeText(MessageConcreActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_concre_back:
//                startActivity(new Intent(MessageConcreActivity.this, MessageDetailsActivity.class));
                finish();
                break;
        }
    }
}
