package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.DetailAdapter;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.DetailBean;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.YouthDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;

/**
 * Created by dllo on 16/7/20.
 */
public class DetailInfoActivity extends BaseActivity {
    private TextView hotelName,introEditor;
    private DetailInfoBean bean;
    private DetailInfoAdpter adpter;
    private String hotelId;
    @Override
    public int getLayout() {
        return R.layout.activity_dis_detail_info;
    }
    @Override
    public void initView() {
        hotelName= (TextView) findViewById(R.id.dis_detail_info_share_title);
        introEditor= (TextView) findViewById(R.id.dis_detail_info_intro_editor);
    }
    @Override
    public void initData() {
        getRequest();
    }
    //解析数据
    public void getRequest() {
        hotelId = getIntent().getStringExtra("hotelId");
//        Log.d("DetailInfoActivity", hotelId);
//        String infoUrl = "http://www.shafalvxing.com/hotel/queryHotelDetail.do?bizParams=" +
//                "%7B%22endTime%22%3A1469158423376%2C%22hotelId%22%3A%22"+hotelId+"%22%2C%22startTime%22%3A1469072023376%7D";
        OkSingle.getInstance().getHotelDeatil(hotelId, DetailInfoBean.class, new OkSingle.OnTrue<DetailInfoBean>() {
                    @Override
                    public void hasData(DetailInfoBean data) {
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

}
