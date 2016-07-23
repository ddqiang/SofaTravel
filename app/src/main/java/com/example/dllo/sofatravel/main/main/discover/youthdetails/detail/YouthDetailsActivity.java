package com.example.dllo.sofatravel.main.main.discover.youthdetails.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo.DetailInfoActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo.DetailInfoAdpter;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.search.SearchDetailActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity.MapActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity.SelectCityActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by dllo on 16/7/18.
 */
public class YouthDetailsActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout checkInTime, checkOutTime, search, location;//入住,离开,搜索,选择城市
    private ImageView back;//返回
    private TextView cityTv;
    private TextView inTimeTv, outTimeTv;//入住日期,离开日期
    private boolean isIn = true;
    private int in, out;
    private TextView sum;//共~晚
    private ImageView map;//地图
    private DetailBean bean;
    private String city = "%e5%a4%a7%e8%bf%9e";


    private DetailAdapter adapter;
    private ListView detailList;


    @Override
    public int getLayout() {
        return R.layout.activity_discover_detail;
    }

    @Override
    public void initView() {
        checkInTime = (LinearLayout) findViewById(R.id.dis_check_in_time);//入住时间
        checkInTime.setOnClickListener(this);
        checkOutTime = (LinearLayout) findViewById(R.id.dis_check_out_time);//离开时间
        checkOutTime.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.discover_detail_back);//返回
        back.setOnClickListener(this);
        search = (LinearLayout) findViewById(R.id.discover_detail_search);//搜索
        search.setOnClickListener(this);
        location = (LinearLayout) findViewById(R.id.dis_detail_location);
        location.setOnClickListener(this);
        inTimeTv = (TextView) findViewById(R.id.dis_in_time_tv);
        outTimeTv = (TextView) findViewById(R.id.dis_out_time_tv);
        sum = (TextView) findViewById(R.id.dis_sum);
        map = (ImageView) findViewById(R.id.discover_detail_map);//地图
        cityTv = (TextView) findViewById(R.id.discover_detail_location);
        map.setOnClickListener(this);
        detailList = (ListView) findViewById(R.id.discover_detail_list);
    }

    @Override
    public void initData() {
        Date now = new Date();
        int year = now.getYear() + 1900;
        int month = now.getMonth() + 1;
        int day = now.getDate();
        inTimeTv.setText(year + "年" + month + "月" + day + "日");
        outTimeTv.setText(year + "年" + month + "月" + (day + 1) + "日");
        getRequest();

        //行点击事件
        detailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailInfo = new Intent(YouthDetailsActivity.this, DetailInfoActivity.class);
                detailInfo.putExtra("hotelId",bean.getData().getResult().get(position).getHotelId());
                Log.d("YouthDetailsActivity", bean.getData().getResult().get(position).getHotelId());
                startActivity(detailInfo);
            }
        });
    }

    //解析数据
    public void getRequest() {
//        String youthUrl = "http://www.shafalvxing.com/hotel/getHotelListByCity.do?bizParams=" +
//                "%7B%22startTime%22%3A1469148387184%2C%22endPrice%22%3A0%2C%22endTime%22%3A1469234787184%2C%22district%22%3A%22%22%2C%22" +
//                "startPrice%22%3A0%2C%22page%22%3A1%2C%22cityName%22%3A%22"+city+"%e5%B8%82%22%7D";
        adapter = new DetailAdapter(this);
        OkSingle.getInstance().getYouthDeatil(city, DetailBean.class, new OkSingle.OnTrue<DetailBean>() {
            @Override
            public void hasData(DetailBean data) {
                Log.d("YouthDetailsActivity", "data:" + data);
                bean = data;
                adapter.setBean(data);
                detailList.setAdapter(adapter);
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {
            }
        });
//        OkSingle.getInstance().getRequestAsync(youthUrl, DetailBean.class, new OkSingle.OnTrue<DetailBean>() {
//            @Override
//            public void hasData(DetailBean data) {
//                bean = data;
//                adapter.setBean(data);
//                detailList.setAdapter(adapter);
//
//            }
//        }, new OkSingle.OnError() {
//            @Override
//            public void noHasData() {
//                Toast.makeText(YouthDetailsActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discover_detail_back://返回
                finish();
                break;
            case R.id.discover_detail_search://搜索
                Intent searchDetail = new Intent(this, SearchDetailActivity.class);
                startActivity(searchDetail);
                break;
            case R.id.dis_detail_location://选择城市
                Intent locationDetail = new Intent(this, SelectCityActivity.class);
                startActivityForResult(locationDetail, 101);
                break;
            case R.id.discover_detail_map://地图
                Intent mapIntent = new Intent(YouthDetailsActivity.this, MapActivity.class);
                startActivity(mapIntent);
                break;
            case R.id.dis_check_in_time://入住
                showCalendarDialog();
                isIn = true;
                break;
            case R.id.dis_check_out_time://离开
                showCalendarDialog();
                isIn = false;
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 101:
                if (data != null) {
                    cityTv.setText(data.getStringExtra("city"));
                    city = encoder(data.getStringExtra("city"));
                    getRequest();
                }
                break;
        }

    }

    //显示日历的Dialog
    public void showCalendarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        View view = LayoutInflater.from(this).inflate(R.layout.dis_dialog_calendar, null);
        CalendarView cv = (CalendarView) view.findViewById(R.id.calendar);
        //选择年月日
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("YouthDetailsActivity", "month:" + month);
                if (isIn) {
                    inTimeTv.setText(year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                    in = dayOfMonth;
                    isIn = false;
                } else {
                    outTimeTv.setText(year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                    isIn = true;
                    out = dayOfMonth;
                }
                Toast.makeText(YouthDetailsActivity.this, "选择日期" + dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isIn) {
                    sum.setText("共" + (out - in) + "晚");
                }
                Toast.makeText(YouthDetailsActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    // 转码
    public String encoder(String city){
        String s = "";
        try {
            s = URLEncoder.encode(city,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }



}
