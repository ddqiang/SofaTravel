package com.example.dllo.sofatravel.main.main.mine.myhouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.mine.HouseInfoBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/4.
 */
public class MyHouseAdapter extends BaseAdapter {
    private ArrayList<HouseInfoBean> beans;
    private Context context;

    public void setBeans(ArrayList<HouseInfoBean> beans) {
        this.beans = beans;
        notifyDataSetChanged();
    }

    public MyHouseAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return beans == null ? 0 : beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans == null ? null : beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_my_house_show_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(beans.get(position).getHouseTitle());
        holder.traffic.setText(beans.get(position).getTrafficInfo());
        holder.number.setText(beans.get(position).getMaxPeople());
        holder.price.setText(beans.get(position).getPerPrice());
        holder.bed.setText(beans.get(position).getBedType());
        holder.house.setText(beans.get(position).getHouseType());
        holder.info.setText(beans.get(position).getHosueInfo());
        holder.fac.setText(beans.get(position).getFacilitie());
        holder.imageView.setImageBitmap(beans.get(position).getImage());
        return convertView;

    }

    class ViewHolder {
        TextView title, price, number, bed, house, info, traffic, fac;
        ImageView imageView;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.item_activity_house_show_title);
            price = (TextView) view.findViewById(R.id.item_activity_house_show_price);
            number = (TextView) view.findViewById(R.id.item_activity_house_show_maxpeople);
            bed = (TextView) view.findViewById(R.id.item_activity_house_show_bedtype);
            house = (TextView) view.findViewById(R.id.item_activity_house_show_housetype);
            info = (TextView) view.findViewById(R.id.item_activity_house_show_house_info);
            traffic = (TextView) view.findViewById(R.id.item_activity_house_show_house_traffic);
            fac = (TextView) view.findViewById(R.id.item_activity_house_show_fac);
            imageView = (ImageView) view.findViewById(R.id.item_activity_house_show_imageview);
        }
    }
}
