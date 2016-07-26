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
    private CollectionAdapter adapter;
    private ArrayList<CollectionBean> datas;
    private ListView listView;
    private CollectionContract.Presenter presenter;
    private String currentAccount;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine_collection;
    }

    @Override
    public void initView(View view) {
        datas = new ArrayList<>();
        adapter = new CollectionAdapter(context);
        listView = (ListView) view.findViewById(R.id.fragment_mine_colleciton_listview);
        SharedPreferences sharedPreferences = context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
        currentAccount = sharedPreferences.getString("accountName", "null");
    }

    @Override
    public void initData() {
        presenter.queryCollectLocalBean(currentAccount);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.delletBmobBean(datas.get(position), currentAccount);
                presenter.delletLocalBean(datas.get(position), currentAccount);
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
        datas = arrayList;
        adapter.setBeans(arrayList);
        if (arrayList.size() == 0) {
            presenter.queryCollectBmoBean(currentAccount);
        }
        listView.setAdapter(adapter);

    }

    @Override
    public void BmobBeanSuccess(ArrayList<CollectionBean> arrayList) {
        datas = arrayList;
        adapter.setBeans(arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void delletSuccess() {

        presenter.queryCollectLocalBean(currentAccount);

    }

    @Override
    public void setPresenter(CollectionContract.Presenter Presenter) {
        this.presenter = Presenter;
    }
}
