package com.example.dllo.sofatravel.main.main.mine.loginorregister;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;

/**
 * Created by dllo on 16/7/19.
 */
public class LoginOrRegisterFragment extends BaseFragment implements LoginOrRegisterContract.LoginOrRegisterView, View.OnClickListener {
    private LoginOrRegisterContract.LoginOrRegisterPresenter presenter;
    private Button login, register;
    private EditText userNameEt, passwordEt;
    private String userName, password;
    private ProgressDialog progressDialogLogin, progressDialogRegister;

    @Override
    public int setLayout() {
        return R.layout.fragment_login_or_register;
    }

    private void showRegisterDialog() {
        if (progressDialogRegister == null) {
            progressDialogRegister = ProgressDialog.show(context, "注册中", "请稍等", true, false);
        } else {
            progressDialogRegister.show();
        }
    }

    private void showLoginDialog() {
        if (progressDialogLogin == null) {
            progressDialogLogin = ProgressDialog.show(context, "登录中", "请稍等", true, false);
        } else {
            progressDialogLogin.show();
        }
    }

    @Override
    public void initView(View view) {
        login = (Button) view.findViewById(R.id.activity_login_or_register_login_btn);
        register = (Button) view.findViewById(R.id.activity_login_or_register_register_btn);
        userNameEt = (EditText) view.findViewById(R.id.activity_login_or_register_user_name_et);
        passwordEt = (EditText) view.findViewById(R.id.activity_login_or_register_password_et);
    }

    @Override
    public void initData() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void loginSuccess() {
        progressDialogLogin.dismiss();
        Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("hasLogin", true);
        editor.commit();//存取当前登录状态
        SharedPreferences accountName = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        SharedPreferences.Editor account = accountName.edit();
        account.putString("accountName", userNameEt.getText().toString());
        account.commit();//存取当前登录账号
        Intent intent = new Intent("changePage");
        context.sendBroadcast(intent);
        getActivity().finish();
    }

    @Override
    public void loginError(String s) {
        progressDialogLogin.dismiss();

        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess() {
        progressDialogRegister.dismiss();
        Toast.makeText(context, "注册成功,已自动登录", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("hasLogin", true);
        editor.commit();//存储登录状态
        SharedPreferences accountName = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        SharedPreferences.Editor account = accountName.edit();
        account.putString("accountName", userNameEt.getText().toString());
        account.commit();//存储当前登录账号
        Intent intent = new Intent("changePage");
        context.sendBroadcast(intent);
        Intent setDefault = new Intent("setDefault");
        context.sendBroadcast(setDefault);
        //presenter.setDefaultUserName(userNameEt.getText().toString());//注册成功设置初始用户名
        getActivity().finish();
    }

    @Override
    public void registerError(String s) {
        progressDialogRegister.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginOrRegisterContract.LoginOrRegisterPresenter Presenter) {
        this.presenter = Presenter;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_or_register_login_btn:
                userName = userNameEt.getText().toString();
                password = passwordEt.getText().toString();
                if (userName == null || password == null || userName.length() * password.length() == 0) {
                    Toast.makeText(context, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                } else {
                    showLoginDialog();
                    presenter.login(userName, password);
                }
                break;
            case R.id.activity_login_or_register_register_btn:
                userName = userNameEt.getText().toString();
                password = passwordEt.getText().toString();
                if (userName == null || password == null || userName.length() * password.length() == 0) {
                    Toast.makeText(context, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                } else {
                    showRegisterDialog();
                    presenter.register(userName, password);
                }
                break;

        }
    }
}
