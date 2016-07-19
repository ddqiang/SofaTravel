package com.example.dllo.sofatravel.main.main.discover.youthdetails;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
