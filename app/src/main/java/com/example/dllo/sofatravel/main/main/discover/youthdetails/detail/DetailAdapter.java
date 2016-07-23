package com.example.dllo.sofatravel.main.main.discover.youthdetails.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;

/**
 * Created by dllo on 16/7/18.
 */
public class DetailAdapter extends BaseAdapter {
    private DetailBean bean;

    public void setBean(DetailBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    private Context context;

    public DetailAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.getData().getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getResult().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_discover_detail, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.hotelName.setText(bean.getData().getResult().get(position).getHotelName());
        Glide.with(context).load(bean.getData().getResult().get(position).getThumbnailId()).into(myViewHolder.thumbnailId);
        myViewHolder.address.setText(bean.getData().getResult().get(position).getAddress());
        myViewHolder.businessZone.setText(bean.getData().getResult().get(position).getBusinessZone());
        myViewHolder.district.setText(bean.getData().getResult().get(position).getDistrict());
        int price = bean.getData().getResult().get(position).getPrice();
        myViewHolder.price.setText(String.valueOf(price));
        return convertView;
    }

    class MyViewHolder {
        ImageView thumbnailId;
        TextView hotelName, district, businessZone, address, price;

        public MyViewHolder(View view) {
            thumbnailId = (ImageView) view.findViewById(R.id.item_dis_detail_thumbnail);
            hotelName = (TextView) view.findViewById(R.id.dis_detail_hotel_name);
            district = (TextView) view.findViewById(R.id.dis_detail_district);
            businessZone = (TextView) view.findViewById(R.id.dis_detail_business_zone);
            address = (TextView) view.findViewById(R.id.dis_detail_address);
            price = (TextView) view.findViewById(R.id.dis_detail_price);
        }
    }
}

