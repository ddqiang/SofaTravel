package com.example.dllo.sofatravel.main.main.mine.collection;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LoginOrRegisterFragment;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LorModel;
import com.example.dllo.sofatravel.main.main.mine.loginorregister.LorPresenter;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_colleciton;

    }

    @Override
    public void initView() {
        CollectionFragment fragment = new CollectionFragment();
        CollectionModel model = new CollectionModel();
        CollectionPresenter presenter = new CollectionPresenter(model, fragment);
        fragment.setPresenter(presenter);
        model.setPresenter(presenter);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_collection_framelayout, fragment).commit();
    }

    @Override
    public void initData() {

    }
}
