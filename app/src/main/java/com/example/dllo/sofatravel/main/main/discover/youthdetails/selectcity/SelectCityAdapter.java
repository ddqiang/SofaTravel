package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;

/**
 * Created by dllo on 16/7/21.
 */
public class SelectCityAdapter extends BaseExpandableListAdapter {
    private Context context;
    private  SelectCityBean bean;


    public void setBean(SelectCityBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }
    public SelectCityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return bean==null?0:bean.getData().getSearchCity().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return bean==null?0:bean.getData().getSearchCity().get(groupPosition).getCity().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return bean==null?0:bean.getData().getSearchCity().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return  bean==null?0:bean.getData().getSearchCity().get(groupPosition).getCity().get(childPosition);
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_dis_select_city,parent,false);
            groupHolder=new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }
        groupHolder.cityTv.setText(bean.getData().getSearchCity().get(groupPosition).getWord());
        return convertView;
    }
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_dis_select_child_city,parent,false);
            childHolder=new ChildHolder(convertView);
            convertView.setTag(childHolder);
        }else {
            childHolder= (ChildHolder) convertView.getTag();
        }
        childHolder.childCityTv.setText(bean.getData().getSearchCity().get(groupPosition).getCity().get(childPosition).getCityNameCh());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    class  GroupHolder{
        TextView cityTv;
        public GroupHolder(View view) {
            cityTv= (TextView) view.findViewById(R.id.dis_select_city_tv);
        }
    }
    class ChildHolder{
        TextView childCityTv;
        public ChildHolder(View view) {
            childCityTv= (TextView) view.findViewById(R.id.dis_select_child_city_tv);
        }
    }
}

