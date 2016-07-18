package com.example.dllo.sofatravel.main.main.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;

/**
 * Created by dllo on 16/7/18.
 */
public class MineFragment extends BaseFragment implements MineContract.View {
    private MineContract.Presenter presenter;
    private ImageView userImage;
    private RelativeLayout space, share, feedBack, telNumber, setUp;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        userImage = (ImageView) view.findViewById(R.id.fragment_mine_user_image);
        space = (RelativeLayout) view.findViewById(R.id.fragment_mine_release_layout);
        share = (RelativeLayout) view.findViewById(R.id.fragment_mine_share_layout);
        feedBack = (RelativeLayout) view.findViewById(R.id.fragment_mine_suggestion_layout);
        telNumber = (RelativeLayout) view.findViewById(R.id.fragment_mine_telnumber_layout);
        setUp = (RelativeLayout) view.findViewById(R.id.fragment_mine_setup_layout);
    }

    @Override
    public void initData() {
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.isLogin();
            }
        });


    }

    @Override
    public void setPresenter(MineContract.Presenter Presenter) {
        this.presenter = Presenter;
    }

    @Override
    public void isLogin(boolean isLogin) {

    }
}
