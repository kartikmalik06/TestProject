package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.SubCategoryData;
import com.app.digitalfood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 04-Apr-17.
 */

public class SelectedItemListAdapter  extends RecyclerView.Adapter<SelectedItemListAdapter.MyViewHolder> {

    List<SubCategoryData> orderedItem=new ArrayList<>();



    public SelectedItemListAdapter( List<SubCategoryData> orderedItem) {
        this.orderedItem = orderedItem;
    }

    @Override
    public SelectedItemListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_price, parent, false);

        return new SelectedItemListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SelectedItemListAdapter.MyViewHolder holder, int position) {
        SubCategoryData item = getItem(position);
        holder.itemName.setText(item.getName());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.pricePerItem.setText(String.valueOf(item.getQuantity() + "*" + "150"));
        holder.totalPerItem.setText(String.valueOf(item.getQuantity() * 150));

    }

    private SubCategoryData getItem(int position) {
        return this.orderedItem.get(position);
    }

    @Override
    public int getItemCount() {
        return orderedItem.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, quantity, pricePerItem, totalPerItem;

        public MyViewHolder(View view) {
            super(view);
            itemName = (TextView) view.findViewById(R.id.item_name);
            quantity = (TextView) view.findViewById(R.id.quantity);
            pricePerItem = (TextView) view.findViewById(R.id.price_per_item);
            totalPerItem = (TextView) view.findViewById(R.id.total_per_item);
        }


    }
}
