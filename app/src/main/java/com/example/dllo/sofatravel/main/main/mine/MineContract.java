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
    }


    interface Presenter extends BasePresenter {
        //Model调用
        void isLogin();

        //View调用
        void hasLogin();

        void noLogin();
    }


    interface Model extends BaseModel<Presenter> {
        void checkIsLogin();
    }


}
