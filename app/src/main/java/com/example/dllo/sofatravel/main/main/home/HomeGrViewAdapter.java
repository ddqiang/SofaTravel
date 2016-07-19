package com.example.dllo.sofatravel.main.main.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/7/19.
 */
public class HomeGrViewAdapter extends BaseAdapter {

    private HomeBean homeBean;
    private Context context;

    public HomeGrViewAdapter(Context context) {
        this.context = context;
    }

    public void setHomeBean(HomeBean homeBean) {
        this.homeBean = homeBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return homeBean == null ? 0 : homeBean.getData().getHomePageInfo().getRecommendCity().size();
    }

    @Override
    public Object getItem(int position) {
        return homeBean.getData().getHomePageInfo().getRecommendCity().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyGrViewViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_grideview_item, parent, false);
            holder = new MyGrViewViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyGrViewViewHolder) convertView.getTag();
        }
        holder.cityTv.setText(homeBean.getData().getHomePageInfo().getRecommendCity().get(position).getCityNameCh());
        holder.cityEnglishTv.setText(homeBean.getData().getHomePageInfo().getRecommendCity().get(position).getCityNameEn());
        Glide.with(context).load(homeBean.getData().getHomePageInfo().getRecommendCity().get(position).getMainPic()).into(holder.imageView);
        return convertView;
    }

    class MyGrViewViewHolder {
        ImageView imageView;
        TextView cityTv, cityEnglishTv;

        public MyGrViewViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.home_gridView_item_image);
            cityTv = (TextView) view.findViewById(R.id.home_gridView_item_cityName);
            cityEnglishTv = (TextView) view.findViewById(R.id.home_gridView_item_cityNameEnglish);
        }
    }
}
