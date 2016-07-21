package com.example.dllo.sofatravel.main.main.mine.loginorregister;

/**
 * Created by dllo on 16/7/19.
 */
public class LorPresenter implements LoginOrRegisterContract.LoginOrRegisterPresenter {
    private LoginOrRegisterContract.LoginOrRegisterView view;
    private LoginOrRegisterContract.LoginOrRegisterModel model;

    public LorPresenter(LoginOrRegisterContract.LoginOrRegisterModel model, LoginOrRegisterContract.LoginOrRegisterView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void login(String userName, String password) {
        model.login(userName, password);
    }

    @Override
    public void register(String userName, String password) {
        model.register(userName, password);
    }

    @Override
    public void loginSuccess() {
        view.loginSuccess();
    }

    @Override
    public void loginError(String s) {
        view.loginError(s);
    }

    @Override
    public void registerSuccess() {
        view.registerSuccess();
    }

    @Override
    public void registerError(String s) {
        view.registerError(s);
    }

    @Override
    public void setDefaultUserName(String accountName) {
        model.setDefaultUserName(accountName);
    }

    @Override
    public void start() {
        view.setPresenter(this);
        model.setPresenter(this);
    }
}
