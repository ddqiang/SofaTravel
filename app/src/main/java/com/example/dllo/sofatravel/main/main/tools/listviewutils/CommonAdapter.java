package com.example.dllo.sofatravel.main.main.tools.listviewutils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.sofatravel.main.main.base.MyOnClick;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater inflater;
    private int itemLayoutId;

    public CommonAdapter(Context mContext, List<T> mDatas, int itemLayoutId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyViewHolder holder = MyViewHolder.get(mContext, convertView, parent, itemLayoutId, position);
        convert(holder, getItem(position));


        return holder.getmConvertView();
    }

    //交给子类去添加数据
    public abstract void convert(MyViewHolder holder, T t);

}
