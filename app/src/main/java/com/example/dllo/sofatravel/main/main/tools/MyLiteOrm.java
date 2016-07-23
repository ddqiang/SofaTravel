package com.example.dllo.sofatravel.main.main.tools;

import android.content.Context;

import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.mine.UserBeanForLiteOrm;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by dllo on 16/7/21.
 */
public class MyLiteOrm {
    private LiteOrm liteOrm;
    private static MyLiteOrm singleliteOrm = new MyLiteOrm();
    private Context context;

    private MyLiteOrm() {
        this.context = MyApplication.context;
    }

    public static MyLiteOrm getSingleLiteOrm() {
        return singleliteOrm;
    }

    public LiteOrm getLiteOrm() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newCascadeInstance(context, "userInfo.db");
        }
        return liteOrm;
    }


    public void addDataForLiteOrm(Object info) {
        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(info);
    }

    public ArrayList<UserBeanForLiteOrm> getUserInfoDatasFromLiteOrm(String colName, Object colParamter) {
        ArrayList<UserBeanForLiteOrm> datasFromLiteOrm = MyLiteOrm.getSingleLiteOrm().getLiteOrm()
                .query(new QueryBuilder<>(UserBeanForLiteOrm.class)
                        .where(colName + " LIKE ?", new Object[]{colParamter}));
        return datasFromLiteOrm;
    }
}
