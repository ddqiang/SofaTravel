package com.example.dllo.sofatravel.main.main.mine.collection;

import android.widget.CheckBox;

import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.impl.SingleSQLiteImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionPresenter implements CollectionContract.Presenter {
    private CollectionContract.Model modle;
    private CollectionContract.View view;
    private CheckBox checkBox;

    public CollectionPresenter(CollectionContract.Model modle, CollectionContract.View view) {
        this.modle = modle;
        this.view = view;
    }

    @Override
    public void setCollectionBean(CollectionBean collectionBean, String account) {
        List<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                where("account" + " LIKE ?", new String[]{account}));
        for (CollectionBean bean : collectionBeanList) {
            MyLiteOrm.getSingleLiteOrm().getLiteOrm().delete(bean);
        }
        modle.setCollectionBean(collectionBean, account);
    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {
        view.onCollectionSuccess(arrayList);
    }

    @Override
    public void start() {
        modle.setPresenter(this);
    }
}
