package com.example.dllo.sofatravel.main.main.base;

import android.content.Context;

/**
 * Created by dllo on 16/7/18.
 */
public class MyApplication extends android.app.Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
