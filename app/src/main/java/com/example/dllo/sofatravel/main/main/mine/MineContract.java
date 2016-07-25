package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;

import com.example.dllo.sofatravel.main.main.base.BaseModel;
import com.example.dllo.sofatravel.main.main.base.BasePresenter;
import com.example.dllo.sofatravel.main.main.base.BaseView;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.UserInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public interface MineContract {

    interface View extends BaseView<Presenter> {
        void isLogin(boolean isLogin);

        void whetherLogin(boolean whetherLogin);

        void getUserBeanSuccess(String userName);

        void saveUserInfoSuccess();

        void getUserImageSuccess(Bitmap bitmap);

        void readUserImageSuccess(Bitmap bitmap);

        void setUserImageForLiteOrmSuccess();

        void loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm);

        void changeUserNameForLiteOrmSuccess();

        void queryUserInfoFromLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm);
    }


    interface Presenter extends BasePresenter {
        void whetherLogin();//界面生成判断

        void isLogin();

        void getUserImageSuccess(List<UserInfoBean> list);

        void readUserImageSuccess(List<UserInfoBean> list);

        void getUserBean(String account);

        void saveUserInfoSuccess();

        void hasLogin();//点击判断是否登录

        void hadLogin();//界面生成判断是否登录

        void noLogin();

        void notLogin();

        void saveUserInfo(UserInfoBean bean);

        void deleteUserOldName(List<UserInfoBean> list);

        void queryUserImage(String account);

        void getUserImage(String account);

        void loginOrRegisterSaveDefaultUserBeanToLiteOrm(String account, String userName);

        void loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm);

        void changeUserNameForLiteOrm(UserBeanForLiteOrm beanForLiteOrm);

        void changeUserNameForLiteOrmSuccess();

        void setUserImageForLiteOrm(UserBeanForLiteOrm beanForLiteOrm);

        void setUserImageForLiteOrmSuccess();

        void queryUserInfoFromLiteOrm(String account);

        void queryUserInfoFromLiteOrmSuccess(ArrayList<UserBeanForLiteOrm> datas);
    }


    interface Model extends BaseModel<Presenter> {
        void checkIsLogin();//点击判断是否登录

        void checkHasLogin();//判断是否处于登录状态

        void getUserBean(String account);

        void getUserImage(String account);

        void saveUserInfoBean(UserInfoBean bean);

        void queryUserImage(String account);

        void loginOrRegisterSaveDefaultUserBeanToLiteOrm(UserBeanForLiteOrm beanForLiteOrm);

        void setUserImageForLiteOrm(UserBeanForLiteOrm beanForLiteOrm);

        void changeUserNameForLiteOrm(UserBeanForLiteOrm beanForLiteOrm);

        void queryUserInfoFromLiteOrm(String account);
    }


}
