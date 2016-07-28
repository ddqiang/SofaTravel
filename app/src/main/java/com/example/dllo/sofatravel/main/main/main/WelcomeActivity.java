package com.example.dllo.sofatravel.main.main.main;

import android.content.Intent;
import android.os.CountDownTimer;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.tools.MetaballView;

/**
 * Created by dllo on 16/7/27.
 */
public class WelcomeActivity extends BaseActivity {
    private MetaballView metaballView;
    private CountDownTimer timer;

    @Override
    public int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        metaballView = (MetaballView) findViewById(R.id.metaball);
    }

    @Override
    public void initData() {
        metaballView.setPaintMode(1);
        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
