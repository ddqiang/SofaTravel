package com.example.dllo.sofatravel.main.main.mine.loginorregister;


import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.mine.UserBean;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/7/19.
 */
public class LorModel implements LoginOrRegisterContract.LoginOrRegisterModel {
    private LoginOrRegisterContract.LoginOrRegisterPresenter loginOrRegisterPresenter;

    @Override

    public void login(String userName, String password) {
        UserBean user = new UserBean();
        user.setUsername(userName);
        user.setPassword(password);
        user.login(MyApplication.context, new SaveListener() {
            @Override
            public void onSuccess() {
                loginOrRegisterPresenter.loginSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                loginOrRegisterPresenter.loginError("登录 : " + s);
            }
        });
    }

    @Override
    public void register(String userName, String password) {

        final UserBean user = new UserBean();
        user.setUsername(userName);
        user.setPassword(password);
        user.signUp(MyApplication.context, new SaveListener() {
            @Override
            public void onSuccess() {
                user.login(MyApplication.context, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        loginOrRegisterPresenter.registerSuccess();
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
                loginOrRegisterPresenter.registerSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                loginOrRegisterPresenter.registerError("注册失败 : " + s);
            }
        });


    }

    @Override
    public void setDefaultUserName(String accountName) {

    }

    @Override
    public void setPresenter(LoginOrRegisterContract.LoginOrRegisterPresenter presenter) {
        this.loginOrRegisterPresenter = presenter;
    }
}
