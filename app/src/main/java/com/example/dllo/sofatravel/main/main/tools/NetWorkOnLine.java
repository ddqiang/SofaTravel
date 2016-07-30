package com.example.dllo.sofatravel.main.main.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.dllo.sofatravel.main.main.base.MyApplication;

/**
 * Created by dllo on 16/7/30.
 */
public class NetWorkOnLine {

    //判断当前有没有网
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager)
                MyApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
