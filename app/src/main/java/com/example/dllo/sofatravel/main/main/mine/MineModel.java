package com.example.dllo.sofatravel.main.main.mine;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.dllo.sofatravel.main.main.base.MyApplication;


/**
 * Created by dllo on 16/7/18.
 */
public class MineModel implements MineContract.Model {
    private MineContract.Presenter presenter;


    @Override
    public void checkIsLogin() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        if (hasLogin) {
            presenter.hasLogin();
        } else {
            presenter.noLogin();
        }
    }

    @Override
    public void checkHasLogin() {
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        if (hasLogin) {
            presenter.hadLogin();
        } else {
            presenter.notLogin();
        }
    }

    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
