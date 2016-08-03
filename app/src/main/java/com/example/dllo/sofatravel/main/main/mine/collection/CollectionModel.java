package com.example.dllo.sofatravel.main.main.mine.collection;

import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionModel implements CollectionContract.Model {
    private CollectionContract.Presenter mPresenter;
    private CollectionBean mBean;

    //存储
    @Override
    public void setCollectionBean(CollectionBean collectionBean, String account) {
        mBean = collectionBean;
        MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(collectionBean);
        mBean.save(MyApplication.context, new SaveListener() {
            @Override
            public void onSuccess() {
                mPresenter.onCollectionSuccess(new ArrayList<CollectionBean>());
            }

            @Override
            public void onFailure(int i, String s) {
            }
        });
    }

    //查询本地数据库
    @Override
    public void queryCollectLocalBean(String account) {
//        ArrayList<CollectionBean> datas = MyLiteOrm.getSingleLiteOrm().
//                getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).where("account" + " LIKE ?", new String[]{account}));

        ArrayList<CollectionBean> collectionBeanList = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).
                where("account" + " LIKE ?", new Object[]{account}));
        mPresenter.LocalBeanSuccess(collectionBeanList);
//            MyLiteOrm.getSingleLiteOrm().getLiteOrm().delete(new WhereBuilder(CollectionBean.class)
//                    .where("spaceId " + " = ?", new Object[]{String.valueOf(collectionBeanList.get(0).getSpaceId())}));
    }

    //查询网络数据库
    @Override
    public void queryCollectBmoBean(String account) {
        BmobQuery<CollectionBean> bmobQuery = new BmobQuery<CollectionBean>();
        bmobQuery.addWhereEqualTo("accountName", account);
        bmobQuery.findObjects(MyApplication.context, new FindListener<CollectionBean>() {
            @Override
            public void onSuccess(List<CollectionBean> list) {
                ArrayList<CollectionBean> list1 = (ArrayList<CollectionBean>) list;
                mPresenter.BmobBeanSuccess(list1);
            }

            @Override
            public void onError(int i, String s) {
            }
        });

    }

    //删除本地
    @Override
    public void delletLocalBean(CollectionBean bean, String account) {
        ArrayList<CollectionBean> datas = MyLiteOrm.getSingleLiteOrm().
                getLiteOrm().query(new QueryBuilder<>(CollectionBean.class).where("account" + " LIKE ?", new Object[]{account}));
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getSpaceId() == bean.getSpaceId()) {
                MyLiteOrm.getSingleLiteOrm().getLiteOrm().delete(bean);
                mPresenter.delletSuccess();
            }
        }


    }

    //删除网络
    @Override
    public void delletBmobBean(CollectionBean bean, String account) {
        BmobQuery<CollectionBean> bmobQuery = new BmobQuery<CollectionBean>();
        bmobQuery.addWhereEqualTo("accountName", account);
        bmobQuery.addWhereEqualTo("spaceId", bean.getSpaceId());
        bmobQuery.findObjects(MyApplication.context, new FindListener<CollectionBean>() {
            @Override
            public void onSuccess(List<CollectionBean> list) {
//                ArrayList<CollectionBean> list1 = (ArrayList<CollectionBean>) list;
//                presenter.onCollectionSuccess(list1);
                for (CollectionBean collectionBean : list) {
                    collectionBean.delete(MyApplication.context);
                }
            }

            @Override
            public void onError(int i, String s) {
            }
        });
    }

    @Override
    public void setPresenter(CollectionContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
