package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;

/**
 * Created by dllo on 16/7/21.
 */
public class DetailInfoAdpter extends BaseExpandableListAdapter {
    private Context context;
    private DetailBedBean bean;

    public void setBean(DetailBedBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public DetailInfoAdpter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return bean==null?0:bean.getData().getRmlist().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return bean==null?0:bean.getData().getRmlist().get(groupPosition).getAmenities().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return bean==null?0:bean.getData().getRmlist().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return bean==null?0:bean.getData().getRmlist().get(groupPosition).getAmenities().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_dis_detail_info,parent,false);
            groupHolder=new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }
//        Glide.with(context).load(bean.getData().getRmlist().get(groupPosition).getPictureList());
        groupHolder.price.setText(bean.getData().getRmlist().get(groupPosition).getPrice());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_dis_detail_info,parent,false);
           childHolder=new ChildHolder(convertView);
            convertView.setTag(childHolder);
        }else {
            childHolder= (ChildHolder) convertView.getTag();
        }
        childHolder.breakfast.setText(bean.getData().getRmlist().get(childPosition).getLstRatePlanDto().get(childPosition).getBreakfast());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    class GroupHolder{
        ImageView picture;
        TextView price;

        public GroupHolder(View view) {
            picture= (ImageView) view.findViewById(R.id.dis_detail_info_picture);
            price= (TextView) view.findViewById(R.id.dis_detail_info_price);
        }
    }
    class ChildHolder{
        TextView breakfast;

        public ChildHolder(View view) {
            breakfast= (TextView) view.findViewById(R.id.dis_detail_breakfast);
        }
    }
}
