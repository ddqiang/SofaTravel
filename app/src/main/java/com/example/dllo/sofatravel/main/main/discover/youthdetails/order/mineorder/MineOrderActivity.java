package com.example.dllo.sofatravel.main.main.discover.youthdetails.order.mineorder;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.order.OrderBean;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/1.
 */
public class MineOrderActivity extends BaseActivity {
    private ListView orderListView;
    private MineOrderAdapter adapter;
    private ArrayList<OrderBean>bean;
    private ArrayList<OrderBean> orderBeen;
    @Override
    public int getLayout() {
        return R.layout.activity_mine_order;
    }

    @Override
    public void initView() {
        orderListView= (ListView) findViewById(R.id.dis_mine_order_list);

    }
    @Override
    public void initData() {
        bean=new ArrayList<>();
        adapter=new MineOrderAdapter(this);
        orderBeen = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(OrderBean.class);
        adapter.setBean(orderBeen);
        orderListView.setAdapter(adapter);

        orderListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                OrderBean orderBean = MyLiteOrm.getSingleLiteOrm().getLiteOrm().queryById(orderBeen.get(position).getId(), OrderBean.class);
                MyLiteOrm.getSingleLiteOrm().getLiteOrm().delete(orderBean);
                orderBeen = MyLiteOrm.getSingleLiteOrm().getLiteOrm().query(OrderBean.class);
                adapter.setBean(orderBeen);
                Toast.makeText(MineOrderActivity.this, "删除了订单", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
