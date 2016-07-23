package com.example.dllo.sofatravel.main.main.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/7/19.
 */
public class OkSingle {

    private static OkSingle myOkHttp;
    public OkHttpClient client;
    private Gson gson;

    private final int SUCCESS = 1;
    private final int ERROR = -1;


    private OkSingle() {
        client = new OkHttpClient();
        gson = new Gson();


    }


    public static OkSingle getInstance() {
        if (myOkHttp == null) {
            synchronized (OkSingle.class) {
                if (myOkHttp == null) {
                    myOkHttp = new OkSingle();
                }
            }

        }
        return myOkHttp;
    }

    //异步的get请求
    public <T> void getRequestAsync(String url, final Class<T> clazz, final OnTrue<T> onTrue, final OnError onError) {

        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case SUCCESS:
                        onTrue.hasData((T) msg.obj);
                        break;
                    case ERROR:
                        onError.noHasData();

                        break;
                }
            }
        };

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onError.noHasData();
            }

            @Override
            public void onResponse(Call call, Response response) {
                T t = null;
                String result = null;
                try {
                    result = response.body().string();
                    t = gson.fromJson(result, clazz);
                    Log.d("MyOkHttp", Thread.currentThread().getName());
                    // onTrue.hasData(t);
                    Message message = handler.obtainMessage();
                    message.what = SUCCESS;
                    message.obj = t;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
//                    onError.noHasData();
                    handler.sendEmptyMessage(ERROR);
                }
            }
        });
    }

    public interface OnTrue<T> {
        void hasData(T data);
    }

    public interface OnError {
        void noHasData();
    }

    //首页详情页的数据解析

    public <T> void getMessgeDetail(){


    }
    //首页 户主详情页的数据解析
    public <T> void getMessageConcre(int id, Class<T> t, OnTrue<T> onTrue, OnError onError) {

        String url = " http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
                + id + "%7D";
        getRequestAsync(url, t, onTrue, onError);

    }


}
