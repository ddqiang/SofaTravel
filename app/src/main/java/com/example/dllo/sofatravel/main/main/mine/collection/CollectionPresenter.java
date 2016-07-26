package com.example.dllo.sofatravel.main.main.mine.collection;


import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
<<<<<<< HEAD
=======

>>>>>>> feature/mineSeven
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
<<<<<<< HEAD
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
=======
        List<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                where("account" + " LIKE ?", new Object[]{account}));
        for (CollectionBean bean : collectionBeanList) {
            MyLiteOrm.getSingleLiteOrm().getLiteOrm().delete(bean);
>>>>>>> feature/mineSeven
        }
    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {
        view.onCollectionSuccess(arrayList);
    }

    @Override
    public void queryCollectLocalBean(String account) {
<<<<<<< HEAD
        modle.queryCollectLocalBean(account);
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void LocalBeanSuccess(ArrayList<CollectionBean> arrayList) {
<<<<<<< HEAD
        view.LocalBeanSuccess(arrayList);
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void queryCollectBmoBean(String account) {
<<<<<<< HEAD
        modle.queryCollectLocalBean(account);
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void BmobBeanSuccess(ArrayList<CollectionBean> arrayList) {
<<<<<<< HEAD
        view.BmobBeanSuccess(arrayList);
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void delletLocalBean(CollectionBean bean, String account) {
<<<<<<< HEAD
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
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void delletBmobBean(CollectionBean bean, String account) {
<<<<<<< HEAD
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
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void delletSuccess() {
<<<<<<< HEAD
        view.delletSuccess();
=======

>>>>>>> feature/mineSeven
    }

    @Override
    public void start() {
        modle.setPresenter(this);
    }
}
