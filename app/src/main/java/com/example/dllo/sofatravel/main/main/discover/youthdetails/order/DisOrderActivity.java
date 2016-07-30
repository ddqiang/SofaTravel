package com.example.dllo.sofatravel.main.main.discover.youthdetails.order;

import android.widget.Button;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;

/**
 * Created by dllo on 16/7/28.
 */
public class DisOrderActivity extends BaseActivity {
    private TextView hotelName;
    private Button payBtn;

    @Override
    public int getLayout() {
        return R.layout.activity_dis_order;
    }

    @Override
    public void initView() {
        hotelName= (TextView) findViewById(R.id.dis_order_hotel_name);
        payBtn= (Button) findViewById(R.id.dis_order_pay);
        hotelName.setText(getIntent().getStringExtra("hotelName"));

    }

    @Override
    public void initData() {

    }

}
