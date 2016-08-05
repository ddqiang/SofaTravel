package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.MyApplication;

import java.util.ArrayList;
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
    public void getUserImageSuccess(List<UserInfoBean> list) {
        if (list.size() == 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
            view.getUserImageSuccess(bitmap);
        } else {
            if (list.get(0).getImage() == null) {
                Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                view.getUserImageSuccess(bitmap);
            } else {
                Bitmap bitmap = list.get(0).getImage();
                view.getUserImageSuccess(bitmap);
            }
        }
    }

    @Override
    public void readUserImageSuccess(List<UserInfoBean> list) {
        if (list.size() == 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
            view.readUserImageSuccess(bitmap);
        } else {
            if (list.get(0).getImage() == null) {
                Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                view.readUserImageSuccess(bitmap);
            } else {
                Bitmap bitmap = list.get(0).getImage();
                view.readUserImageSuccess(bitmap);
            }
        }
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
    public void saveUserInfo(UserInfoBean bean) {
        model.saveUserInfoBean(bean);
    }

    @Override
    public void deleteUserOldName(List<UserInfoBean> list) {
        String userNewName = list.get(0).getUserCustomName();
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
    public void loginOrRegisterSaveDefaultUserBeanToLiteOrm(String account, String userName) {
        Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
        UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
        beanForLiteOrm.setImage(bitmap);
        beanForLiteOrm.setAccount(account);
        beanForLiteOrm.setUserName(userName);
        model.loginOrRegisterSaveDefaultUserBeanToLiteOrm(beanForLiteOrm);
    }

    @Override
    public void loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm) {
        view.loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(beanForLiteOrm);
    }

    @Override
    public void changeUserNameForLiteOrm(UserBeanForLiteOrm beanForLiteOrm) {
        model.changeUserNameForLiteOrm(beanForLiteOrm);
    }

    @Override
    public void changeUserNameForLiteOrmSuccess() {
        view.changeUserNameForLiteOrmSuccess();
    }

    @Override
    public void setUserImageForLiteOrm(UserBeanForLiteOrm beanForLiteOrm) {
        model.setUserImageForLiteOrm(beanForLiteOrm);
    }

    @Override
    public void setUserImageForLiteOrmSuccess() {
        view.setUserImageForLiteOrmSuccess();
    }

    @Override
    public void queryUserInfoFromLiteOrm(String account) {
        model.queryUserInfoFromLiteOrm(account);
    }

    @Override
    public void queryUserInfoFromLiteOrmSuccess(ArrayList<UserBeanForLiteOrm> datas) {
        if (datas.size() == 0) {
            UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
            beanForLiteOrm.setUserName("未设置");
            Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
            beanForLiteOrm.setImage(bitmap);
            view.queryUserInfoFromLiteOrmSuccess(beanForLiteOrm);
        } else {
            view.queryUserInfoFromLiteOrmSuccess(datas.get(datas.size() - 1));
        }

    }

    @Override
    public void start() {
        model.setPresenter(this);
        view.setPresenter(this);
    }
}
