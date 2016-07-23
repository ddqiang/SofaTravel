package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.YouthDetailsActivity;

/**
 * Created by dllo on 16/7/20.
 */
public class MapActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back,mapList;
    @Override
    public int getLayout() {
        return R.layout.activity_dis_map;
    }

    @Override
    public void initView() {
        back= (ImageView) findViewById(R.id.discover_map_back);
        back.setOnClickListener(this);
        mapList= (ImageView) findViewById(R.id.discover_map_list);
        mapList.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.discover_map_back:
                finish();
                break;
            case R.id.discover_map_list:
                Intent mapListIntent=new Intent(MapActivity.this, YouthDetailsActivity.class);
                startActivity(mapListIntent);
                break;
        }
    }
}
