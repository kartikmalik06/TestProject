package com.app.digitalfood.activities.adapter;

/**
 * Created by beyond on 28-Mar-17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.digitalfood.DataObject.BranchType;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.OrderPage;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomGrid extends RecyclerView.Adapter<CustomGrid.Viewholder> {
    private Context mContext;
    private List<BranchType> web = new ArrayList<BranchType>();


    public CustomGrid(Context c, List<BranchType> web) {
        mContext = c;
        this.web = web;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);

        return new CustomGrid.Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        holder.restaurentName.setText(web.get(position).getName().trim());
        holder.branchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderPage.class);
                intent.putExtra("branch_id", String.valueOf(web.get(position).getId()));
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return web.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView restaurentName, foodType, distance;
        ConstraintLayout branchLayout;
        public Viewholder(View itemView) {
            super(itemView);
            restaurentName = (TextView) itemView.findViewById(R.id.restaurent_name);
            foodType = (TextView) itemView.findViewById(R.id.food_type);
            distance = (TextView) itemView.findViewById(R.id.distance);
            branchLayout=(ConstraintLayout) itemView.findViewById(R.id.branch_layout);
        }
    }
}