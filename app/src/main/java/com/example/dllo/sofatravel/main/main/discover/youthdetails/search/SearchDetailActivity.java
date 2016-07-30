package com.example.dllo.sofatravel.main.main.discover.youthdetails.search;

import android.view.View;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;


/**
 * Created by dllo on 16/7/19.
 */
public class SearchDetailActivity extends BaseActivity implements View.OnClickListener {
    private TextView cancel;

    @Override
    public int getLayout() {
        return R.layout.activity_dis_search;
    }

    @Override
    public void initView() {
        cancel = (TextView) findViewById(R.id.dis_search_cancel);//取消
        cancel.setOnClickListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dis_search_cancel:

                finish();
                break;
        }
    }
}
