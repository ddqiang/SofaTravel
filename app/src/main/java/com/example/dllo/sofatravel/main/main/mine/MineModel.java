package com.example.dllo.sofatravel.main.main.mine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.MyApplication;

import java.util.BitSet;
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
    public void saveUserBean(String account, String userName) {
//        UserInfoBean userNameBean = new UserInfoBean();
//        userNameBean.setAccountName(account);
//        userNameBean.setUserName(userName);
//        userNameBean.save(MyApplication.context, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                presenter.saveUserBeanSuccess();
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//            }
//        });
    }

    @Override
    public void getUserBean(String account) {
        BmobQuery<UserInfoBean> bmobQuery = new BmobQuery<UserInfoBean>();
        bmobQuery.addWhereEqualTo("accountName", account);
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
        BmobQuery<UserInfoBean> beanBmobQuery = new BmobQuery<UserInfoBean>();
        beanBmobQuery.addWhereEqualTo("accountName", account);
        beanBmobQuery.findObjects(MyApplication.context, new FindListener<UserInfoBean>() {
            @Override
            public void onSuccess(List<UserInfoBean> list) {
                if (list.size() == 0) {
                    Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                    presenter.getUserImageSuccess(bitmap);
                } else {
                    if (list.get(list.size() - 1).getImage() == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                        presenter.getUserImageSuccess(bitmap);
                    } else {
                        Bitmap bitmap = list.get(list.size() - 1).getImage();
                        presenter.getUserImageSuccess(bitmap);
                    }
                }
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
                presenter.saveUserInfoSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
            }
        });
    }

    @Override
    public void queryUserImage(String account) {
        BmobQuery<UserInfoBean> beanBmobQuery = new BmobQuery<UserInfoBean>();
        beanBmobQuery.addWhereEqualTo("accountName", account);
        beanBmobQuery.findObjects(MyApplication.context, new FindListener<UserInfoBean>() {
            @Override
            public void onSuccess(List<UserInfoBean> list) {
                if (list.size() == 0) {
                    Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                    presenter.readUserImageSuccess(bitmap);
                } else {
                    if (list.get(list.size() - 1).getImage() == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.context.getResources(), R.mipmap.ic_launcher_one);
                        presenter.readUserImageSuccess(bitmap);
                    } else {
                        Bitmap bitmap = list.get(list.size() - 1).getImage();
                        presenter.readUserImageSuccess(bitmap);
                    }
                }
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }


    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
