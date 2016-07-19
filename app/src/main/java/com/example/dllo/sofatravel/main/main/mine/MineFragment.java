package com.example.dllo.sofatravel.main.main.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LoginOrRegisterActivity;


/**
 * Created by dllo on 16/7/18.
 */
public class MineFragment extends BaseFragment implements MineContract.View, View.OnClickListener {
    private MineContract.Presenter presenter;
    private ImageView userImage;
    private RelativeLayout space, share, feedBack, telNumber, setUp, house, money, collection, setupOther, shareOther, notLoginRelativeLayout, hasLoginRelativeLayout;
    private TextView loginOrRegisterTv;
    private ChangePageReceiver receiver;
    private LoginOutReceiver outReceiver;

    @Override
    public int setLayout() {

        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        receiver = new ChangePageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("changePage");
        context.registerReceiver(receiver, filter);
        outReceiver = new LoginOutReceiver();
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("outPut");
        context.registerReceiver(outReceiver, filter1);
        loginOrRegisterTv = (TextView) view.findViewById(R.id.fragment_mine_login_or_signup);
        userImage = (ImageView) view.findViewById(R.id.fragment_mine_user_image);
        space = (RelativeLayout) view.findViewById(R.id.fragment_mine_release_layout);
        share = (RelativeLayout) view.findViewById(R.id.fragment_mine_share_layout);
        feedBack = (RelativeLayout) view.findViewById(R.id.fragment_mine_suggestion_layout);
        telNumber = (RelativeLayout) view.findViewById(R.id.fragment_mine_telnumber_layout);
        setUp = (RelativeLayout) view.findViewById(R.id.fragment_mine_setup_layout);
        house = (RelativeLayout) view.findViewById(R.id.fragment_mine_house_layout);
        money = (RelativeLayout) view.findViewById(R.id.fragment_mine_money_layout);
        collection = (RelativeLayout) view.findViewById(R.id.fragment_mine_collection_layout);
        setupOther = (RelativeLayout) view.findViewById(R.id.fragment_mine_setup_layout_other);
        shareOther = (RelativeLayout) view.findViewById(R.id.fragment_mine_share_layout_other);
        notLoginRelativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_mine_not_login);
        hasLoginRelativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_mine_has_login);
        presenter.whetherLogin();//判断程序是否是登录状态
    }

    @Override
    public void initData() {
        userImage.setOnClickListener(this);
        space.setOnClickListener(this);
        share.setOnClickListener(this);
        setUp.setOnClickListener(this);
        money.setOnClickListener(this);
        telNumber.setOnClickListener(this);
        house.setOnClickListener(this);
        feedBack.setOnClickListener(this);
        collection.setOnClickListener(this);
        setupOther.setOnClickListener(this);
        shareOther.setOnClickListener(this);
        loginOrRegisterTv.setOnClickListener(this);


    }

    @Override
    public void setPresenter(MineContract.Presenter Presenter) {
        this.presenter = Presenter;
    }

    @Override
    public void isLogin(boolean hasLogin) {
        //点击用户头像和第一个布局的登录状态判断
        if (hasLogin) {
        } else {
            Intent intent = new Intent(context, LoginOrRegisterActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public void whetherLogin(boolean whetherLogin) {
        if (whetherLogin) {
            //登录状态显示的布局
            hasLoginRelativeLayout.setVisibility(View.VISIBLE);
            notLoginRelativeLayout.setVisibility(View.GONE);
        } else {
            hasLoginRelativeLayout.setVisibility(View.GONE);
            notLoginRelativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_mine_user_image:
                presenter.isLogin();
                break;
            case R.id.fragment_mine_release_layout:
                Intent intent = new Intent(context, LoginOrRegisterActivity.class);
                context.startActivity(intent);
                break;
            case R.id.fragment_mine_telnumber_layout:
                telNumberDialog();
                break;
            case R.id.fragment_mine_share_layout:
                break;
            case R.id.fragment_mine_suggestion_layout:
                Toast.makeText(context, "呵呵,你还敢有意见?", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_mine_setup_layout:
                aboutUs();
                break;
            case R.id.fragment_mine_collection_layout:
                break;
            case R.id.fragment_mine_money_layout:
                break;
            case R.id.fragment_mine_setup_layout_other:
                setUpDialog();
                break;
            case R.id.fragment_mine_share_layout_other:
                break;
            case R.id.fragment_mine_house_layout:
                break;

        }
    }

    private void aboutUs() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_setup, null);
        builder.setView(view);
        builder.create().show();
    }

    private void telNumberDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认拨打400-821-3795?");
        builder.setTitle("拨号");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse("tel:4008213795");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void setUpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_setup, null);
        builder.setView(view);
        builder.setNegativeButton("退出登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent("outPut");
                context.sendBroadcast(intent);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


    class ChangePageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            hasLoginRelativeLayout.setVisibility(View.VISIBLE);
            notLoginRelativeLayout.setVisibility(View.GONE);
        }
    }

    class LoginOutReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            hasLoginRelativeLayout.setVisibility(View.GONE);
            notLoginRelativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        context.unregisterReceiver(receiver);
        context.unregisterReceiver(outReceiver);
    }
}
