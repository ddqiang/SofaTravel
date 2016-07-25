package com.example.dllo.sofatravel.main.main.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/7/25.
 */
public class ConversationAdapter extends RecyclerView.Adapter {
    private ArrayList<ConversationBean> beans;
    private Context context;
    private static final int SEND_TYPE = 1;
    private static final int RECEIVE_TYPE = 2;

    public void setBeans(ArrayList<ConversationBean> beans) {
        this.beans = beans;
        notifyDataSetChanged();
    }

    public ConversationAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return beans.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case SEND_TYPE:
                View sendView = LayoutInflater.from(context).inflate(R.layout.item_send_message, null);
                viewHolder = new sendViewHolder(sendView);
                break;
            case RECEIVE_TYPE:
                View receiveView = LayoutInflater.from(context).inflate(R.layout.item_receive_message, null);
                viewHolder = new receiveViewHolder(receiveView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof sendViewHolder) {
            ((sendViewHolder) holder).userName.setText(beans.get(position).getSendUserName());
            ((sendViewHolder) holder).content.setText(beans.get(position).getText());

        } else if (holder instanceof receiveViewHolder) {
            ((receiveViewHolder) holder).userName.setText(beans.get(position).getReceiverUserName());
            ((receiveViewHolder) holder).content.setText(beans.get(position).getText());
        }


    }

    @Override
    public int getItemCount() {
        return beans == null ? 0 : beans.size();
    }

    class sendViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView content;
        ImageView userImage;

        public sendViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.send_user_name);
            content = (TextView) itemView.findViewById(R.id.send_content);
            userImage = (ImageView) itemView.findViewById(R.id.send_user_head_image);

        }
    }

    class receiveViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView content;
        ImageView userImage;

        public receiveViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.receive_user_name);
            content = (TextView) itemView.findViewById(R.id.receive_content);
            userImage = (ImageView) itemView.findViewById(R.id.receive_user_head_image);
        }
    }


}
