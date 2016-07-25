package com.example.dllo.sofatravel.main.main.mine.collection;

import com.example.dllo.sofatravel.main.main.base.BaseModel;
import com.example.dllo.sofatravel.main.main.base.BasePresenter;
import com.example.dllo.sofatravel.main.main.base.BaseView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/23.
 */
public interface CollectionContract {

    interface View extends BaseView<Presenter> {
        void onCollectionSuccess(ArrayList<CollectionBean> arrayList);
        void LocalBeanSuccess(ArrayList<CollectionBean> arrayList);
        void BmobBeanSuccess(ArrayList<CollectionBean> arrayList);
        void delletSuccess();
    }
    interface Presenter extends BasePresenter {
        void setCollectionBean(CollectionBean collectionBean, String account);

        void onCollectionSuccess(ArrayList<CollectionBean> arrayList);

        void queryCollectLocalBean(String account);

        void LocalBeanSuccess(ArrayList<CollectionBean> arrayList);

        void queryCollectBmoBean(String account);

        void BmobBeanSuccess(ArrayList<CollectionBean> arrayList);

        void delletLocalBean(CollectionBean bean, String account);

        void delletBmobBean(CollectionBean bean, String account);

        void delletSuccess();

    }

    interface Model extends BaseModel<Presenter> {
        void setCollectionBean(CollectionBean collectionBean, String account);
        void queryCollectLocalBean(String account);
        void queryCollectBmoBean(String account);
        void delletLocalBean(CollectionBean bean, String account);
        void delletBmobBean(CollectionBean bean, String account);
    }
}
