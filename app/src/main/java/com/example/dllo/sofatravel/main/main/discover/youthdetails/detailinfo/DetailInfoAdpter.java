package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;

/**
 * Created by dllo on 16/7/21.
 */
public class DetailInfoAdpter extends BaseAdapter {
    private DetailInfoBean bean;

    public void setBean(DetailInfoBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }
    private Context context;

    public DetailInfoAdpter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean==null?0:bean.getData().getAmenities().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getAmenities().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.activity_dis_detail_info,parent,false);
            myViewHolder=new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        myViewHolder.shareTitle.setText(bean.getData().getActivityDto().getShareTitle());
        return convertView;
    }
    class  MyViewHolder{
        TextView shareTitle;
        public MyViewHolder(View view) {
            shareTitle= (TextView) view.findViewById(R.id.dis_detail_info_share_title);

        }
    }

}
