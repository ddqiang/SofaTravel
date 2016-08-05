package com.example.dllo.sofatravel.main.main.mine.myhouse;

import android.widget.ListView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.mine.HouseInfoBean;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/4.
 */
public class MyHouseActivity extends BaseActivity {
    private ArrayList<HouseInfoBean> beans;
    private MyHouseAdapter adapter;
    private ListView listView;

    @Override
    public int getLayout() {
        return R.layout.activity_my_house_show;
    }

    @Override
    public void initView() {
        beans = new ArrayList<>();
        adapter = new MyHouseAdapter(this);
        listView = (ListView) findViewById(R.id.activity_my_house_show_listview);

    }

    @Override
    public void initData() {

        beans = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(HouseInfoBean.class);
        adapter.setBeans(beans);
        listView.setAdapter(adapter);
    }
}
