package com.example.dllo.sofatravel.main.main.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.home.bannerdetails.BannerDetailActivity;
import com.example.dllo.sofatravel.main.main.home.messagedetails.MessageDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.youth.banner.Banner;

/**
 * Created by dllo on 16/7/18.
 */
public class HomeFragment extends BaseFragment {

    private HeaderGridView headerGridView;
    private HomeGrViewAdapter homeGrViewAdapter;
    private Banner banner;

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        headerGridView = (HeaderGridView) view.findViewById(R.id.home_gridView);
    }

    @Override
    public void initData() {

        homeGrViewAdapter = new HomeGrViewAdapter(context);

        //首页数据解析 and 轮播图
        showHomeOk();
        headerGridView.setAdapter(homeGrViewAdapter);
    }



    private void showHomeOk() {
        View view1 = LayoutInflater.from(context).inflate(R.layout.home_banner, null);
        banner = (Banner) view1.findViewById(R.id.fragment_home_banner);
        headerGridView.addHeaderView(view1);
        OkSingle.getInstance().getMessgeDetail(HomeBean.class, new OkSingle.OnTrue<HomeBean>() {
            @Override
            public void hasData(final HomeBean data) {
                homeGrViewAdapter.setHomeBean(data);
                banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
                banner.setIndicatorGravity(Banner.CENTER);
                String[] bannerUrl = new String[data.getData().getHomePageInfo().getTopBanner().size()];
                for (int i = 0; i < data.getData().getHomePageInfo().getTopBanner().size(); i++) {
                    bannerUrl[i] = data.getData().getHomePageInfo().getTopBanner().get(i).getAdvPic();
                }
                banner.setDelayTime(2000);
                banner.setImages(bannerUrl);
                banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(View view, int position) {
                        Intent intent = new Intent(context, BannerDetailActivity.class);
                        intent.putExtra("webUrl", data.getData().getHomePageInfo().getTopBanner().get(position - 1).getShareInfo().getShareUrl());
                        intent.putExtra("title", data.getData().getHomePageInfo().getTopBanner().get(position - 1).getAdvTitle());
                        getActivity().startActivity(intent);
                    }
                });

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
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

            }
        });
    }

}
