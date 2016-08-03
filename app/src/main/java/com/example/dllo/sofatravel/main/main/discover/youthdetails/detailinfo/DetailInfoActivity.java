package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.order.DisOrderActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;
import com.youth.banner.Banner;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by dllo on 16/7/20.
 */
public class DetailInfoActivity extends BaseActivity implements View.OnClickListener, LocationSource, AMapLocationListener {
    private TextView hotelName, introEditor;//旅店名称,简介
    private DetailInfoBean bean;
    private String hotelId;
    private ImageView back;//返回
    private DetailBedBean bedBean;//床位信息bean;
    private ExpandableListView expandableListView;
    private BedAdapter bedAdapter;
    private ListView bedListView;


    private Banner banner;
    private String[] imageURL;
    private RatingBar ratingBar;

    private MapView infoMap;
    private AMapLocationClientOption mLocationOption;//定位
    private AMap aMap;
    private LocationSource.OnLocationChangedListener mListener;


    @Override
    public int getLayout() {
        return R.layout.activity_dis_detail_info;
    }

    @Override
    public void initView() {
        hotelName = (TextView) findViewById(R.id.dis_detail_info_share_title);//名称
        introEditor = (TextView) findViewById(R.id.dis_detail_info_intro_editor);//简介
        back = (ImageView) findViewById(R.id.dis_detail_info_back);//返回
        back.setOnClickListener(this);
        bedListView = (ListView) findViewById(R.id.dis_detail_info_expandable_lv);
        // expandableListView = (ExpandableListView) findViewById(R.id.dis_detail_info_expandable_lv);
        banner = (Banner) findViewById(R.id.dis_detail_info_banner);//轮播图
        ratingBar = (RatingBar) findViewById(R.id.dis_detail_info_ratingbar);
        infoMap = (MapView) findViewById(R.id.dis_info_map);//地图
        // infoMap.onCreate(null);
        // initMap();
        bedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DetailInfoActivity.this, DisOrderActivity.class);
                intent.putExtra("price",bedBean.getData().getRmlist().get(position).getPrice());
                intent.putExtra("hotelName",bean.getData().getHotelName());
                intent.putExtra("rooms",bedBean.getData().getRmlist().get(position).getAvailableRooms());
                intent.putExtra("picture",bedBean.getData().getRmlist().get(position).getRmTypeImageUrl());
                intent.putExtra("address",bean.getData().getAddress());
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        getRequest();
        getInfoBedRequest();
        bedListView.setFocusable(false);

    }

    //解析轮播图数据
    public void getRequest() {
        hotelId = getIntent().getStringExtra("hotelId");
        OkSingle.getInstance().getHotelDeatil(hotelId, DetailInfoBean.class, new OkSingle.OnTrue<DetailInfoBean>() {
            @Override
            public void hasData(DetailInfoBean data) {
                bean = data;
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
                Log.d("DetailInfoActivity", "data.getData().getCommentScore():" + data.getData().getCommentScore());
                ratingBar.setRating((float) data.getData().getCommentScore());
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {
            }
        });
    }

    // 解析床位数据
    public void getInfoBedRequest() {
        bedAdapter = new BedAdapter(this);
        hotelId = getIntent().getStringExtra("hotelId");
        final Long startTime = System.currentTimeMillis();
        final Long endTime = startTime + 24 * 60 * 60 * 1000;
        String bedUrl = "http://www.shafalvxing.com/hotel/queryHotelDetailRmList.do?bizParams=%7B%22" +
                "endTime%22%3A"+endTime+"%2C%22hotelId%22%3A%22"+hotelId+"%22%2C%22startTime%22%3A"+startTime+"%7D";
        Log.d("DetailInfoActivity", bedUrl);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Log.d("DetailInfoActivity", simpleDateFormat.format(startTime));
//        Log.d("DetailInfoActivity", simpleDateFormat.format(endTime));

        OkSingle.getInstance().getRequestAsync(bedUrl, DetailBedBean.class, new OkSingle.OnTrue<DetailBedBean>() {
            @Override
            public void hasData(DetailBedBean data) {
             //   Log.d("DetailInfoActivity", "data.getData().getRmlist().size():" + data.getData().getRmlist().size());
                bedBean = data;
                bedAdapter.setBean(data);
                bedListView.setAdapter(bedAdapter);
                setListViewHeightBasedOnChildren(bedListView);
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


    //  设置listView高度
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);

    }
    //设置ExpandableListView高度
    public void setListViewHeightBasedOnChildren(ExpandableListView listView) {
        // 获取ListView对应的Adapter
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        if (listAdapter == null) {
            // pre -condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getGroupCount(); i++) { // listAdapter.getCount()返回数据项的数目
            View listgroupItem = listAdapter.getGroupView(i, true, null, listView);
            listgroupItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listgroupItem.getMeasuredHeight(); // 统计所有子项的总高度
            Log.d("DetailInfoAdpter", "height : group" + i + "次" + totalHeight);
            for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                View listchildItem = listAdapter.getChildView(i, j, false, null, listView);
                listchildItem.measure(0, 0); // 计算子项View 的宽高
                totalHeight += listchildItem.getMeasuredHeight(); // 统计所有子项的总高度
                Log.d("DetailInfoAdpter", "height :" + "group:" + i + " child:" + j + "次" + totalHeight);
            }
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    /**
     * 地图
     */
    public void initMap() {
        aMap = infoMap.getMap();
        aMap.setLocationSource(this);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认按钮是否显示
        aMap.setMyLocationEnabled(true);
        //设置定位类型定位模式
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setNeedAddress(true);
        mLocationOption.setOnceLocation(false);
        AMapLocationClient mlocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //高精度模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //定位间隔
        mLocationOption.setInterval(2000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        if (mLocationOption.isOnceLocation()) {
            mLocationOption.setOnceLocation(true);
        }
        //启动定位
        mlocationClient.startLocation();

    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
//        infoMap.onDestroy();
//        AMapLocationClient mlocationClient = new AMapLocationClient(this);
//        mlocationClient.stopLocation();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
//        infoMap.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
//        infoMap.onPause();
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
//        infoMap.onSaveInstanceState(outState);
//    }
//
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        this.mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                Log.d("MainActivity", "chrnggong");
                aMapLocation.getLocationType();
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                Log.d("MainActivity", aMapLocation.getCity());//城市信息

                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码
                aMapLocation.getAoiName();//获取当前定位点的AOI信息
                mListener.onLocationChanged(aMapLocation);
            } else {
                Log.d("xx", aMapLocation.getErrorCode() + "//" + aMapLocation.getErrorInfo());
            }
        }
    }

}
