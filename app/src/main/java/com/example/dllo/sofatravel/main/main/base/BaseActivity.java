package com.example.dllo.sofatravel.main.main.base;

<<<<<<< HEAD
import android.app.Activity;
=======
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
>>>>>>> be711b154e1d14091b4d72608dd0a525a48abf8e

/**
 * Created by dllo on 16/7/16.
 */
<<<<<<< HEAD
public class BaseActivity extends Activity {
=======
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();

    }

    //    加载布局的抽象方法
    public abstract int getLayout();

    //    初始化组件的抽象方法
    public abstract void initView();

    //    初始化数据的抽象方法
    public abstract void initData();
>>>>>>> be711b154e1d14091b4d72608dd0a525a48abf8e

}
