package com.example.dllo.sofatravel.main.main.discover.youthdetails.order.mineorder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.order.OrderBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/1.
 */
public class MineOrderAdapter extends BaseAdapter {
    private ArrayList<OrderBean>bean;
    private Context context;

    public void setBean(ArrayList<OrderBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public MineOrderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean==null?0:bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_dis_mine_order,parent,false);
            myViewHolder=new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        myViewHolder.hotelName.setText(bean.get(position).getHotelNAme());
        myViewHolder.name.setText(bean.get(position).getUserName());
        myViewHolder.phoneNumber.setText(bean.get(position).getPhoneNumber());
        myViewHolder.bed.setText(bean.get(position).getBed() + "");
        myViewHolder.price.setText(bean.get(position).getPrice() );
        myViewHolder.address.setText(bean.get(position).getAddress());
        Log.d("MineOrderAdapter", bean.get(position).getAddress());
        return convertView;
    }
    class MyViewHolder{
        TextView hotelName, name, phoneNumber, time, bed, price, address;

        public MyViewHolder(View view) {
            hotelName= (TextView) view.findViewById(R.id.dis_mine_order_hotel_name);
            name = (TextView) view.findViewById(R.id.dis_mine_order_user_name);
            phoneNumber = (TextView) view.findViewById(R.id.dis_mine_order_phone_number);
            time = (TextView) view.findViewById(R.id.dis_mine_order_time);
            bed = (TextView) view.findViewById(R.id.dis_mine_order_bed);
            price = (TextView) view.findViewById(R.id.dis_mine_order_price);
            address = (TextView) view.findViewById(R.id.dis_mine_order_address);
        }
    }
}
