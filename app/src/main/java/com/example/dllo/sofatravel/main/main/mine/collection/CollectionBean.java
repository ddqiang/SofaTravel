package com.example.dllo.sofatravel.main.main.mine.collection;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import cn.bmob.v3.BmobObject;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionBean extends BmobObject {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String spaceImage;
    private String ownerHead;
    private int spaceId;
    private String ownerName;
    private String title;
    private double price;
    private double ownerAge;
    private String ownerSex;
    private String ownerJob;
    private double responseRate;

    public String getSpaceImage() {
        return spaceImage;
    }

    public void setSpaceImage(String spaceImage) {
        this.spaceImage = spaceImage;
    }

    public String getOwnerHead() {
        return ownerHead;
    }

    public void setOwnerHead(String ownerHead) {
        this.ownerHead = ownerHead;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(double ownerAge) {
        this.ownerAge = ownerAge;
    }

    public double getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(double responseRate) {
        this.responseRate = responseRate;
    }

    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    public String getOwnerJob() {
        return ownerJob;
    }

    public void setOwnerJob(String ownerJob) {
        this.ownerJob = ownerJob;
    }
}
