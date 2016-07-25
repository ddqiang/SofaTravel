package com.example.dllo.sofatravel.main.main.mine.collection;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionFragment extends BaseFragment implements CollectionContract.View {
    private ArrayList<CollectionBean> datas;
    private CollectionAdapter adapter;
    private ListView listView;
    private CollectionContract.Presenter presenter;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine_collection;
    }

    @Override
    public void initView(View view) {
        datas = new ArrayList<>();
        adapter = new CollectionAdapter(context);
        listView = (ListView) view.findViewById(R.id.fragment_mine_colleciton_listview);
    }

    @Override
    public void initData() {


    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {

    }

    @Override
    public void LocalBeanSuccess(ArrayList<CollectionBean> arrayList) {

    }

    @Override
    public void BmobBeanSuccess(ArrayList<CollectionBean> arrayList) {

    }

    @Override
    public void delletSuccess() {

    }

    @Override
    public void setPresenter(CollectionContract.Presenter Presenter) {
        this.presenter = Presenter;
    }
}
