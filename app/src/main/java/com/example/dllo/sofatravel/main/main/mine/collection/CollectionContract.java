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

    }

    interface Presenter extends BasePresenter {
        void setCollectionBean(CollectionBean collectionBean, String account);
        void onCollectionSuccess(ArrayList<CollectionBean> arrayList);

    }

    interface Model extends BaseModel<Presenter> {
        void setCollectionBean(CollectionBean collectionBean,String account);
    }
}
