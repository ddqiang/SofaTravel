package com.example.dllo.sofatravel.main.main.search;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.YouthDetailsActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity.MapActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity.SelectCityActivity;
import com.example.dllo.sofatravel.main.main.home.messagedetails.MessageDetailsActivity;

/**
 * Created by dllo on 16/7/18.
 */
public class SearchFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout selectCity;//选择城市
    private RelativeLayout selectTime;//选择时间
    private TextView searchMap;//地图模式
    private TextView cityTv;
    private Button searchBtn;//搜索
    private  TextView listTv;
    private TextView mapTv;


    @Override
    public int setLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView(View view) {
        selectCity = (RelativeLayout) view.findViewById(R.id.frag_search_select_city_layout);//选择城市
        selectCity.setOnClickListener(this);
        selectTime = (RelativeLayout) view.findViewById(R.id.frag_search_select_time_layout);//选择时间
        selectTime.setOnClickListener(this);
        searchMap = (TextView) view.findViewById(R.id.frag_search_map_tv);//地图模式
        searchMap.setOnClickListener(this);
        cityTv = (TextView) view.findViewById(R.id.frag_search_city_tv);//显示城市
        cityTv.setOnClickListener(this);
        searchBtn= (Button) view.findViewById(R.id.frag_search_btn);//搜索button
        searchBtn.setOnClickListener(this);
        listTv= (TextView) view.findViewById(R.id.frag_search_list_tv);

        mapTv= (TextView) view.findViewById(R.id.frag_search_map_tv);


    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag_search_select_city_layout://选择城市
                Intent cityIntent = new Intent(context, SelectCityActivity.class);
                startActivityForResult(cityIntent, 101);
                break;
            case R.id.frag_search_select_time_layout://选择时间
                showCalendarDialog();
                break;
            case R.id.frag_search_map_tv://地图模式
                Intent searchMap=new Intent(context,MapActivity.class);
                startActivity(searchMap);
                break;
            case R.id.frag_search_btn:
                Intent searchBtn=new Intent(context, MessageDetailsActivity.class);
                startActivity(searchBtn);
                break;
        }

    }

    //将获得的城市名称显示在textView上
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            cityTv.setText(data.getStringExtra("city"));
        }
    }

    //显示日历的Dialog
    public void showCalendarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher);
        View view = LayoutInflater.from(context).inflate(R.layout.dis_dialog_calendar, null);
        CalendarView cv = (CalendarView) view.findViewById(R.id.calendar);
        builder.setView(view);
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }


}
