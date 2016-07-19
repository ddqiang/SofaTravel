package com.example.dllo.sofatravel.main.main.mine;

import com.example.dllo.sofatravel.main.main.base.BaseModel;
import com.example.dllo.sofatravel.main.main.base.BasePresenter;
import com.example.dllo.sofatravel.main.main.base.BaseView;

/**
 * Created by dllo on 16/7/18.
 */
public interface MineContract {

    interface View extends BaseView<Presenter> {
        void isLogin(boolean isLogin);

        void whetherLogin(boolean whetherLogin);
    }


    interface Presenter extends BasePresenter {
        void whetherLogin();//界面生成判断

        //Model调用
        void isLogin();

        //View调用
        void hasLogin();//点击判断是否登录

        void hadLogin();//界面生成判断是否登录

        void noLogin();

        void notLogin();
    }


    interface Model extends BaseModel<Presenter> {
        void checkIsLogin();//点击判断是否登录
        void checkHasLogin();//判断是否处于登录状态
    }


}
