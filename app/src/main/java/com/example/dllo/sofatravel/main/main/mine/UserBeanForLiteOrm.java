package com.example.dllo.sofatravel.main.main.mine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * Created by dllo on 16/7/21.
 */
@Table("UserBeanForLiteOrm")
public class UserBeanForLiteOrm implements Serializable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private String account;
    private String userName;
    private byte[] userImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bitmap getImage() {
        if (userImage == null) {
            return null;
        }
        Bitmap imageBitmap = BitmapFactory.decodeByteArray(userImage, 0, userImage.length);
        return imageBitmap;
    }

    public void setImage(Bitmap image) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, output);
        userImage = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
