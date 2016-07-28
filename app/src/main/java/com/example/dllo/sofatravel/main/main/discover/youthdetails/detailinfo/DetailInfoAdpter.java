package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
        return bean==null?0:bean.getData().getRmlist().get(groupPosition).getLstRatePlanDto().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return bean==null?0:bean.getData().getRmlist().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return bean==null?0:bean.getData().getRmlist().get(groupPosition).getLstRatePlanDto().get(childPosition);
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
        Glide.with(context).load(bean.getData().getRmlist().get(groupPosition).getRmTypeImageUrl()).into(groupHolder.picture);
        groupHolder.productRoomName.setText(bean.getData().getRmlist().get(groupPosition).getRoomName());

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
        childHolder.breakfast.setText(bean.getData().getRmlist().get(groupPosition).getLstRatePlanDto().get(childPosition).getBreakfast());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
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
    class ChildHolder{
        TextView breakfast;

        public ChildHolder(View view) {
            breakfast= (TextView) view.findViewById(R.id.dis_detail_breakfast);
        }
    }
//    public void setListViewHeightBasedOnChildren(ExpandableListView listView ) {
//        // 获取ListView对应的Adapter
//        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
//        if (listAdapter == null) {
//            // pre -condition
//            return;
//        }
//
//        int totalHeight = 0;
//        for (int i = 0; i < listAdapter.getGroupCount(); i++) { // listAdapter.getCount()返回数据项的数目
//            View listgroupItem = listAdapter .getGroupView(i, true, null, listView );
//            listgroupItem.measure(0, 0); // 计算子项View 的宽高
//            totalHeight += listgroupItem .getMeasuredHeight(); // 统计所有子项的总高度
//            Log.d("DetailInfoAdpter", "height : group" + i + "次" + totalHeight);
//            for (int j = 0; j < listAdapter.getChildrenCount( i); j++) {
//                View listchildItem = listAdapter .getChildView(i, j, false , null, listView);
//                listchildItem.measure(0, 0); // 计算子项View 的宽高
//                totalHeight += listchildItem.getMeasuredHeight(); // 统计所有子项的总高度
//                Log.d("DetailInfoAdpter", "height :" + "group:" + i + " child:" + j + "次" + totalHeight);
//            }
//        }
//
//        ViewGroup.LayoutParams params = listView .getLayoutParams();
//        params.height = totalHeight + ( listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
//        // listView.getDividerHeight()获取子项间分隔符占用的高度
//        // params.height最后得到整个ListView完整显示需要的高度
//        listView.setLayoutParams(params );
//    }
}
