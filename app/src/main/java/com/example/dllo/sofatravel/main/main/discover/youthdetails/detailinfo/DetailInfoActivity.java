package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.DetailAdapter;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.DetailBean;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.YouthDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by dllo on 16/7/20.
 */
public class DetailInfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView hotelName, introEditor;
    private DetailInfoBean bean;
    private String hotelId;
    private ImageView back;
    private DetailBedBean bedBean;//床位信息bean;
    private DetailInfoAdpter detailInfoAdpter;
    private ExpandableListView expandableListView;
    private Banner banner;
    private ImageView imageHead;
    private String[] imageURL;

    @Override
    public int getLayout() {
        return R.layout.activity_dis_detail_info;
    }

    @Override
    public void initView() {
        hotelName = (TextView) findViewById(R.id.dis_detail_info_share_title);
        introEditor = (TextView) findViewById(R.id.dis_detail_info_intro_editor);
        back = (ImageView) findViewById(R.id.dis_detail_info_back);
        back.setOnClickListener(this);
        expandableListView = (ExpandableListView) findViewById(R.id.dis_detail_info_expandable_lv);
        banner = (Banner) findViewById(R.id.dis_detail_info_banner);

    }

    @Override
    public void initData() {
        getRequest();
        getInfoBedRequest();
    }

    //解析轮播图数据
    public void getRequest() {
        hotelId = getIntent().getStringExtra("hotelId");
        OkSingle.getInstance().getHotelDeatil(hotelId, DetailInfoBean.class, new OkSingle.OnTrue<DetailInfoBean>() {
            @Override
            public void hasData(DetailInfoBean data) {
                int num = 0;
                for (int i = 0; i < data.getData().getPictureList().size(); i++) {
                    num += data.getData().getPictureList().get(i).getPictureList().size();
                }
                imageURL = new String[num];
                int k = 0;
                for (int i = 0; i < data.getData().getPictureList().size(); i++) {
                    for (int j = 0; j < data.getData().getPictureList().get(i).getPictureList().size(); j++) {
                        imageURL[k] = data.getData().getPictureList().get(i).getPictureList().get(j);
                        k++;
                    }
                }
                banner.setImages(imageURL);
                banner.setDelayTime(2000);
                hotelName.setText(data.getData().getActivityDto().getShareTitle());
                introEditor.setText(data.getData().getIntroEditor());
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

            }
        });

//            OkSingle.getInstance().getRequestAsync(infoUrl, DetailInfoBean.class, new OkSingle.OnTrue<DetailInfoBean>() {
//            @Override
//            public void hasData(DetailInfoBean data) {
//                hotelName.setText(data.getData().getActivityDto().getShareTitle());
//                introEditor.setText(data.getData().getIntroEditor());
//
//            }
//        }, new OkSingle.OnError() {
//            @Override
//            public void noHasData() {
//                Toast.makeText(DetailInfoActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    // 解析床位数据
    public void getInfoBedRequest() {
        detailInfoAdpter = new DetailInfoAdpter(this);
        hotelId = getIntent().getStringExtra("hotelId");
        final Long startTime = System.currentTimeMillis();
        final Long endTime = startTime + 24 * 60 * 60 * 1000;
        String bedUrl = "http://www.shafalvxing.com/hotel/queryHotelDetailRmList.do?bizParams=%7B%22"
                + "startTime%22%3A"+startTime+"%2C%22endTime%22%3A"+endTime+"%2C%22hotelId%22%3A%22" + hotelId + "%22%7D";
        Log.d("DetailInfoActivity", bedUrl);
        OkSingle.getInstance().getRequestAsync(bedUrl, DetailBedBean.class, new OkSingle.OnTrue<DetailBedBean>() {
            @Override
            public void hasData(DetailBedBean data) {
                bedBean = data;
                detailInfoAdpter.setBean(data);
                expandableListView.setAdapter(detailInfoAdpter);
//                for (int i = 0; i < data.getData().getRmlist().size(); i++) {
//                    expandableListView.expandGroup(i);
//                }
//                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//                    @Override
//                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                        return true;
//                    }
//                });
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Log.d("DetailInfoActivity", simpleDateFormat.format(new Date(startTime)));
                Log.d("DetailInfoActivity", simpleDateFormat.format(new Date(endTime)));
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {
                Toast.makeText(DetailInfoActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dis_detail_info_back:
                finish();
                break;
        }
    }
}
