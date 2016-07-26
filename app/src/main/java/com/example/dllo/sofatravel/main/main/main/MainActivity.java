package com.example.dllo.sofatravel.main.main.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;

import com.example.dllo.sofatravel.main.main.discover.DiscoverFragment;
import com.example.dllo.sofatravel.main.main.home.HomeFragment;
import com.example.dllo.sofatravel.main.main.mine.MineContract;
import com.example.dllo.sofatravel.main.main.mine.MineFragment;
import com.example.dllo.sofatravel.main.main.mine.MineModel;
import com.example.dllo.sofatravel.main.main.mine.MinePresenter;
import com.example.dllo.sofatravel.main.main.order.OrderFragment;
import com.example.dllo.sofatravel.main.main.search.SearchFragment;
import com.litesuits.orm.LiteOrm;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton home, discover, search, order, mine;
    private TextView homeTv, discoverTv, searchTv, orderTv, mineTv;
    private MineFragment mineFragment;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        home = (RadioButton) findViewById(R.id.home_tab);
        discover = (RadioButton) findViewById(R.id.discover_tab);
        order = (RadioButton) findViewById(R.id.order_tab);
        mine = (RadioButton) findViewById(R.id.mine_tab);
        search = (RadioButton) findViewById(R.id.search_tab);

        homeTv = (TextView) findViewById(R.id.home_tab_text);
        discoverTv = (TextView) findViewById(R.id.discover_tab_text);
        searchTv = (TextView) findViewById(R.id.search_tab_text);
        orderTv = (TextView) findViewById(R.id.order_tab_text);
        mineTv = (TextView) findViewById(R.id.mine_tab_text);

        home.setOnClickListener(this);
        search.setOnClickListener(this);
        discover.setOnClickListener(this);
        order.setOnClickListener(this);
        mine.setOnClickListener(this);
    }

    @Override
    public void initData() {


        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        FragmentManager managerOne = getSupportFragmentManager();
        FragmentTransaction transactionOne = managerOne.beginTransaction();
        transactionOne.replace(R.id.show_fragment_fl, new HomeFragment());
        homeTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
        transactionOne.commit();

        mineFragment = new MineFragment();
        MineContract.Model model = new MineModel();
        MineContract.Presenter presenter = new MinePresenter(mineFragment, model);
        mineFragment.setPresenter(presenter);
        model.setPresenter(presenter);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.home_tab:
                transaction.replace(R.id.show_fragment_fl, new HomeFragment());

                homeTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
                discoverTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                searchTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                orderTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                mineTv.setTextColor(android.graphics.Color.parseColor("#000000"));

                break;
            case R.id.discover_tab:
                transaction.replace(R.id.show_fragment_fl, new DiscoverFragment());

                homeTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                discoverTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
                searchTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                orderTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                mineTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                break;
            case R.id.search_tab:
                transaction.replace(R.id.show_fragment_fl, new SearchFragment());

                homeTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                discoverTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                searchTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
                orderTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                mineTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                break;
            case R.id.order_tab:
                transaction.replace(R.id.show_fragment_fl, new OrderFragment());

                homeTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                discoverTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                searchTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                orderTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
                mineTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                break;
            case R.id.mine_tab:
                transaction.replace(R.id.show_fragment_fl, mineFragment);

                homeTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                discoverTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                searchTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                orderTv.setTextColor(android.graphics.Color.parseColor("#000000"));
                mineTv.setTextColor(android.graphics.Color.parseColor("#A3D9DB"));
                break;
        }
        transaction.commit();
    }
}
