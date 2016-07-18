package com.example.dllo.sofatravel.main.main.discover;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.YouthDetailsActivity;


/**
 * Created by dllo on 16/7/16.
 */
public class DiscoverFragment extends BaseFragment implements View.OnClickListener {
    private ImageView  youthTravel,music;

    @Override
    public int setLayout() {
        return R.layout.fragment_discover;
    }
    @Override
    public void initView(View view) {
        youthTravel= (ImageView) view.findViewById(R.id.discover_youth_travel);
        music= (ImageView) view.findViewById(R.id.discover_music);
        youthTravel.setOnClickListener(this);
        music.setOnClickListener(this);
    }
    @Override
    public void initData() {
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.discover_youth_travel:
                Intent youth_travel=new Intent(context, YouthDetailsActivity.class);
                startActivity(youth_travel);
                break;
            case R.id.discover_music:
                break;
        }

    }
}
