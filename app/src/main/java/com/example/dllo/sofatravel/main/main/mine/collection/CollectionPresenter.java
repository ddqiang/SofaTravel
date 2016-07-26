package com.example.dllo.sofatravel.main.main.mine.collection;


import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionPresenter implements CollectionContract.Presenter {
    private CollectionContract.Model modle;
    private CollectionContract.View view;
    boolean hasThis;

    public CollectionPresenter(CollectionContract.Model modle, CollectionContract.View view) {
        this.modle = modle;
        this.view = view;
    }

    @Override
    public void setCollectionBean(CollectionBean collectionBean, String account) {
        if (account != null) {
            List<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                    where("account" + " LIKE ?", new String[]{account}));

            for (int i = 0; i < collectionBeanList.size(); i++) {
                if (collectionBean.getSpaceId() == collectionBeanList.get(i).getSpaceId()) {
                    hasThis = true;
                } else {
                    hasThis = false;
                }
            }
            if (hasThis) {

            } else {
                modle.setCollectionBean(collectionBean, account);
            }
        }
    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {
        view.onCollectionSuccess(arrayList);
    }

    @Override
    public void queryCollectLocalBean(String account) {
        modle.queryCollectLocalBean(account);
    }

    @Override
    public void LocalBeanSuccess(ArrayList<CollectionBean> arrayList) {
        view.LocalBeanSuccess(arrayList);
    }

    @Override
    public void queryCollectBmoBean(String account) {
        modle.queryCollectLocalBean(account);
    }

    @Override
    public void BmobBeanSuccess(ArrayList<CollectionBean> arrayList) {
        view.BmobBeanSuccess(arrayList);
    }

    @Override
    public void delletLocalBean(CollectionBean bean, String account) {
        if (account != null) {
            List<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                    where("account" + " LIKE ?", new String[]{account}));
            for (int i = 0; i < collectionBeanList.size(); i++) {
                if (bean.getSpaceId() == collectionBeanList.get(i).getSpaceId()) {
                    hasThis = true;
                } else {
                    hasThis = false;
                }
            }
            if (hasThis == true) {
                modle.delletLocalBean(bean, account);
            }
        }
    }

    @Override
    public void delletBmobBean(CollectionBean bean, String account) {
        if (account != null) {
            List<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                    where("account" + " LIKE ?", new String[]{account}));
            for (int i = 0; i < collectionBeanList.size(); i++) {
                if (bean.getSpaceId() == collectionBeanList.get(i).getSpaceId()) {
                    hasThis = true;
                } else {
                    hasThis = false;
                }
            }
            if (hasThis == true) {
                modle.delletBmobBean(bean, account);
            }
        }
    }

    @Override
    public void delletSuccess() {
        view.delletSuccess();
    }

    @Override
    public void start() {
        modle.setPresenter(this);
    }
}
