package com.example.dllo.sofatravel.main.main.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.home.HomeFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton home, discover, search, order, mine;

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

        home.setOnClickListener(this);
        search.setOnClickListener(this);
        discover.setOnClickListener(this);
        order.setOnClickListener(this);
        mine.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.home_tab:
                transaction.replace(R.id.show_fragment_fl, new HomeFragment());
                break;
            case R.id.discover_tab:
                break;
            case R.id.search_tab:
                break;
            case R.id.order_tab:
                break;
            case R.id.mine_tab:
                break;
        }
        transaction.commit();
    }
}
