package com.example.dllo.sofatravel.main.main.mine;

import cn.bmob.v3.BmobObject;

/**
 * Created by dllo on 16/7/23.
 */
public class User extends BmobObject {
    private String accountName;
    private String message;
    private String userName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
