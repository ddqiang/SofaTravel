package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

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
public class HotAdapter extends BaseAdapter {

    private Context context;
    private SelectCityBean bean;

    public HotAdapter(Context context) {
        this.context = context;
    }

    public void setBean(SelectCityBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.getData().getHotCity().size();
    }

    @Override
    public Object getItem(int position) {
        return bean == null ? null : bean.getData().getHotCity().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dis_hot_city,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(bean.getData().getHotCity().get(position).getCityNameCh());

        return convertView;
    }

    class ViewHolder {
        TextView textView;
        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.item_hot_city_tv);
        }
    }
}
