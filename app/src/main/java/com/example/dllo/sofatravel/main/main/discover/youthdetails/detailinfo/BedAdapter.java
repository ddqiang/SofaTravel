package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

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
 * Created by dllo on 16/7/28.
 */
public class BedAdapter extends BaseAdapter {
    private Context context;
    private DetailBedBean bean;

    public void setBean(DetailBedBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public BedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean==null?0:bean.getData().getRmlist().size();
    }

    @Override
    public Object getItem(int position) {
        return bean==null?0:bean.getData().getRmlist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GroupHolder groupHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_dis_detail_info,parent,false);
            groupHolder=new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }
        Glide.with(context).load(bean.getData().getRmlist().get(position).getRmTypeImageUrl()).into(groupHolder.picture);
        groupHolder.productRoomName.setText(bean.getData().getRmlist().get(position).getProductRoomName());
        groupHolder.price.setText(bean.getData().getRmlist().get(position).getPrice() + "");

        return convertView;
    }

    class GroupHolder{
        ImageView picture;
        TextView price;
        TextView productRoomName;

        public GroupHolder(View view) {
            picture= (ImageView) view.findViewById(R.id.dis_detail_info_picture);
            price= (TextView) view.findViewById(R.id.dis_detail_info_price);
            productRoomName= (TextView) view.findViewById(R.id.dis_detail_product_roomName);
        }
    }
}
