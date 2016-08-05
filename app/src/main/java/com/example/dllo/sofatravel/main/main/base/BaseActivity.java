package com.example.dllo.sofatravel.main.main.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.tools.logutil.LogUtil;

import butterknife.ButterKnife;
import butterknife.internal.ButterKnifeProcessor;

/**
 * Created by dllo on 16/7/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TGA="aaaa";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.inject(this);
        initView();
        initData();
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }

    //    加载布局的抽象方法
    public abstract int getLayout();

    //    初始化组件的抽象方法
    public abstract void initView();

    //    初始化数据的抽象方法
    public abstract void initData();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }
}
