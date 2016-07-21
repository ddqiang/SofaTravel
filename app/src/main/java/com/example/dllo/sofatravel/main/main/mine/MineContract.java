package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;

import com.example.dllo.sofatravel.main.main.base.BaseModel;
import com.example.dllo.sofatravel.main.main.base.BasePresenter;
import com.example.dllo.sofatravel.main.main.base.BaseView;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public interface MineContract {

    interface View extends BaseView<Presenter> {
        void isLogin(boolean isLogin);

        void whetherLogin(boolean whetherLogin);

        void saveUserBeanSuccess();

        void getUserBeanSuccess(String userName);

        void saveUserInfoSuccess();

        void getUserImageSuccess(Bitmap bitmap);

        void readUserImageSuccess(Bitmap bitmap);
    }


    interface Presenter extends BasePresenter {
        void whetherLogin();//界面生成判断

        void isLogin();

        void getUserImageSuccess(Bitmap bitmap);

        void readUserImageSuccess(Bitmap bitmap);

        void saveUserBean(String account, String userName);

        void getUserBean(String account);

        void saveUserInfoSuccess();

        void hasLogin();//点击判断是否登录

        void hadLogin();//界面生成判断是否登录

        void noLogin();

        void notLogin();

        void saveUserBeanSuccess();

        void saveUserInfo(UserInfoBean bean);

        void deleteUserOldName(List<UserInfoBean> list);

        void queryUserImage(String account);

        void getUserImage(String account);
    }


    interface Model extends BaseModel<Presenter> {
        void checkIsLogin();//点击判断是否登录

        void checkHasLogin();//判断是否处于登录状态

        void saveUserBean(String account, String userName);

        void getUserBean(String account);

        void getUserImage(String account);

        void saveUserInfoBean(UserInfoBean bean);

        void queryUserImage(String account);
    }


}
