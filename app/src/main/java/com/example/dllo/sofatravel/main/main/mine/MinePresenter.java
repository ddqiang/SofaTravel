package com.example.dllo.sofatravel.main.main.mine;

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
    public void isLogin() {
        model.checkIsLogin();
    }

    @Override
    public void hasLogin() {
        view.isLogin(true);
    }

    @Override
    public void noLogin() {
        view.isLogin(false);
    }

    @Override
    public void start() {

    }
}
