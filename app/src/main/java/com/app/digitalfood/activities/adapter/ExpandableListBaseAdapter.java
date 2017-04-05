package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.OrderedItem;
import com.app.digitalfood.DataObject.SubCategoryData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.OrderPage;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by beyond on 23-Feb-17.
 */

public class ExpandableListBaseAdapter extends BaseExpandableListAdapter {
    private Context context;
    OrderPage orderPage;
    List<CategoryData> menuList = new ArrayList<>();

    public ExpandableListBaseAdapter(Context context, OrderPage orderPage, List<CategoryData> menuList) {
        this.context = context;
        this.orderPage = orderPage;
        for (CategoryData categoryData:menuList)
        {
            if (categoryData.getSubCategoryData()!=null)
                this.menuList.add(categoryData);
        }


    }

    @Override
    public int getGroupCount() {
        return this.menuList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return menuList.get(groupPosition).getSubCategoryData().size();
    }

    @Override
    public CategoryData getGroup(int groupPosition) {

        return menuList.get(groupPosition);
    }

    @Override
    public SubCategoryData getChild(int groupPosition, int childPosition) {
        return menuList.get(groupPosition).getSubCategoryData().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return (long) (groupPosition * 1024);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (long) (groupPosition * 1024 + childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final CategoryData foodGroup = getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        ImageView groupIndicator = (ImageView) convertView.findViewById(R.id.indicator);
        TextView listHeader = (TextView) convertView
                .findViewById(R.id.group_lable);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(foodGroup.getName());

        return convertView;

    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final SubCategoryData childItem = getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_item, null);
            holder = new ViewHolder();
            holder.itemName = (TextView) convertView.findViewById(R.id.items);
            holder.plus = (TextView) convertView.findViewById(R.id.plus);
            holder.minus = (TextView) convertView.findViewById(R.id.minus);
            holder.quantity = (TextView) convertView.findViewById(R.id.quantity);
            holder.addToCart = (ImageView) convertView.findViewById(R.id.add_cart);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            // holder.itemName.setTag(childItem.getName());
        }

        holder.itemName.setText(childItem.getName());
        holder.quantity.setText(String.valueOf(childItem.getQuantity()));
        if (getChild(groupPosition, childPosition).getChecked()) {
            holder.addToCart.setBackgroundColor(Color.YELLOW);
        } else {
            holder.addToCart.setBackgroundColor(Color.WHITE);
        }
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(holder.quantity.getText().toString()) > 0) {
                    childItem.setQuantity(childItem.getQuantity() - 1);
                    holder.quantity.setText(String.valueOf(childItem.getQuantity()));

                }
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childItem.setQuantity(childItem.getQuantity() + 1);
                holder.quantity.setText(String.valueOf(childItem.getQuantity()));

            }
        });


        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getChild(groupPosition, childPosition).getChecked()) {
                    orderPage.removeItem(childItem);
                    holder.addToCart.setBackgroundColor(Color.WHITE);
                    getChild(groupPosition, childPosition).setChecked(false);
                } else {

                    orderPage.addItem(childItem);
                    holder.addToCart.setBackgroundColor(Color.YELLOW);
                    getChild(groupPosition, childPosition).setChecked(true);
                }

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    class ViewHolder {

        public TextView itemName;
        public TextView plus, minus, quantity;
        public ImageView addToCart;
    }

}
