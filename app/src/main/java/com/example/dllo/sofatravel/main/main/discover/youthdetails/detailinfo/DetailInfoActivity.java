package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.util.Log;
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
import com.youth.banner.Banner;


/**
 * Created by dllo on 16/7/20.
 */
public class DetailInfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView hotelName,introEditor;
    private DetailInfoBean bean;
    private DetailInfoAdpter adpter;
    private String hotelId;
    private ImageView back;
    private  DetailBedBean bedBean;//床位信息bean;
    private  DetailInfoAdpter detailInfoAdpter;
    private ExpandableListView expandableListView;
    private Banner banner;
    @Override
    public int getLayout() {
        return R.layout.activity_dis_detail_info;
    }
    @Override
    public void initView() {
        hotelName= (TextView) findViewById(R.id.dis_detail_info_share_title);
        introEditor= (TextView) findViewById(R.id.dis_detail_info_intro_editor);
        back= (ImageView) findViewById(R.id.dis_detail_info_back);
        back.setOnClickListener(this);
    }
    @Override
    public void initData() {
        getRequest();
        getInfoBedRequest();
    }
    //解析数据
    public void getRequest() {
        hotelId = getIntent().getStringExtra("hotelId");
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
    public  void getInfoBedRequest(){
        detailInfoAdpter=new DetailInfoAdpter(this);
        expandableListView=new ExpandableListView(this);
        OkSingle.getInstance().getInfoBed(DetailBedBean.class, new OkSingle.OnTrue<DetailBedBean>() {
            @Override
            public void hasData(DetailBedBean data) {
                bedBean = data;
                detailInfoAdpter.setBean(data);
                expandableListView.setAdapter(detailInfoAdpter);

            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

            }
    });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dis_detail_info_back:
                finish();
               break;
        }
    }
}
