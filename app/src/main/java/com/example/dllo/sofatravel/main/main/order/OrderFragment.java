package com.example.dllo.sofatravel.main.main.order;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseFragment;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.order.OrderBean;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/18.
 */
public class OrderFragment extends BaseFragment {
    private ListView orderListView;
    private MineOrderAdapter adapter;
    private ArrayList<OrderBean> bean;
    private ArrayList<OrderBean> orderBeen;

    @Override
    public int setLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView(View view) {
        orderListView = (ListView) view.findViewById(R.id.order_list);

    }

    @Override
    public void initData() {
        bean = new ArrayList<>();
        adapter = new MineOrderAdapter(context);
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
                Toast.makeText(context, "删除了订单", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
