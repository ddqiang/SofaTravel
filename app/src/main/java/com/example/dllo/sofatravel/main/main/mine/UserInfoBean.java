package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import cn.bmob.v3.BmobObject;

/**
 * Created by dllo on 16/7/25.
 */
public class UserInfoBean extends BmobObject {


    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String userCustomName;
    private byte[] photoImage;

    public String getUserCustomName() {
        return userCustomName;
    }

    public void setUserCustomName(String userCustomName) {
        this.userCustomName = userCustomName;
    }

    public Bitmap getImage() {
        if (photoImage == null) {
            return null;
        }
        Bitmap imageBitmap = BitmapFactory.decodeByteArray(photoImage, 0, photoImage.length);
        return imageBitmap;
    }

    public void setImage(Bitmap image) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, output);
        //转换成功了
        photoImage = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
