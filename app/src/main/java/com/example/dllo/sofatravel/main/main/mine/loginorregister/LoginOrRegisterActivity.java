package com.example.dllo.sofatravel.main.main.mine.loginorregister;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.mine.MineContract;

/**
 * Created by dllo on 16/7/18.
 */
public class LoginOrRegisterActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_login_or_register;
    }

    @Override
    public void initView() {
        LoginOrRegisterFragment fragment = new LoginOrRegisterFragment();
        LorModel model = new LorModel();
        LorPresenter presenter = new LorPresenter(model, fragment);
        fragment.setPresenter(presenter);
        model.setPresenter(presenter);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_login_or_register_framelayout, fragment).commit();
    }

    @Override
    public void initData() {

    }
}
