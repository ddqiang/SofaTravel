package com.example.dllo.sofatravel.main.main.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionActivity;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LoginOrRegisterActivity;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.UserInfoBean;
import com.example.dllo.sofatravel.main.main.values.TheValues;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * Created by dllo on 16/7/18.
 */
public class MineFragment extends BaseFragment implements MineContract.View, View.OnClickListener {
    private MineContract.Presenter presenter;
    private ImageView userImage;
    private RelativeLayout space, share, feedBack, telNumber, setUp, house, money, collection, setupOther, shareOther, notLoginRelativeLayout, hasLoginRelativeLayout;
    private TextView loginOrRegisterTv, setUserName;
    private ChangePageReceiver receiver;
    private LoginOutReceiver outReceiver;
    private Bitmap currentUserImage;
    private PopupWindow popupWindow;
    private UserInfoBean currentUserInfo;
    private String currentUserName, currentAccountName;
    //private ProgressDialog getUserInfoDialog;
    private SetDefaultReceiver setDefaultReceiver;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {

        setDefaultReceiver = new SetDefaultReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setDefault");
        context.registerReceiver(setDefaultReceiver, intentFilter);
        //注册更换布局的广播
        receiver = new ChangePageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("changePage");
        context.registerReceiver(receiver, filter);
        //注册退出登录广播
        outReceiver = new LoginOutReceiver();
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("outPut");
        context.registerReceiver(outReceiver, filter1);
        //view初始化
        initViewId(view);
        //判断程序是否是登录状态
        presenter.whetherLogin();
    }

    @Override
    public void initData() {
        SharedPreferences isLogin = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = isLogin.getBoolean("hasLogin", false);
        if (hasLogin) {
            // queryUserName();
            //queryUserImage();
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            currentAccountName = sharedPreferences.getString("accountName", "");
            SharedPreferences preferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
            currentUserName = preferences.getString("userName", "未设置");
            presenter.queryUserInfoFromLiteOrm(currentAccountName);
            //getUserInfoDialog();
        }
        setOnClick();
    }


    private void queryUserImage() {
        //查询用户头像
        SharedPreferences account = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        String accountName = account.getString("accountName", "null");
        presenter.queryUserImage(accountName);
        //presenter.queryUserImageFromLiteOrm(accountName);
    }

    private void queryUserName() {
        //查询用户名字
        SharedPreferences account = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        String accountName = account.getString("accountName", "null");
        presenter.getUserBean(accountName);
    }

    @Override
    public void setPresenter(MineContract.Presenter Presenter) {
        this.presenter = Presenter;
    }

