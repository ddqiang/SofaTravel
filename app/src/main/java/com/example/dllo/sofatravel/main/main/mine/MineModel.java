package com.example.dllo.sofatravel.main.main.mine;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


/**
 * Created by dllo on 16/7/18.
 */
public class MineModel implements MineContract.Model {
    private MineContract.Presenter presenter;


    @Override
    public void checkIsLogin() {//初始判断是否登录
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        if (hasLogin) {
            presenter.hasLogin();
        } else {
            presenter.noLogin();
        }
    }

    @Override
    public void checkHasLogin() {//点击头像判断是否登录
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        if (hasLogin) {
            presenter.hadLogin();
        } else {
            presenter.notLogin();
        }
    }


    @Override
    public void getUserBean(String account) {
        BmobQuery<UserInfoBean> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("account", account);
        bmobQuery.findObjects(MyApplication.context, new FindListener<UserInfoBean>() {
            @Override
            public void onSuccess(List<UserInfoBean> list) {
                if (list.size() != 0) {
                    presenter.deleteUserOldName(list);
                }
            }

            @Override
            public void onError(int i, String s) {
            }
        });
    }

    @Override
    public void getUserImage(String account) {
        BmobQuery<UserInfoBean> beanBmobQuery = new BmobQuery<>();
        beanBmobQuery.addWhereEqualTo("account", account);
        beanBmobQuery.findObjects(MyApplication.context, new FindListener<UserInfoBean>() {
            @Override
            public void onSuccess(List<UserInfoBean> list) {
                presenter.getUserImageSuccess(list);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    @Override
    public void saveUserInfoBean(UserInfoBean bean) {
        bean.save(MyApplication.context, new SaveListener() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onFailure(int i, String s) {

            }
        });
        presenter.saveUserInfoSuccess();
    }

    @Override
    public void queryUserImage(String account) {
        BmobQuery<UserInfoBean> beanBmobQuery = new BmobQuery<>();
        beanBmobQuery.addWhereEqualTo("account", account);
        beanBmobQuery.findObjects(MyApplication.context, new FindListener<UserInfoBean>() {
            @Override
            public void onSuccess(List<UserInfoBean> list) {
                presenter.readUserImageSuccess(list);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    @Override
    public void loginOrRegisterSaveDefaultUserBeanToLiteOrm(UserBeanForLiteOrm beanForLiteOrm) {
        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(beanForLiteOrm);
        presenter.loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(beanForLiteOrm);
    }

    @Override
    public void setUserImageForLiteOrm(UserBeanForLiteOrm beanForLiteOrm) {
        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(beanForLiteOrm);
        presenter.setUserImageForLiteOrmSuccess();
    }

    @Override
    public void changeUserNameForLiteOrm(UserBeanForLiteOrm beanForLiteOrm) {
        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(beanForLiteOrm);
        presenter.changeUserNameForLiteOrmSuccess();
    }

    @Override
    public void queryUserInfoFromLiteOrm(String account) {
        ArrayList<UserBeanForLiteOrm> datas = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(UserBeanForLiteOrm.class).where("account" + " LIKE ?", new Object[]{account}));
        // ArrayList<UserBeanForLiteOrm> datas = MyLiteOrm.getSingleLiteOrm().getUserInfoDatasFromLiteOrm("account", account);
        presenter.queryUserInfoFromLiteOrmSuccess(datas);
    }


    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
