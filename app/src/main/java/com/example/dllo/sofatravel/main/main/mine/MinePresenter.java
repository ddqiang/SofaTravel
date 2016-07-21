package com.example.dllo.sofatravel.main.main.mine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.dllo.sofatravel.main.main.base.MyApplication;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public class MinePresenter implements MineContract.Presenter {
    private MineContract.View view;
    private MineContract.Model model;

    public MinePresenter(MineContract.View view, MineContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void whetherLogin() {
        model.checkHasLogin();
    }

    @Override
    public void isLogin() {
        model.checkIsLogin();
    }

    @Override
    public void getUserImageSuccess(Bitmap bitmap) {
        view.getUserImageSuccess(bitmap);
    }

    @Override
    public void readUserImageSuccess(Bitmap bitmap) {
        view.readUserImageSuccess(bitmap);
    }

    @Override
    public void saveUserBean(String account, String userName) {
        // model.saveUserBean(account, userName);
    }

    @Override
    public void getUserBean(String account) {
        model.getUserBean(account);
    }

    @Override
    public void saveUserInfoSuccess() {
        view.saveUserInfoSuccess();
    }

    @Override
    public void hasLogin() {
        view.isLogin(true);
    }

    @Override
    public void hadLogin() {
        view.whetherLogin(true);
    }

    @Override
    public void noLogin() {
        view.isLogin(false);
    }

    @Override
    public void notLogin() {
        view.whetherLogin(false);
    }

    @Override
    public void saveUserBeanSuccess() {
        // view.saveUserBeanSuccess();
    }

    @Override
    public void saveUserInfo(UserInfoBean bean) {
        model.saveUserInfoBean(bean);
    }

    @Override
    public void deleteUserOldName(List<UserInfoBean> list) {
        String userNewName = list.get(list.size() - 1).getUserName();
        view.getUserBeanSuccess(userNewName);
//        SharedPreferences saveUserName = MyApplication.context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = saveUserName.edit();
//        editor.putString("userName", userNewName);
//        editor.commit();
    }

    @Override
    public void queryUserImage(String account) {
        model.queryUserImage(account);
    }

    @Override
    public void getUserImage(String account) {
        model.getUserImage(account);
    }

    @Override
    public void start() {
        model.setPresenter(this);
        view.setPresenter(this);
    }
}
