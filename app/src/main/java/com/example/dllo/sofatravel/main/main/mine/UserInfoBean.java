package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by dllo on 16/7/20.
 */
public class UserInfoBean extends BmobObject implements Serializable {
//    @PrimaryKey(AssignType.AUTO_INCREMENT)
//    private int id;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    private String userName;
    private String accountName;
    private byte[] photoImage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
