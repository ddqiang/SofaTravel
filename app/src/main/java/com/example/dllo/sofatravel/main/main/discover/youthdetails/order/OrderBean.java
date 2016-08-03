package com.example.dllo.sofatravel.main.main.discover.youthdetails.order;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/8/1.
 */
public class OrderBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private  String hotelNAme;
    private  String price;
    private  int bed;
    private String userName;
    private String phoneNumber;
    private String address;

    public OrderBean() {
    }

    public OrderBean(String hotelNAme, String price, int bed, String userName, String phoneNumber, String address) {
        this.hotelNAme = hotelNAme;
        this.price = price;
        this.bed = bed;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }



    public OrderBean(String hotelNAme, String price, int bed) {
        this.hotelNAme = hotelNAme;
        this.price = price;
        this.bed = bed;
    }

    public String getHotelNAme() {
        return hotelNAme;
    }

    public void setHotelNAme(String hotelNAme) {
        this.hotelNAme = hotelNAme;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
