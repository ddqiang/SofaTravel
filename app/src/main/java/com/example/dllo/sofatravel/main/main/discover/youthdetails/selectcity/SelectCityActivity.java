package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.detail.YouthDetailsActivity;
import com.example.dllo.sofatravel.main.main.tools.OkSingle;

/**
 * Created by dllo on 16/7/19.
 */
public class SelectCityActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private ExpandableListView expandableListView;
    private SelectCityBean bean;
    private SelectCityAdapter adapter;
    private String selectUrl = "http://www.shafalvxing.com/city/citySearchInfo.do?bizParams=%7B%7D";
    private RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.activity_dis_select_city;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.discover_select_city_back);
        back.setOnClickListener(this);
        expandableListView = (ExpandableListView) findViewById(R.id.dis_dis_select_lv);
        expandableListView.setGroupIndicator(null); // 去掉箭头



       //城市 点击事件
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(SelectCityActivity.this, YouthDetailsActivity.class);
                intent.putExtra("city",bean.getData().getSearchCity().get(groupPosition).getCity().get(childPosition).getCityNameCh());
                setResult(102, intent);
                finish();
                return false;
            }
        });


    }

    @Override
    public void initData() {
        getRequest();

    }

    public void getRequest() {
        adapter = new SelectCityAdapter(this);
        OkSingle.getInstance().getRequestAsync(selectUrl, SelectCityBean.class, new OkSingle.OnTrue<SelectCityBean>() {
            @Override
            public void hasData(SelectCityBean data) {
                bean = data;
                adapter.setBean(data);
                expandableListView.setAdapter(adapter);
                for (int i = 0; i < data.getData().getSearchCity().size(); i++) {
                    expandableListView.expandGroup(i);
                }
                //字母点击事件
                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        return true;
                    }
                });
                //  添加热门城市
                addHotCity();
            }
        }, new OkSingle.OnError() {
            @Override
            public void noHasData() {

                Toast.makeText(SelectCityActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addHotCity(){
        View view = LayoutInflater.from(this).inflate(R.layout.item_dis_select_hot_city, null);
        GridView gridView = (GridView) view.findViewById(R.id.dis_hot_city_gv);
        HotAdapter adapter = new HotAdapter(this);
        adapter.setBean(bean);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectCityActivity.this, YouthDetailsActivity.class);
                intent.putExtra("city",bean.getData().getHotCity().get(position).getCityNameCh());
                setResult(102,intent);
                finish();
            }
        });
//        recyclerView = (RecyclerView) view.findViewById(R.id.dis_select_hot_city_rv);
//        rvAdapter = new SelectCityHotAdapter(this);
//        rvAdapter.setBean(bean);
//        recyclerView.setAdapter(rvAdapter);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        expandableListView.addHeaderView(view);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discover_select_city_back:
                finish();
                break;
        }
    }


}
