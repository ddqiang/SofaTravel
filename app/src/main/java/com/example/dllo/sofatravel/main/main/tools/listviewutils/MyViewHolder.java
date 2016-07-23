package com.example.dllo.sofatravel.main.main.tools.listviewutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.main.main.base.MyApplication;
import com.example.dllo.sofatravel.main.main.base.MyOnClick;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionBean;
import com.example.dllo.sofatravel.main.main.mine.collection.CollectionContract;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/18.
 */
public class MyViewHolder implements CollectionContract.View {
    private SparseArray<View> mViews;
    public int mPosition;
    private View mConvertView;
    public static MyOnClick myOnClick;
    private CollectionContract.Presenter presenter;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    public MyViewHolder(Context context, ViewGroup viewGroup, int layoutId, int position) {
        mPosition = position;
        mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
        mConvertView.setTag(this);
    }

    public static MyViewHolder get(Context context, View convertView, ViewGroup viewGroup, int layoutId, final int position) {
        if (convertView == null) {
            return new MyViewHolder(context, viewGroup, layoutId, position);
        } else {
            MyViewHolder holder = (MyViewHolder) convertView.getTag();
            holder.mPosition = position;

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOnClick.onClick(position);
                }
            });
            return holder;
        }

    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }

    //设置文字
    public MyViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置图片
    public MyViewHolder setImage(int viewId, int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    //设置网络展示图片
    public MyViewHolder setShowImage(int viewId, String imaId) {
        ImageView imageView = getView(viewId);
        Glide.with(imageView.getContext()).load(imaId).into(imageView);
        return this;
    }

    public MyViewHolder collectionImage(final int viewId, final CollectionBean bean) {
        CheckBox imageView = getView(viewId);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = MyApplication.context.getSharedPreferences("saveAccountName", Context.MODE_PRIVATE);
                String accountName = sharedPreferences.getString("accountName", "null");
                presenter.setCollectionBean(bean, accountName);

            }
        });
        return this;
    }

    //设置头像
    public MyViewHolder setHeadImage(int viewId, String imaHeadId) {
        ImageView imageView = getView(viewId);
        Glide.with(imageView.getContext()).load(imaHeadId).into(imageView);
        return this;
    }

    //设置年龄
    public MyViewHolder setAgeText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置性别
    public MyViewHolder setSexText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);

        return this;
    }

    //设置租主的职业
    public MyViewHolder setJobText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置价格
    public MyViewHolder setPriceText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置回复率
    public MyViewHolder setresponseRateText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置标题
    public MyViewHolder setTitleText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    @Override
    public void onCollectionSuccess(ArrayList<CollectionBean> arrayList) {

    }

    @Override
    public void setPresenter(CollectionContract.Presenter Presenter) {
        this.presenter = Presenter;
    }
}
