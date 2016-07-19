package com.example.dllo.sofatravel.main.main.home;

import android.widget.TextView;

import java.util.List;

/**
 * Created by dllo on 16/7/19.
 */
public class HomeGrViewBean {

    private String cityTv;
    private String cityEnglishTv;
    private int id;
    private String imageUrl;

    public String getCityTv() {
        return cityTv;
    }

    public void setCityTv(String cityTv) {
        this.cityTv = cityTv;
    }

    public String getCityEnglishTv() {
        return cityEnglishTv;
    }

    public void setCityEnglishTv(String cityEnglishTv) {
        this.cityEnglishTv = cityEnglishTv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
