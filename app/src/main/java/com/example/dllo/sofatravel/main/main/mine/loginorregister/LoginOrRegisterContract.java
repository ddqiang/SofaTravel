package com.example.dllo.sofatravel.main.main.mine.loginorregister;

import com.example.dllo.sofatravel.main.main.base.BaseModel;
import com.example.dllo.sofatravel.main.main.base.BasePresenter;
import com.example.dllo.sofatravel.main.main.base.BaseView;
import com.example.dllo.sofatravel.main.main.mine.MineContract;

/**
 * Created by dllo on 16/7/18.
 */
public interface LoginOrRegisterContract {

    interface LoginOrRegisterView extends BaseView<LoginOrRegisterPresenter> {
        void loginSuccess();

        void loginError(String s);

        void registerSuccess();

        void registerError(String s);


    }

    interface LoginOrRegisterModel extends BaseModel<LoginOrRegisterPresenter> {
        void login(String userName, String password);

        void register(String userName, String password);

        void setDefaultUserName(String accountName);

    }

    interface LoginOrRegisterPresenter extends BasePresenter {


        void login(String userName, String password);

        void register(String userName, String password);

        void loginSuccess();

        void loginError(String s);

        void registerSuccess();

        void registerError(String s);

        void setDefaultUserName(String accountName);

    }


}
