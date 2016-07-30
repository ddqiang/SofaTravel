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

    private HeaderGridView headerGridView;
    private HomeGrViewAdapter homeGrViewAdapter;
    private Banner banner;
    private Intent intent;
    private TextView mTextView;
    private final static String TGA = "HomeFragment";

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        headerGridView = (HeaderGridView) view.findViewById(R.id.home_gridView);
        mTextView = (TextView) view.findViewById(R.id.text);
    }

    @Override
    public void initData() {
        homeGrViewAdapter = new HomeGrViewAdapter(context);
        View view1 = LayoutInflater.from(context).inflate(R.layout.home_banner, null);
        banner = (Banner) view1.findViewById(R.id.fragment_home_banner);
        headerGridView.addHeaderView(view1);
        //首页数据解析 and 轮播图
        if (NetWorkOnLine.isNetworkAvailable()) {
            showHomeOk();
        }
        String result = CacheFile.loading();
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(result, HomeBean.class);
        homeGrViewAdapter.setHomeBean(homeBean);
        BannerShow(homeBean);
        headerGridView.setAdapter(homeGrViewAdapter);
    }


    private void showHomeOk() {
        OkSingle.getInstance().getMessgeDetail(HomeBean.class, new OkSingle.OnTrue<HomeBean>() {
            @Override
            public void hasData(final HomeBean data) {
                homeGrViewAdapter.setHomeBean(data);
                BannerShow(data);
                adapterOnClick(data);
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

                Toast.makeText(context, "请求失败,请检查网络设置", Toast.LENGTH_SHORT).show();
//                mTextView.setText(View.VISIBLE);
            }
        });
    }


    public void BannerShow(final HomeBean data) {
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(Banner.CENTER);
        Log.d(TGA, "data.getData().getHomePageInfo():" + data.getData().getHomePageInfo());
        String[] bannerUrl = new String[data.getData().getHomePageInfo().getTopBanner().size()];
        for (int i = 0; i < data.getData().getHomePageInfo().getTopBanner().size(); i++) {
            bannerUrl[i] = data.getData().getHomePageInfo().getTopBanner().get(i).getAdvPic();
        }
        banner.setDelayTime(3000);
        banner.setImages(bannerUrl);
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                intent = new Intent(context, BannerDetailActivity.class);
                intent.putExtra("webUrl", data.getData().getHomePageInfo().getTopBanner().get(0).getShareInfo().getShareUrl());
                intent.putExtra("title", data.getData().getHomePageInfo().getTopBanner().get(0).getAdvTitle());

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
                        getActivity().startActivity(intent);
                    }
                }).start();
            }
        });
    }

    public void adapterOnClick(final HomeBean data) {
        homeGrViewAdapter.setMyOnClick(new MyOnClick() {
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
