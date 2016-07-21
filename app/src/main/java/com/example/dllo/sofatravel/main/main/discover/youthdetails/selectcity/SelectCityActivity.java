package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;



import java.util.List;

/**
 * Created by dllo on 16/7/19.
 */
public class SelectCityActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;


    @Override
    public int getLayout() {
        return R.layout.activity_dis_select_city;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.discover_select_city_back);
        back.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discover_select_city_back:
                finish();
                break;
        }
    }
}
