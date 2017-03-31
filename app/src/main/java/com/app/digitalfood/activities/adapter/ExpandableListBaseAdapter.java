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

public class ExpandableListBaseAdapter extends BaseExpandableListAdapter implements AdapterView.OnItemSelectedListener {
    private Context context;
    OrderPage orderPage;
    OrderedItem orderedItem;
    List<CategoryData> menuList = new ArrayList<>();
    Integer[] listquantity = {1, 2, 3, 4, 5};
    boolean clicked = false;


    ArrayList<ArrayList<Boolean>> selectedChildCheckBoxStates = new ArrayList<>();

    public ExpandableListBaseAdapter(Context context, OrderPage orderPage, List<CategoryData> menuList) {
        this.context = context;
        this.orderPage = orderPage;
        this.menuList = menuList;
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
            holder.dropDown = (Spinner) convertView.findViewById(R.id.dropdown);
            holder.addToCart = (ImageView) convertView.findViewById(R.id.add_cart);
            orderedItem = new OrderedItem();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            // holder.itemName.setTag(childItem.getName());
        }
        holder.itemName.setText(childItem.getName());
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listquantity);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.dropDown.setAdapter(dataAdapter);


        if (getChild(groupPosition, childPosition).getChecked()) {
            holder.addToCart.setBackgroundColor(Color.YELLOW);
        } else {
            holder.addToCart.setBackgroundColor(Color.WHITE);
        }
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getChild(groupPosition,childPosition).getChecked())
                {
                    orderPage.removeItem(getChildId(groupPosition,childPosition));
                    holder.addToCart.setBackgroundColor(Color.WHITE);
                    getChild(groupPosition, childPosition).setChecked(false);
                }
                else
                {
                    orderPage.addItem(getChildId(groupPosition,childPosition),orderedItem);
                    holder.addToCart.setBackgroundColor(Color.YELLOW);
                    getChild(groupPosition,childPosition).setChecked(true);
                }

            }
        });
        holder.dropDown.setOnItemSelectedListener(this);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Integer quantity = (Integer) parent.getItemAtPosition(position);
        orderedItem.setQuantity(quantity);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class ViewHolder {

        public TextView itemName;
        public Spinner dropDown;
        public ImageView addToCart;
    }

}
