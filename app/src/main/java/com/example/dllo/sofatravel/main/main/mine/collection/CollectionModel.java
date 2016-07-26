package com.example.dllo.sofatravel.main.main.mine.collection;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionModel implements CollectionContract.Model{

    private CollectionContract.Presenter presenter;
    private CollectionBean bean;

    @Override
    public void setCollectionBean(CollectionBean collectionBean, String account) {
        bean = collectionBean;
    }

    @Override
    public void queryCollectLocalBean(String account) {

    }

    @Override
    public void queryCollectBmoBean(String account) {

    }

    @Override
    public void delletLocalBean(CollectionBean bean, String account) {

    }

    @Override
    public void delletBmobBean(CollectionBean bean, String account) {

    }

    @Override
    public void setPresenter(CollectionContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
