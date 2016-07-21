package com.example.dllo.sofatravel.main.main.home.messagedetails;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
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
    private Context context;

    @Override
    public int getLayout() {
        return R.layout.activity_message_details;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.messageDetail_back);
        titleCity = (TextView) findViewById(R.id.messageDetail_city);
        messageLv= (ListView) findViewById(R.id.messageDetail_lv);
        back.setOnClickListener(this);
        titleCity.setOnClickListener(this);
    }

    @Override
    public void initData() {

        //数据解析
        MyOkHttp();
    }

    private void MyOkHttp() {
        String messageId = getIntent().getStringExtra("messageId");
        OkSingle.getInstance().getRequestAsync("http://www.shafalvxing.com/space/getSharedSpaceByCity." +
                "do?bizParams=%7B%22cityId%22%3A%22" + messageId + "%22%2C%22endPrice%22%3A0%2C%22page%22%3A%221%22%2C%22startPrice%22%3" +
                "A0%2C%22userToken%22%3A%22MzdlNGY1MzE2ZjI4MjZiNzNlNjRjNmRkMzFlOTM5YTczZGRhYzI1NmI1ZWExNzI4%22%7D", MessageBean.class, new OkSingle.OnTrue<MessageBean>() {
            @Override
            public void hasData(MessageBean data) {
//            messageLv.setAdapter(new CommonAdapter<String>(context,data,) {
//
//                @Override
//                public void convert(MyViewHolder holder, String s) {
//
//                }
//            });

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
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.messageDetail_back:
                finish();
                break;
            case R.id.messageDetail_city:

                break;
        }
    }
}
