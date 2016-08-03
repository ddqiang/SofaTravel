package com.example.dllo.sofatravel.main.main.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.home.bannerdetails.BannerDetailActivity;
import com.example.dllo.sofatravel.main.main.home.messagedetails.MessageDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.NetWorkOnLine;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.example.dllo.sofatravel.main.main.tools.imagecache.CacheFile;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import static java.lang.Thread.sleep;

/**
 * Created by dllo on 16/7/18.
 */
public class HomeFragment extends BaseFragment {

    private HeaderGridView mHeaderGridView;
    private HomeGrViewAdapter mHomeGrViewAdapter;
    private Banner mBanner;
    private Intent mIntent;
    private final static String TGA = "HomeFragment";

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        mHeaderGridView = (HeaderGridView) view.findViewById(R.id.home_gridView);
    }

    @Override
    public void initData() {
        mHomeGrViewAdapter = new HomeGrViewAdapter(context);
        View view1 = LayoutInflater.from(context).inflate(R.layout.home_banner, null);
        mBanner = (Banner) view1.findViewById(R.id.fragment_home_banner);
        mHeaderGridView.addHeaderView(view1);
        //首页数据解析 and 轮播图
        if (NetWorkOnLine.isNetworkAvailable()) {
            showHomeOk();
        }
        String result = CacheFile.loading();
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(result, HomeBean.class);
        mHomeGrViewAdapter.setHomeBean(homeBean);
        BannerShow(homeBean);
        mHeaderGridView.setAdapter(mHomeGrViewAdapter);
    }


    private void showHomeOk() {
        OkSingle.getInstance().getMessgeDetail(HomeBean.class, new OkSingle.OnTrue<HomeBean>() {
            @Override
            public void hasData(final HomeBean data) {
                mHomeGrViewAdapter.setHomeBean(data);
                BannerShow(data);
                adapterOnClick(data);
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

                Toast.makeText(context, "请求失败,请检查网络设置", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void BannerShow(final HomeBean data) {
        mBanner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        mBanner.setIndicatorGravity(Banner.CENTER);
        Log.d(TGA, "data.getData().getHomePageInfo():" + data.getData().getHomePageInfo());
        String[] bannerUrl = new String[data.getData().getHomePageInfo().getTopBanner().size()];
        for (int i = 0; i < data.getData().getHomePageInfo().getTopBanner().size(); i++) {
            bannerUrl[i] = data.getData().getHomePageInfo().getTopBanner().get(i).getAdvPic();
        }
        mBanner.setDelayTime(3000);
        mBanner.setImages(bannerUrl);
        mBanner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                mIntent = new Intent(context, BannerDetailActivity.class);
                mIntent.putExtra("webUrl", data.getData().getHomePageInfo().getTopBanner().get(0).getShareInfo().getShareUrl());
                mIntent.putExtra("title", data.getData().getHomePageInfo().getTopBanner().get(0).getAdvTitle());

                final ProgressDialog dialog = ProgressDialog.show(context, "跳转网页", "请稍后...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        dialog.dismiss();
                        getActivity().startActivity(mIntent);
                    }
                }).start();
            }
        });
    }

    public void adapterOnClick(final HomeBean data) {
        mHomeGrViewAdapter.setMyOnClick(new MyOnClick() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(context, MessageDetailsActivity.class);
                intent.putExtra("messageId", data.getData().getHomePageInfo().getRecommendCity().get(pos).getId());
                intent.putExtra("city", data.getData().getHomePageInfo().getRecommendCity().get(pos).getCityNameCh());
                startActivity(intent);


            }
        });
    }
}
