package com.example.dllo.sofatravel.main.main.mine.house;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.mine.HouseInfoBean;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.example.dllo.sofatravel.main.main.values.TheValues;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dllo on 16/8/4.
 */
public class HouseActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.activity_house_title_back)
    ImageView titleBack;
    @InjectView(R.id.activity_house_add_image)
    ImageView addImage;
    @InjectView(R.id.activity_house_add_house_title)
    EditText addHouseTitle;
    @InjectView(R.id.activity_house_type_choice)
    TextView houseTypeChoice;
    @InjectView(R.id.activity_house_bed_type_choice)
    TextView houseBedTypeChoice;
    @InjectView(R.id.activity_house_facilities_choice)
    TextView houseFacilitiesChoice;
    @InjectView(R.id.activity_house_address_choice)
    TextView houseAddressChoice;
    @InjectView(R.id.activity_house_max_people_choice)
    TextView houseMaxPeopleChoice;
    @InjectView(R.id.activity_house_price_choice)
    TextView housePriceChoice;
    @InjectView(R.id.activity_house_add_house_detail)
    EditText activityHouseAddHouseDetail;
    @InjectView(R.id.activity_house_add_traffic_info)
    EditText activityHouseAddTrafficInfo;
    @InjectView(R.id.activity_house_commit)
    TextView activityHouseCommit;
    ArrayList<String> facilitie;
    int count;
    private Bitmap mCurrentUserImage;
    private PopupWindow mPopupWindow;
    private HouseInfoBean bean;
    private String mBedType, mHouseType, mMaxPeople, mPrice, mFacilities;

    @Override
    public int getLayout() {
        return R.layout.activity_house;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.activity_house_title_back, R.id.activity_house_add_image, R.id.activity_house_type_choice, R.id.activity_house_bed_type_choice, R.id.activity_house_facilities_choice, R.id.activity_house_address_choice, R.id.activity_house_max_people_choice, R.id.activity_house_price_choice, R.id.activity_house_commit})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.activity_house_title_back:
                finish();
                break;
            case R.id.activity_house_add_image:
                showPopu();
                break;
            case R.id.activity_house_type_choice:
                setRoomTypeDialog();
                break;
            case R.id.activity_house_bed_type_choice:
                setBedTypeDialog();
                break;
            case R.id.activity_house_facilities_choice:
                setFacilitiesDialog();
                break;
            case R.id.activity_house_address_choice:
                Toast.makeText(this, "你在大连", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_house_max_people_choice:
                setMaxNumber();
                break;
            case R.id.activity_house_price_choice:
                setPerPrice();
                break;
            case R.id.activity_house_commit:
                getHouseInfo();
                break;
            case R.id.mine_message_camera:
                openTakePhoto();
                break;
            case R.id.mine_message_close:
                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                }
                break;
            case R.id.mine_message_localImage:
                intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, TheValues.IMAGE_UNSPECIFIED);
                startActivityForResult(intent, TheValues.ALBUM_REQUEST_CODE);
                break;
        }
    }


    private void getHouseInfo() {

        if (mCurrentUserImage == null || addHouseTitle.getText().toString().length() == 0) {
            Toast.makeText(this, "请输入完整数据", Toast.LENGTH_SHORT).show();
        } else {
            bean = new HouseInfoBean();
            bean.setImage(mCurrentUserImage);
            if (mBedType.length() != 0) {
                bean.setBedType(mBedType);
            } else {
                bean.setBedType("暂无");
            }
            if (mFacilities.length() != 0) {
                bean.setFacilitie(mFacilities);
            } else {
                bean.setFacilitie("暂无");
            }
            if (mMaxPeople.length() != 0) {
                bean.setMaxPeople(mMaxPeople);
            } else {
                bean.setMaxPeople("暂无");
            }

            bean.setHouseTitle(addHouseTitle.getText().toString());

            if (mHouseType.length() != 0) {
                bean.setHouseType(mHouseType);
            } else {
                bean.setHouseType("暂无");
            }
            if (mPrice.length() != 0) {
                bean.setPerPrice(mPrice);

            } else {
                bean.setPerPrice("暂无");
            }
            if (activityHouseAddHouseDetail.getText().toString().length() != 0) {

                bean.setHosueInfo(activityHouseAddHouseDetail.getText().toString());
            } else {
                bean.setHosueInfo("暂无");
            }
            if (activityHouseAddTrafficInfo.getText().toString().length() != 0) {

                bean.setTrafficInfo(activityHouseAddTrafficInfo.getText().toString());
            } else {
                bean.setTrafficInfo("暂无");
            }
            Toast.makeText(this, "房源发布成功", Toast.LENGTH_SHORT).show();
            MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(bean);
        }


    }


    private void setBedTypeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HouseActivity.this);
        builder.setTitle("请选择床型");
        final String[] bedType = {"单人床", "双人床", "圆床", "沙发床", "沙发", "榻榻米", "充气床", "行军床", "高低床", "水床", "帐篷", "地板/床垫"};
        //    设置一个单项选择下拉框
        builder.setSingleChoiceItems(bedType, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                houseBedTypeChoice.setText(bedType[which]);
                mBedType = bedType[which];
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setRoomTypeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HouseActivity.this);
        builder.setTitle("请选择房间类型");
        final String[] roomType = {"独立房间", "合住房间", "客厅"};
        //    设置一个单项选择下拉框
        builder.setSingleChoiceItems(roomType, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                houseTypeChoice.setText(roomType[which]);
                mHouseType = roomType[which];
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setFacilitiesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HouseActivity.this);
        builder.setTitle("便利设施");
        final String[] facilities = {"无线网络", "卫生间", "空调", "洗漱用品", "洗衣机", "厨房", "电视", "微波炉", "吹风机"};
        //    设置一个单项选择下拉框
        facilitie = new ArrayList<>();
        count = 0;
        builder.setMultiChoiceItems(facilities, null, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    facilitie.add(facilities[which]);
                    count = facilitie.size();

                }
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                houseFacilitiesChoice.setText(count + "");
                for (int i = 0; i < facilitie.size(); i++) {
                    mFacilities += (facilitie.get(i) + " ");
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void setMaxNumber() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HouseActivity.this);
        builder.setTitle("请选择最大人数");
        final String[] maxNumber = {"1人", "2人", "3人", "4人"};
        //    设置一个单项选择下拉框
        builder.setSingleChoiceItems(maxNumber, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                houseMaxPeopleChoice.setText(maxNumber[which]);
                mMaxPeople = maxNumber[which];
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void setPerPrice() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HouseActivity.this);
        builder.setTitle("请选择单人价格");
        final String[] perPrice = {"9.9", "19.9", "29.9", "39.9", "49.9", "59.9", "69.9", "79.9", "89.9", "99.9", "109.9", "119.9", "129.9", "139.9", "149.9", "159.9", "169.9", "179.9", "189.9", "199.9"};
        //    设置一个单项选择下拉框
        builder.setSingleChoiceItems(perPrice, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                housePriceChoice.setText(perPrice[which]);
                mPrice = perPrice[which];
                dialog.dismiss();
            }
        });
        builder.show();
    }

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
                        addImage.setImageBitmap(photo);
                        mCurrentUserImage = photo;//设置图片后设置为当前image
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        // photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                        // 此处可以把Bitmap保存到sd卡中
                        try {
                            stream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                    // photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    // 此处可以把Bitmap保存到sd卡中
                    addImage.setImageBitmap(photo); // 把图片显示在ImageView控件上
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
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

    private void showPopu() {

        View view = LayoutInflater.from(this).inflate(R.layout.mine_message_image, null);
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
}
