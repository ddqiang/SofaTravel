package com.example.dllo.sofatravel.main.main.mine.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/7/23.
 */
public class CollectionAdapter extends BaseAdapter {
    private ArrayList<CollectionBean> mbeans;
    private Context mcontext;

    public void setBeans(ArrayList<CollectionBean> beans) {
        this.mbeans = beans;
        notifyDataSetChanged();
    }

    public CollectionAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return mbeans == null ? 0 : mbeans.size();
    }

    @Override
    public Object getItem(int position) {
        return mbeans == null ? null : mbeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_fragment_mine_collection_listview_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Glide.with(mcontext).load(mbeans.get(position).getSpaceImage()).into(viewHolder.itemFragmentMineCollectionListviewLayoutMessageShowIv);
        Glide.with(mcontext).load(mbeans.get(position).getOwnerHead()).into(viewHolder.itemFragmentMineCollectionListviewLayoutMessageHead);
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageAge.setText((int) mbeans.get(position).getOwnerAge() + "");
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageJob.setText(mbeans.get(position).getOwnerJob());
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageName.setText(mbeans.get(position).getOwnerName());
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageResponseRate.setText((int) mbeans.get(position).getResponseRate() + "");
        viewHolder.itemFragmentMineCollectionListviewLayoutMessagePrice.setText((int) mbeans.get(position).getPrice() + "");
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageSex.setText(mbeans.get(position).getOwnerSex());
        viewHolder.itemFragmentMineCollectionListviewLayoutMessageTitle.setText(mbeans.get(position).getTitle());
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_showIv)
        ImageView itemFragmentMineCollectionListviewLayoutMessageShowIv;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_collection_image)
        CheckBox itemFragmentMineCollectionListviewLayoutCollectionImage;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_head)
        CircleImageView itemFragmentMineCollectionListviewLayoutMessageHead;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_name)
        TextView itemFragmentMineCollectionListviewLayoutMessageName;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_age)
        TextView itemFragmentMineCollectionListviewLayoutMessageAge;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_age_age)
        TextView itemFragmentMineCollectionListviewLayoutMessageAgeAge;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_sex)
        TextView itemFragmentMineCollectionListviewLayoutMessageSex;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_job)
        TextView itemFragmentMineCollectionListviewLayoutMessageJob;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_title)
        TextView itemFragmentMineCollectionListviewLayoutMessageTitle;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_region)
        TextView itemFragmentMineCollectionListviewLayoutMessageRegion;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_room)
        TextView itemFragmentMineCollectionListviewLayoutMessageRoom;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_bed)
        TextView itemFragmentMineCollectionListviewLayoutMessageBed;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_symbol)
        TextView itemFragmentMineCollectionListviewLayoutMessageSymbol;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_price)
        TextView itemFragmentMineCollectionListviewLayoutMessagePrice;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_response)
        TextView itemFragmentMineCollectionListviewLayoutMessageResponse;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_response_rate)
        TextView itemFragmentMineCollectionListviewLayoutMessageResponseRate;
        @InjectView(R.id.item_fragment_mine_collection_listview_layout_message_percentage)
        TextView itemFragmentMineCollectionListviewLayoutMessagePercentage;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);

        }
    }
}
