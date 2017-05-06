package com.app.digitalfood.activities.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.DemoCheckOut;
import com.app.digitalfood.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 04-Apr-17.
 */

public class SelectedItemListAdapter extends RecyclerView.Adapter<SelectedItemListAdapter.MyViewHolder> {

    List<ItemData> orderedItem = new ArrayList<>();
    DatabaseHandler db;
    DemoCheckOut demoCheckOut;

    public SelectedItemListAdapter(DemoCheckOut demoCheckOut) {
        this.demoCheckOut = demoCheckOut;
        db = DatabaseHandler.getInstance(demoCheckOut);
        this.orderedItem = db.getAllItem(BaseActivity.getBranchID());
    }

    @Override
    public SelectedItemListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_price, parent, false);
        return new SelectedItemListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SelectedItemListAdapter.MyViewHolder holder, final int position) {
        final ItemData item = getItem(position);
        holder.itemName.setText(item.getName());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.amount.setText("Rs. " + String.valueOf(item.getQuantity() * item.getPrice()));
        //holder.pricePerItem.setText(String.valueOf(item.getQuantity() + "*" + "150"));
        //holder.totalPerItem.setText("Rs. "+String.valueOf(item.getQuantity() * 150));
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(holder.quantity.getText().toString()) > 1) {
                    db.removeItem(item.getId());
                    item.setQuantity(orderedItem.get(position).getQuantity() - 1);
                    db.addItem(item, BaseActivity.getBranchID());
                    demoCheckOut.makeInvoice();
                    holder.quantity.setText(String.valueOf(item.getQuantity()));
                    holder.amount.setText("Rs. " + String.valueOf(item.getQuantity() * item.getPrice()));
                }
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeItem(item.getId());
                item.setQuantity(orderedItem.get(position).getQuantity() + 1);
                db.addItem(item, BaseActivity.getBranchID());
                demoCheckOut.makeInvoice();
                holder.quantity.setText(String.valueOf(item.getQuantity()));
                holder.amount.setText("Rs. " + String.valueOf(item.getQuantity() * item.getPrice()));
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeItem(item.getId());
                demoCheckOut.setItemCount();
                orderedItem.remove(position);
                notifyDataSetChanged();
                demoCheckOut.makeInvoice();
            }
        });
    }

    private ItemData getItem(int position) {
        return this.orderedItem.get(position);
    }

    @Override
    public int getItemCount() {
        return orderedItem.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, quantity, amount;
        public ImageView plus, minus, delete;

        public MyViewHolder(View view) {
            super(view);
            itemName = (TextView) view.findViewById(R.id.item_name);
            quantity = (TextView) view.findViewById(R.id.count);
            //pricePerItem = (TextView) view.findViewById(R.id.price_per_item);
            plus = (ImageView) view.findViewById(R.id.plus);
            delete = (ImageView) view.findViewById(R.id.delete);
            minus = (ImageView) view.findViewById(R.id.minus);
            amount = (TextView) view.findViewById(R.id.amount);
        }
    }
}
