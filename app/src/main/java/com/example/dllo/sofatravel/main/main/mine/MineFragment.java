package com.example.dllo.sofatravel.main.main.mine;

import android.app.ProgressDialog;
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
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionActivity;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LoginOrRegisterActivity;
import com.example.dllo.sofatravel.main.main.order.ConversationActivity;
import com.example.dllo.sofatravel.main.main.tools.FloatingActionButton;
import com.example.dllo.sofatravel.main.main.tools.FloatingActionMenu;
import com.example.dllo.sofatravel.main.main.tools.SubActionButton;
import com.example.dllo.sofatravel.main.main.values.TheValues;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import cn.bmob.newim.BmobIM;
import cn.bmob.newim.bean.BmobIMConversation;
import cn.bmob.newim.bean.BmobIMUserInfo;
import cn.bmob.newim.listener.ConnectListener;
import cn.bmob.newim.listener.ConversationListener;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


/**
 * Created by dllo on 16/7/18.
 */
public class MineFragment extends BaseFragment implements MineContract.View, View.OnClickListener, View.OnTouchListener {
    private MineContract.Presenter mPresenter;
    private ImageView mUserImage;
    private RelativeLayout mSpace, mShare, mFeedBack, mTelNumber, mSetUp, mHouse, mMoney, mCollection, mSetupOther, mshareOther, mNotLoginRelativeLayout, mHasLoginRelativeLayout;
    private TextView mLoginOrRegisterTv, mSetUserName;
    private ChangePageReceiver mReceiver;
    private LoginOutReceiver mOutReceiver;
    private Bitmap mCurrentUserImage;
    private PopupWindow mPopupWindow;
    private UserInfoBean mCurrentUserInfo;
    private String mCurrentUserName, mCurrentAccountName;
    private ProgressDialog mGetUserInfoDialog;
    private SetDefaultReceiver mSetDefaultReceiver;
    private FloatingActionMenu mActionMenu;
    private FloatingActionButton mActionButton;
    private boolean mHasLogin;
    int screenWidth;
    int screenHeight;
    int lastX;
    int lastY;
    private int left;
    private int top;
    private int right;
    private int bottom;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        mSetDefaultReceiver = new SetDefaultReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setDefault");
        context.registerReceiver(mSetDefaultReceiver, intentFilter);
        //注册更换布局的广播
        mReceiver = new ChangePageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("changePage");
        context.registerReceiver(mReceiver, filter);
        //注册退出登录广播
        mOutReceiver = new LoginOutReceiver();
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("outPut");
        context.registerReceiver(mOutReceiver, filter1);
        //view初始化
        initViewId(view);
        //判断程序是否是登录状态
        SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        if (hasLogin) {
            //登录状态显示的布局
            mHasLoginRelativeLayout.setVisibility(View.VISIBLE);
            mNotLoginRelativeLayout.setVisibility(View.GONE);
        } else {
            mHasLoginRelativeLayout.setVisibility(View.GONE);
            mNotLoginRelativeLayout.setVisibility(View.VISIBLE);
        }
        setFloatButton();
        DraftTest();

    }

    private void DraftTest() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - 50;
       // mActionButton.setOnTouchListener(this);


    }

    private void setFloatButton() {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.mipmap.setting);
        mActionButton = new FloatingActionButton.Builder(getActivity()).setContentView(imageView).build();
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView icon1 = new ImageView(context);
        icon1.setImageResource(R.mipmap.qrcode);
        SubActionButton button1 = itemBuilder.setContentView(icon1).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutUs();
                mActionMenu.close(false);
            }
        });
        ImageView icon2 = new ImageView(context);
        icon2.setImageResource(R.mipmap.headimage);
        SubActionButton button2 = itemBuilder.setContentView(icon2).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.isLogin();
                mActionMenu.close(false);
            }
        });
        ImageView icon3 = new ImageView(context);
        icon3.setImageResource(R.mipmap.username);
        SubActionButton button3 = itemBuilder.setContentView(icon3).build();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHasLogin) {
                    getUserName();
                    mActionMenu.close(false);
                } else {
                    Toast.makeText(context, "未登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageView icon4 = new ImageView(context);
        icon4.setImageResource(R.mipmap.loginout);
        SubActionButton button4 = itemBuilder.setContentView(icon4).build();
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHasLogin) {
                    setUpDialog();
                    mActionMenu.close(false);
                } else {
                    Toast.makeText(context, "未登录", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mActionMenu = new FloatingActionMenu.Builder(getActivity()).addSubActionView(button1).addSubActionView(button2).addSubActionView(button3).addSubActionView(button4).attachTo(mActionButton).build();
        mActionMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu floatingActionMenu) {
            }

            @Override
            public void onMenuClosed(FloatingActionMenu floatingActionMenu) {
            }
        });
    }

    @Override
    public void initData() {
        SharedPreferences isLogin = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        mHasLogin = isLogin.getBoolean("hasLogin", false);
        if (mHasLogin) {
            mGetUserInfoDialog = new ProgressDialog(context);
            mGetUserInfoDialog.setTitle("加载中");
            mGetUserInfoDialog.setMessage("loading");
            mGetUserInfoDialog.show();
            //queryUserName();
            //queryUserImage();
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            mCurrentAccountName = sharedPreferences.getString("accountName", "");
            SharedPreferences preferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
            mCurrentUserName = preferences.getString("userName", "未设置");
            mPresenter.queryUserInfoFromLiteOrm(mCurrentAccountName);
        }
        setOnClick();


    }

    private void queryUserImage() {
        //查询用户头像
        SharedPreferences account = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        String accountName = account.getString("accountName", "null");
        mPresenter.queryUserImage(accountName);
        //presenter.queryUserImageFromLiteOrm(accountName);
    }

    private void queryUserName() {
        //查询用户名字
        SharedPreferences account = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        String accountName = account.getString("accountName", "null");
        mPresenter.getUserBean(accountName);
    }

    @Override
    public void setPresenter(MineContract.Presenter Presenter) {
        this.mPresenter = Presenter;
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
            mHasLoginRelativeLayout.setVisibility(View.VISIBLE);
            mNotLoginRelativeLayout.setVisibility(View.GONE);
        } else {
            mHasLoginRelativeLayout.setVisibility(View.GONE);
            mNotLoginRelativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getUserBeanSuccess(String userName) {
        mSetUserName.setText(userName);
//        if (getUserInfoDialog != null) {
//            getUserInfoDialog.dismiss();
//        }
    }

    @Override
    public void saveUserInfoSuccess() {
        Toast.makeText(context, "savesuccess", Toast.LENGTH_SHORT).show();
        //用户信息保存完毕
    }

    @Override
    public void getUserImageSuccess(Bitmap bitmap) {
        mCurrentUserImage = bitmap;
        mCurrentUserInfo = new UserInfoBean();
        mCurrentUserInfo.setImage(mCurrentUserImage);
        mCurrentUserInfo.setUserCustomName(mCurrentUserName);
        mCurrentUserInfo.setAccount(mCurrentAccountName);
        mPresenter.saveUserInfo(mCurrentUserInfo);//将用户名和账号保存
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
        mUserImage.setImageBitmap(bitmap);
        if (mGetUserInfoDialog != null) {
            mGetUserInfoDialog.dismiss();
        }
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
        //读取用户信息 成功后dialog dismiss
    }

    @Override
    public void setUserImageForLiteOrmSuccess() {
        Toast.makeText(context, "头像设置成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginOrRegisterSaveDefaultUserBeanToLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm) {
        mSetUserName.setText(beanForLiteOrm.getUserName());
    }

    @Override
    public void changeUserNameForLiteOrmSuccess() {
        Toast.makeText(context, "用户名更换成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void queryUserInfoFromLiteOrmSuccess(UserBeanForLiteOrm beanForLiteOrm) {
        mUserImage.setImageBitmap(beanForLiteOrm.getImage());
        mSetUserName.setText(beanForLiteOrm.getUserName());
        mCurrentUserImage = beanForLiteOrm.getImage();
        if (mGetUserInfoDialog != null) {
            mGetUserInfoDialog.dismiss();
        }
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
                    mCurrentUserName = getUserNameEt.getText().toString();//获取用户输入的名字
                    SharedPreferences sharedPreferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userName", mCurrentUserName);//将用户设置的名字保存本地
                    editor.commit();
                    mPresenter.getUserImage(mCurrentAccountName);
                    //存入数据库中
                    UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
                    beanForLiteOrm.setUserName(mCurrentUserName);
                    beanForLiteOrm.setAccount(mCurrentAccountName);
                    if (mCurrentUserImage == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                        beanForLiteOrm.setImage(bitmap);
                    } else {
                        beanForLiteOrm.setImage(mCurrentUserImage);
                    }
                    mPresenter.changeUserNameForLiteOrm(beanForLiteOrm);
                    //设置新名字

                    UserInfoBean userBean = new UserInfoBean();
                    userBean.setUserCustomName(mCurrentUserName);
                    userBean.setAccount(mCurrentAccountName);
                    if (mCurrentUserImage == null) {
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                        userBean.setImage(bitmap);
                    } else {
                        userBean.setImage(mCurrentUserImage);
                    }
                    mPresenter.saveUserInfo(userBean);
                    //存入网络数据库
                    mSetUserName.setText(mCurrentUserName);

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

    //登录后 退出登录 dialog
    private void setUpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("确定退出吗?");
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
                mUserImage.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one));
                Intent intent = new Intent("outPut");
                context.sendBroadcast(intent);
                mCurrentUserImage = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_one);
                mCurrentUserName = new String();
                mCurrentAccountName = new String();
                BmobUser.logOut(context);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) (event.getRawX() - lastX);
                int dy = (int) (event.getRawY() - lastY);
                left = v.getLeft() + dx;
                top = v.getTop() + dy;
                right = v.getRight() + dx;
                bottom = v.getBottom() + dy;
                if (left < 0) {
                    left = 0;
                    right = left + v.getWidth();
                }
                if (right > screenWidth) {
                    right = screenWidth;
                    left = right - v.getWidth();
                }
                if (top < 0) {
                    top = 0;
                    bottom = top + v.getHeight();
                }
                if (bottom > screenHeight) {
                    bottom = screenHeight;
                    top = bottom - v.getHeight();
                }
                v.layout(left, top, right, bottom);
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return false;
    }

    //登录后接受的广播
    class ChangePageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            mHasLoginRelativeLayout.setVisibility(View.VISIBLE);
            mNotLoginRelativeLayout.setVisibility(View.GONE);
            queryUserName();
            queryUserImage();
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            mCurrentAccountName = sharedPreferences.getString("accountName", "");
            SharedPreferences preferences = context.getSharedPreferences("saveUserName", Context.MODE_PRIVATE);
            mCurrentUserName = preferences.getString("userName", "未设置");
            // presenter.queryUserInfoFromLiteOrm(currentAccountName);
            getUserInfoDialog();
        }
    }

    class SetDefaultReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
            mCurrentAccountName = sharedPreferences.getString("accountName", "");
            mPresenter.loginOrRegisterSaveDefaultUserBeanToLiteOrm(mCurrentAccountName, "未设置");
        }
    }
    //注册后设置默认数据广播

    //退出登录接受的广播
    class LoginOutReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mHasLoginRelativeLayout.setVisibility(View.GONE);
            mNotLoginRelativeLayout.setVisibility(View.VISIBLE);
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
                Uri uri = data.getData();
                if (uri == null) {
                    //use bundle to get data
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        Bitmap photo = (Bitmap) bundle.get("data"); //get bitmap
                        mUserImage.setImageBitmap(photo);
                        mCurrentUserImage = photo;//设置图片后设置为当前image
//                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                        photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
//                        // 此处可以把Bitmap保存到sd卡中
//                        mUserImage.setImageBitmap(photo); // 把图片显示在ImageView控件上
//                        UserInfoBean bean = new UserInfoBean();
//                        bean.setAccount(mCurrentAccountName);//设置账号
//                        bean.setUserCustomName(mCurrentUserName);//设置用户名
//                        bean.setImage(photo);//设置图片
//                        mPresenter.saveUserInfo(bean);//存入网络数据库
//                        UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
//                        beanForLiteOrm.setAccount(mCurrentAccountName);
//                        beanForLiteOrm.setUserName(mCurrentUserName);
//                        beanForLiteOrm.setImage(photo);
//                        mPresenter.setUserImageForLiteOrm(beanForLiteOrm);//存入本地数据库
//                        try {
//                            stream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                    } else {
                        return;
                    }
                }
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
                    mCurrentUserImage = photo;//设置图片后设置为当前image
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    // 此处可以把Bitmap保存到sd卡中
                    mUserImage.setImageBitmap(photo); // 把图片显示在ImageView控件上
                    UserInfoBean bean = new UserInfoBean();
                    bean.setAccount(mCurrentAccountName);//设置账号
                    bean.setUserCustomName(mCurrentUserName);//设置用户名
                    bean.setImage(photo);//设置图片
                    mPresenter.saveUserInfo(bean);//存入网络数据库
                    UserBeanForLiteOrm beanForLiteOrm = new UserBeanForLiteOrm();
                    beanForLiteOrm.setAccount(mCurrentAccountName);
                    beanForLiteOrm.setUserName(mCurrentUserName);
                    beanForLiteOrm.setImage(photo);
                    mPresenter.setUserImageForLiteOrm(beanForLiteOrm);//存入本地数据库
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
        context.unregisterReceiver(mReceiver);
        context.unregisterReceiver(mOutReceiver);
        context.unregisterReceiver(mSetDefaultReceiver);
        mActionButton.setVisibility(View.GONE);
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
        mPopupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setContentView(view);
        mPopupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    private void initViewId(View view) {
        mLoginOrRegisterTv = (TextView) view.findViewById(R.id.fragment_mine_login_or_signup);
        mSetUserName = (TextView) view.findViewById(R.id.fragment_mine_login_or_signup_username);
        mUserImage = (ImageView) view.findViewById(R.id.fragment_mine_user_image);
        mSpace = (RelativeLayout) view.findViewById(R.id.fragment_mine_release_layout);
        mShare = (RelativeLayout) view.findViewById(R.id.fragment_mine_share_layout);
        mFeedBack = (RelativeLayout) view.findViewById(R.id.fragment_mine_suggestion_layout);
        mTelNumber = (RelativeLayout) view.findViewById(R.id.fragment_mine_telnumber_layout);
        mSetUp = (RelativeLayout) view.findViewById(R.id.fragment_mine_setup_layout);
        mHouse = (RelativeLayout) view.findViewById(R.id.fragment_mine_house_layout);
        mMoney = (RelativeLayout) view.findViewById(R.id.fragment_mine_money_layout);
        mCollection = (RelativeLayout) view.findViewById(R.id.fragment_mine_collection_layout);
        mSetupOther = (RelativeLayout) view.findViewById(R.id.fragment_mine_setup_layout_other);
        mshareOther = (RelativeLayout) view.findViewById(R.id.fragment_mine_share_layout_other);
        mNotLoginRelativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_mine_not_login);
        mHasLoginRelativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_mine_has_login);
    }

    private void setOnClick() {
        mUserImage.setOnClickListener(this);
        mSpace.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mSetUp.setOnClickListener(this);
        mMoney.setOnClickListener(this);
        mTelNumber.setOnClickListener(this);
        mHouse.setOnClickListener(this);
        mFeedBack.setOnClickListener(this);
        mCollection.setOnClickListener(this);
        mSetupOther.setOnClickListener(this);
        mshareOther.setOnClickListener(this);
        mLoginOrRegisterTv.setOnClickListener(this);
        mSetUserName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_mine_user_image:
                mPresenter.isLogin();
                break;
            case R.id.fragment_mine_release_layout:
                Intent intent = new Intent(context, LoginOrRegisterActivity.class);
                context.startActivity(intent);
                break;
            case R.id.fragment_mine_telnumber_layout:
                telNumberDialog();
                break;
            case R.id.fragment_mine_share_layout:
                shareMyApp();
                break;
            case R.id.fragment_mine_suggestion_layout:
                Toast.makeText(context, "呵呵,你还敢有意见?", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(context, SuggestionActivity.class);
                context.startActivity(intent3);
                break;
            case R.id.fragment_mine_setup_layout:

                break;
            case R.id.fragment_mine_collection_layout:
                Intent intent1 = new Intent(context, CollectionActivity.class);
                context.startActivity(intent1);
                break;
            case R.id.fragment_mine_money_layout:
                conversationTest();
                break;
            case R.id.fragment_mine_setup_layout_other:
                //setUpDialog();
                break;
            case R.id.fragment_mine_share_layout_other:
                shareMyApp();
                break;
            case R.id.fragment_mine_house_layout:
                BmobIM.getInstance().disConnect();
                break;
            case R.id.fragment_mine_login_or_signup_username:

                //getUserName();
                break;
            case R.id.mine_message_camera:
                //Toast.makeText(context, "没有照相机怎么办", Toast.LENGTH_SHORT).show();
                openTakePhoto();
                break;
            case R.id.mine_message_close:
                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                }
                break;
            case R.id.mine_message_localImage:
                Intent localImage = new Intent(Intent.ACTION_PICK, null);
                localImage.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, TheValues.IMAGE_UNSPECIFIED);
                startActivityForResult(localImage, TheValues.ALBUM_REQUEST_CODE);
                break;
            case R.id.fragment_mine_login_or_signup:
                Intent intent2 = new Intent(context, LoginOrRegisterActivity.class);
                context.startActivity(intent2);
                break;

        }
    }

    private void conversationTest() {
        final UserInfoBean user = BmobUser.getCurrentUser(context, UserInfoBean.class);
        BmobIM.connect(user.getObjectId(), new ConnectListener() {
            @Override
            public void done(String uid, BmobException e) {
                if (e == null) {
                    BmobIMUserInfo info = new BmobIMUserInfo();
                    info.setUserId(user.getObjectId());
                    info.setName(mCurrentUserName);

                    BmobIM.getInstance().startPrivateConversation(info, new ConversationListener() {
                        @Override
                        public void done(BmobIMConversation c, BmobException e) {
                            if (e == null) {
                                //在此跳转到聊天页面
                                Intent intent2 = new Intent(context, ConversationActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("c", c);
                                intent2.putExtras(bundle);
                                context.startActivity(intent2);
                            } else {
                                Log.d("lanou", e.getMessage() + "(" + e.getErrorCode() + ")");
                            }
                        }
                    });
                } else {
                    Log.d("lanou", "失败" + e);
                }
            }
        });
    }

    private void shareMyApp() {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//                oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://www.shafalvxing.com/");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://www.shafalvxing.com/");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://www.shafalvxing.com/");
        // 启动分享GUI
        oks.show(context);
    }

    private void openTakePhoto() {
        /**
         * 在启动拍照之前最好先判断一下sdcard是否可用
         */
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)) {   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, TheValues.CAMERA_REQUEST_CODE);
        }
    }


}
