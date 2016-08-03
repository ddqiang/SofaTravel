package com.example.dllo.sofatravel.main.main.mine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.values.TheValues;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dllo on 16/7/28.
 */
public class SuggestionActivity extends BaseActivity {
    @InjectView(R.id.activity_suggestion_title_layout_back_icon)
    ImageView activitySuggestionTitleLayoutBackIcon;
    @InjectView(R.id.activity_suggestion_title_layout)
    RelativeLayout activitySuggestionTitleLayout;
    @InjectView(R.id.activity_suggestion_question)
    TextView activitySuggestionQuestion;
    @InjectView(R.id.activity_suggestion_question_content)
    LinearLayout activitySuggestionQuestionContent;
    @InjectView(R.id.activity_suggestion_image)
    TextView activitySuggestionImage;
    @InjectView(R.id.activity_suggestion_add_image)
    ImageView activitySuggestionAddImage;
    @InjectView(R.id.activity_suggestion_question_photo)
    RelativeLayout activitySuggestionQuestionPhoto;
    @InjectView(R.id.activity_suggestion_send)
    TextView activitySuggestionSend;
    @InjectView(R.id.activity_suggestion_question_content_text)
    EditText activitySuggestionQuestionContentText;
    @InjectView(R.id.activity_suggestion_show_image)
    ImageView activitySuggestionShowImage;
    private Bitmap mCurrentImage;
    private String mCurrentContent;
    private SmsManager smsManager;

    @Override
    public int getLayout() {
        return R.layout.activity_suggestion;
    }

    @Override
    public void initView() {


    }


    @Override
    public void initData() {
        if (mCurrentImage != null) {
            activitySuggestionAddImage.setVisibility(View.GONE);
        } else {
            activitySuggestionAddImage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.activity_suggestion_title_layout_back_icon, R.id.activity_suggestion_add_image, R.id.activity_suggestion_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_suggestion_title_layout_back_icon:
                finish();
                break;
            case R.id.activity_suggestion_add_image:
                getLocalImage();

                break;
            case R.id.activity_suggestion_send:
                mCurrentContent = activitySuggestionQuestionContentText.getText().toString();
                Intent data = new Intent(Intent.ACTION_SENDTO);
//                data.setData(Uri.parse("zihow@foxmail.com"));
//                data.putExtra(Intent.EXTRA_SUBJECT, "意见反馈");
//                data.putExtra(Intent.EXTRA_TEXT, mCurrentContent);
//                startActivity(data);

//                Uri uri = Uri.parse("smsto:13390020230");
//                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//                intent.putExtra("sms_body", mCurrentContent);
//                startActivity(intent);
                smsManager = SmsManager.getDefault();
                //拆分短信内容（手机短信长度限制）
                List<String> divideContents = smsManager.divideMessage(mCurrentContent);
                for (String text : divideContents) {
                    smsManager.sendTextMessage("13390020230", null, text, null, null);
                }
                Toast.makeText(this, mCurrentContent, Toast.LENGTH_SHORT).show();
                activitySuggestionQuestionContentText.setText("");
                activitySuggestionShowImage.setImageBitmap(null);
                break;
        }
    }

    private void getLocalImage() {
        Intent localImage = new Intent(Intent.ACTION_PICK, null);
        localImage.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, TheValues.IMAGE_UNSPECIFIED);
        startActivityForResult(localImage, TheValues.ALBUM_REQUEST_CODE);
    }

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
                        activitySuggestionShowImage.setImageBitmap(photo);
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
                    mCurrentImage = photo;//设置图片后设置为当前image
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    // 此处可以把Bitmap保存到sd卡中
                    activitySuggestionShowImage.setImageBitmap(photo); // 把图片显示在ImageView控件上
                    activitySuggestionAddImage.setVisibility(View.GONE);
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
    protected void onDestroy() {
        super.onDestroy();
        activitySuggestionQuestionContentText.setText("");
        mCurrentImage = null;

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
}
