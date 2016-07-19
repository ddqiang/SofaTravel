package com.example.dllo.sofatravel.main.main.base;

import android.content.Context;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by dllo on 16/7/18.
 */
public class MyApplication extends android.app.Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Bmob.initialize(this, "31c187fb6686bad6d933ff8e565b53a2");

    }
}
