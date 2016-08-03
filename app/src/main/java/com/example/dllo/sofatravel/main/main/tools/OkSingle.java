package com.example.dllo.sofatravel.main.main.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.dllo.sofatravel.main.main.tools.imagecache.CacheFile;
import com.example.dllo.sofatravel.main.main.values.TheValues;
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

                    //缓存到本地
                    CacheFile.Save(result);

                    t = gson.fromJson(result, clazz);
                    Message message = handler.obtainMessage();
                    message.what = SUCCESS;
                    message.obj = t;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
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

    public <T> void getMessgeDetail(Class<T> t, OnTrue<T> onTrue, OnError onError) {

        getRequestAsync(TheValues.HOME_URL, t, onTrue, onError);

    }

    //首页 户主详情页的数据解析
    public <T> void getMessageConcre(int id, Class<T> t, OnTrue<T> onTrue, OnError onError) {

        String url = " http://www.shafalvxing.com/space/getSharedSpaceInfo.do?bizParams=%7B%22spaceId%22%3A"
                + id + "%7D";

        getRequestAsync(url, t, onTrue, onError);
    }


    //首页 户主租住地详情数据解析
    public <T> void getOwnerMessageDetail(int messageId, Class<T> t, OnTrue<T> onTrue, OnError onError) {

        String url = "http://www.shafalvxing.com/space/getSharedSpaceByCity." +
                "do?bizParams=%7B%22cityId%22%3A%22" + messageId + "%22%2C%22endPrice%22%3A0%2C%22page%22%3A%221%22%2C%22startPrice%22%3" +
                "A0%2C%22userToken%22%3A%22MzdlNGY1MzE2ZjI4MjZiNzNlNjRjNmRkMzFlOTM5YTczZGRhYzI1NmI1ZWExNzI4%22%7D";

        getRequestAsync(url, t, onTrue, onError);
    }
//发现界面
   public <T> void getYouthDeatil(String id,Class<T>t,OnTrue<T>onTrue,OnError onError){
        Long startTime = System.currentTimeMillis();
        Long endTime = startTime + 24 * 60 * 60 * 1000;
        int page = 1;
        String url = "http://www.shafalvxing.com/hotel/getHotelListByCity.do?bizParams=" +
              " %7B%22startTime%22%3A"+startTime+"%2C%22endPrice%22%3A0%2C%22endTime%22%3A"+endTime+"%2C%22district%22%3A%22%22%2C%22" +
                "startPrice%22%3A0%2C%22page%22%3A"+page+"%2C%22cityName%22%3A%22"+id+"%e5%B8%82%22%7D";

        getRequestAsync(url, t, onTrue, onError);
        Log.d("OkSingle", url);
    }

    // 发现 热门城市解析
    public <T> void getHotelDeatil(String id,Class<T>t,OnTrue<T>onTrue,OnError onError) {
        String url = " http://www.shafalvxing.com/hotel/queryHotelDetail.do?bizParams=" +
                "%7B%22endTime%22%3A1469158423376%2C%22hotelId%22%3A%22"+id+"%22%2C%22startTime%22%3A1469072023376%7D";
        getRequestAsync(url, t, onTrue, onError);
    }

    // 发现 hotel详情解析
    public <T> void getInfoBed(String id ,Class<T>t,OnTrue<T>onTrue,OnError onError) {
        Long startTime = System.currentTimeMillis();
        Long endTime = startTime + 24 * 60 * 60 * 1000;
        String url="http://www.shafalvxing.com/hotel/" +
                "queryHotelDetailRmList.do?bizParams=%7B%22"+startTime+"%22%3A1469666855385%2C%22"+endTime+"%22%3A1469753255385%2C%22" +
                "hotelId%22%3A%22573287213%22%7D";
        getRequestAsync(url, t, onTrue, onError);

    }

}
