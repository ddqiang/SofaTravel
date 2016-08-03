package com.example.dllo.sofatravel.main.main.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.tools.NetWorkOnLine;

/**
 * Created by dllo on 16/7/19.
 */
@SuppressLint("NewApi")
public class HomeGrViewAdapter extends BaseAdapter {

    private HomeBean mHomeBean;
    private Context context;
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;

    }

    public HomeGrViewAdapter(Context context) {
        this.context = context;
    }

    public void setHomeBean(HomeBean homeBean) {
        this.mHomeBean = homeBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mHomeBean == null ? 0 : mHomeBean.getData().getHomePageInfo().getRecommendCity().size();
    }

    @Override
    public Object getItem(int position) {
        return mHomeBean.getData().getHomePageInfo().getRecommendCity().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyGrViewViewHolder holder=null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_grideview_item, parent, false);
            holder = new MyGrViewViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyGrViewViewHolder) convertView.getTag();
        }

        holder.cityTv.setText(mHomeBean.getData().getHomePageInfo().getRecommendCity().get(position).getCityNameCh());
        holder.cityEnglishTv.setText(mHomeBean.getData().getHomePageInfo().getRecommendCity().get(position).getCityNameEn());
        Glide.with(context).load(mHomeBean.getData().getHomePageInfo().getRecommendCity().get(position).getMainPic()).into(holder.imageView);
        if (NetWorkOnLine.isNetworkAvailable()){
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick.onClick(position);

            }
        });
        }else {
            Toast.makeText(context, "请求失败,请检查网络设置", Toast.LENGTH_SHORT).show();
        }
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