    @Override
    public void isLogin(boolean hasLogin) {
        //点击用户头像和第一个布局的登录状态判断
        if (hasLogin) {
            showPopu();
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
    public void getUserBeanSuccess(String userName) {
        setUserName.setText(userName);
    }

    @Override
    public void saveUserInfoSuccess() {
        Toast.makeText(context, "savesuccess", Toast.LENGTH_SHORT).show();
        //用户信息保存完毕
    }

    @Override
    public void getUserImageSuccess(Bitmap bitmap) {
        currentUserImage = bitmap;
        currentUserInfo = new UserInfoBean();
        currentUserInfo.setImage(currentUserImage);
        currentUserInfo.setUserCustomName(currentUserName);
        currentUserInfo.setAccount(currentAccountName);
        presenter.saveUserInfo(currentUserInfo);//将用户名和账号保存
//        UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
//        beanForLiteOrm.setUserName(currentUserName);
//        beanForLiteOrm.setAccount(currentAccountName);
//        beanForLiteOrm.setImage(currentUserImage);
//        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(beanForLiteOrm);
//        Toast.makeText(context, "存上了", Toast.LENGTH_SHORT).show();
//        ArrayList<UserBeanForLiteOrm> datas = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<UserBeanForLiteOrm>(UserBeanForLiteOrm.class).where("account" + " LIKE ?", new String[]{currentAccountName}));
//        Toast.makeText(context, "取出来了 : " + datas.get(0).getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void readUserImageSuccess(Bitmap bitmap) {
        userImage.setImageBitmap(bitmap);
//        if (getUserInfoDialog != null) {
//            getUserInfoDialog.dismiss();
//        }
        //读取用户信息 成功后dialog dismiss
    }

    @Override
    public void setUserImageForLiteOrmSuccess() {
        Toast.makeText(context, "头像设置成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm) {
        setUserName.setText(beanForLiteOrm.getUserName());
    }

    @Override
    public void changeUserNameForLiteOrmSuccess() {
        Toast.makeText(context, "用户名更换成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void queryUserInfoFromLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm) {
        userImage.setImageBitmap(beanForLiteOrm.getImage());
        setUserName.setText(beanForLiteOrm.getUserName());
        currentUserImage = beanForLiteOrm.getImage();
//        if (getUserInfoDialog != null) {
//            getUserInfoDialog.dismiss();
//        }
    }


    //设置用户昵称dialog
    private void getUserName() {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_get_user_name, null);
        final EditText getUserNameEt = (EditText) view.findViewById(R.id.dialog_get_user_name_et);
        builder.setView(view);
        builder.setTitle("更改昵称");
        builder.setPositiveButton("确认更改", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (getUserNameEt.getText().length() == 0) {
                    Toast.makeText(context, "请填写用户名", Toast.LENGTH_SHORT).show();
                } else {
                    currentUserName = getUserNameEt.getText().toString();//获取用户输入的名字
                    SharedPreferences sharedPreferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userName", currentUserName);//将用户设置的名字保存本地
                    editor.commit();
                    presenter.getUserImage(currentAccountName);
                    //存入数据库中
                    UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
                    beanForLiteOrm.setUserName(currentUserName);
                    beanForLiteOrm.setAccount(currentAccountName);
                    if (currentUserImage == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                        beanForLiteOrm.setImage(bitmap);
                    } else {
                        beanForLiteOrm.setImage(currentUserImage);
                    }
                    presenter.changeUserNameForLiteOrm(beanForLiteOrm);
                    //设置新名字

                    UserInfoBean userBean = new UserInfoBean();
                    userBean.setUserCustomName(currentUserName);
                    userBean.setAccount(currentAccountName);
                    if (currentUserImage == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                        userBean.setImage(bitmap);
                    } else {
                        userBean.setImage(currentUserImage);
                    }
                    presenter.saveUserInfo(userBean);
                    //存入网络数据库
                    setUserName.setText(currentUserName);

                }
            }
        });
        builder.create().show();
    }


    //未登录时 设置 dialog
    private void aboutUs() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_setup, null);
        builder.setView(view);
        builder.create().show();
    }

    //拨打电话dialog
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


    //登录后 设置 dialog
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
                SharedPreferences outAccount = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
                SharedPreferences.Editor accountEditor = outAccount.edit();
                accountEditor.clear();
                accountEditor.commit();
                SharedPreferences clearName = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
                SharedPreferences.Editor clearUserName = clearName.edit();
                clearUserName.clear();
                clearUserName.commit();
                userImage.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one));
                Intent intent = new Intent("outPut");
                context.sendBroadcast(intent);
                currentUserImage = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                currentUserName = new String();
                currentAccountName = new String();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    //登录后接受的广播
    class ChangePageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            hasLoginRelativeLayout.setVisibility(View.VISIBLE);
            notLoginRelativeLayout.setVisibility(View.GONE);
            queryUserName();
            queryUserImage();
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            currentAccountName = sharedPreferences.getString("accountName", "");
            SharedPreferences preferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
            currentUserName = preferences.getString("userName", "未设置");
            // presenter.queryUserInfoFromLiteOrm(currentAccountName);
            getUserInfoDialog();
        }
    }

    class SetDefaultReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            currentAccountName = sharedPreferences.getString("accountName", "");
            presenter.loginOrRegisterSaveDefaultUserBeanToLiteOrm(currentAccountName, "未设置");
        }
    }
    //注册后设置默认数据广播

    //退出登录接受的广播
    class LoginOutReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            hasLoginRelativeLayout.setVisibility(View.GONE);
            notLoginRelativeLayout.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 开始裁剪
     *
     * @param uri
     */
    private void startCrop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");// 调用Android系统自带的一个图片剪裁页面,
        intent.setDataAndType(uri, TheValues.IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");// 进行修剪
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, TheValues.CROP_REQUEST_CODE);
    }

    //获取头像
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case TheValues.ALBUM_REQUEST_CODE:
                // Log.i(TAG, "相册，开始裁剪");
                // Log.i(TAG, "相册 [ " + data + " ]");
                if (data == null) {
                    return;
                }
                startCrop(data.getData());
                break;
            case TheValues.CAMERA_REQUEST_CODE:
                // Log.i(TAG, "相机, 开始裁剪");
                File picture = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
                startCrop(Uri.fromFile(picture));
                break;
            case TheValues.CROP_REQUEST_CODE:
                // Log.i(TAG, "相册裁剪成功");
                // Log.i(TAG, "裁剪以后 [ " + data + " ]");
                if (data == null) {
                    // TODO 如果之前以后有设置过显示之前设置的图片 否则显示默认的图片
                    return;
                }
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    currentUserImage = photo;//设置图片后设置为当前image
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    // 此处可以把Bitmap保存到sd卡中
                    userImage.setImageBitmap(photo); // 把图片显示在ImageView控件上
                    UserInfoBean bean = new UserInfoBean();
                    bean.setAccount(currentAccountName);//设置账号
                    bean.setUserCustomName(currentUserName);//设置用户名
                    bean.setImage(photo);//设置图片
                    presenter.saveUserInfo(bean);//存入网络数据库
                    UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
                    beanForLiteOrm.setAccount(currentAccountName);
                    beanForLiteOrm.setUserName(currentUserName);
                    beanForLiteOrm.setImage(photo);
                    presenter.setUserImageForLiteOrm(beanForLiteOrm);//存入本地数据库
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        context.unregisterReceiver(receiver);
        context.unregisterReceiver(outReceiver);
        context.unregisterReceiver(setDefaultReceiver);
    }


    //progressDialog
    private void getUserInfoDialog() {
//        if (getUserInfoDialog == null) {
//            getUserInfoDialog = ProgressDialog.show(context, "请等待", "加载数据中", true, false);
//        } else {
//            getUserInfoDialog.show();
//        }
    }

    //设置popup
    private void showPopu() {

        View view = LayoutInflater.from(context).inflate(R.layout.mine_message_image, null);
        TextView camear = (TextView) view.findViewById(R.id.mine_message_camera);
        TextView locrdImage = (TextView) view.findViewById(R.id.mine_message_localImage);
        TextView close = (TextView) view.findViewById(R.id.mine_message_close);

        camear.setOnClickListener(this);
        locrdImage.setOnClickListener(this);
        close.setOnClickListener(this);
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    private void initViewId(View view) {
        loginOrRegisterTv = (TextView) view.findViewById(R.id.fragment_mine_login_or_signup);
        setUserName = (TextView) view.findViewById(R.id.fragment_mine_login_or_signup_username);
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
    }

    private void setOnClick() {
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
        setUserName.setOnClickListener(this);
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
                Intent intent1 = new Intent(context, CollectionActivity.class);
                context.startActivity(intent1);
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
            case R.id.fragment_mine_login_or_signup_username:
                getUserName();
                break;
            case R.id.mine_message_camera:
                Toast.makeText(context, "没有照相机怎么办", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_message_close:
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                break;
            case R.id.mine_message_localImage:
                Intent localImage = new Intent(Intent.ACTION_PICK, null);
                localImage.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, TheValues.IMAGE_UNSPECIFIED);
                startActivityForResult(localImage, TheValues.ALBUM_REQUEST_CODE);
                break;

        }
    }
}
