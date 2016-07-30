package com.example.dllo.sofatravel.main.main.mine.collection;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionFragment extends BaseFragment implements CollectionContract.View {
    private CollectionAdapter mAdapter;
    private ArrayList<CollectionBean> mDatas;
    private ListView mListView;
    private CollectionContract.Presenter mPresenter;
    private String mCurrentAccount;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine_collection;
    }

    @Override
    public void initView(View view) {
        mDatas = new ArrayList<>();
        mAdapter = new CollectionAdapter(context);
        mListView = (ListView) view.findViewById(R.id.fragment_mine_colleciton_listview);
        SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        mCurrentAccount = sharedPreferences.getString("accountName", "null");
    }

    @Override
    public void initData() {
        mPresenter.queryCollectLocalBean(mCurrentAccount);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.delletBmobBean(mDatas.get(position), mCurrentAccount);
                mPresenter.delletLocalBean(mDatas.get(position), mCurrentAccount);
                return true;
            }

        });
    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {
        Log.d("lanou", "收藏成功");
    }

    @Override
    public void LocalBeanSuccess(ArrayList<CollectionBean> arrayList) {
        mDatas = arrayList;
        mAdapter.setBeans(arrayList);
        if (arrayList.size() == 0) {
            mPresenter.queryCollectBmoBean(mCurrentAccount);
        }
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void BmobBeanSuccess(ArrayList<CollectionBean> arrayList) {
        mDatas = arrayList;
        mAdapter.setBeans(arrayList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void delletSuccess() {

        mPresenter.queryCollectLocalBean(mCurrentAccount);

    }

    @Override
    public void setPresenter(CollectionContract.Presenter Presenter) {
        this.mPresenter = Presenter;
    }
}
