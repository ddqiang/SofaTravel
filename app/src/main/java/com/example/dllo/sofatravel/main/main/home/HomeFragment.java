package com.example.dllo.sofatravel.main.main.home;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;

import com.youth.banner.Banner;


/**
 * Created by dllo on 16/7/18.
 */
public class HomeFragment extends BaseFragment {

    private MyGridView homeGv;
    private HomeGrViewAdapter homeGrViewAdapter;
    private final String homeUrl = "http://www.shafalvxing.com/index/indexLoadInfo.do?" +
            "bizParams=%7B%22userToken%22%3A%22%22%2C%22deviceToken%22%3A%22d794b9867629fd3c09e63c478be29a4b%22%7D";
    private Banner banner;


    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        homeGv = (MyGridView) view.findViewById(R.id.home_gridView);
        banner = (Banner) view.findViewById(R.id.fragment_home_banner);
    }

    @Override
    public void initData() {

        homeGrViewAdapter = new HomeGrViewAdapter(context);

        OkSingle.getInstance().getRequestAsync(homeUrl, HomeBean.class, new OkSingle.OnTrue<HomeBean>() {
            @Override
            public void hasData(HomeBean data) {
                homeGrViewAdapter.setHomeBean(data);
                homeGv.setAdapter(homeGrViewAdapter);
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {
                Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
