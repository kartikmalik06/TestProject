package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.app.digitalfood.DataObject.CategoryGroup;
import com.app.digitalfood.DataObject.Categoryitem;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.OrderPage;
import com.app.digitalfood.activities.view.fragment.MenuFragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by beyond on 23-Feb-17.
 */

public class ExpandableListBaseAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<CategoryGroup> listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<CategoryGroup, List<Categoryitem>> listDataChild;

    OrderPage orderPage;
    CategoryGroup header;
    ArrayList<ArrayList<Boolean>> selectedChildCheckBoxStates = new ArrayList<>();


    public ExpandableListBaseAdapter(Context context, OrderPage orderPage, ArrayList<CategoryGroup> listDataHeader,
                                     HashMap<CategoryGroup, List<Categoryitem>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
        this.orderPage = orderPage;

    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public CategoryGroup getGroup(int groupPosition) {

        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Categoryitem getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        header = getGroup(groupPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView listHeader = (TextView) convertView
                .findViewById(R.id.group_lable);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(header.getName().toString());

        return convertView;

    }

    @Override
    public void onGroupExpanded(int groupPosition) {

        super.onGroupExpanded(groupPosition);

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Categoryitem childItem = getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_item, null);
            holder = new ViewHolder();
            holder.childCheckBox = (CheckBox) convertView.findViewById(R.id.items);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.childCheckBox.setTag(childItem.getItemName());

        }
        holder.childCheckBox.setText(childItem.getItemName());
        if (selectedChildCheckBoxStates.size() <= groupPosition) {
            ArrayList<Boolean> childState = new ArrayList<>();
            for (int i = 0; i < getChildrenCount(groupPosition); i++) {
                if (childState.size() > childPosition)
                    childState.add(childPosition, false);
                else
                    childState.add(false);
            }
            if (selectedChildCheckBoxStates.size() > groupPosition) {
                selectedChildCheckBoxStates.add(groupPosition, childState);
            } else
                selectedChildCheckBoxStates.add(childState);
        } else {
            holder.childCheckBox.setChecked(selectedChildCheckBoxStates.get(groupPosition).get(childPosition));
        }
        holder.childCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = selectedChildCheckBoxStates.get(groupPosition).get(childPosition);
                selectedChildCheckBoxStates.get(groupPosition).remove(childPosition);
                selectedChildCheckBoxStates.get(groupPosition).add(childPosition, state ? false : true);
                if (getChild(groupPosition, childPosition).getChecked()) {
                    orderPage.removeItem(String.valueOf(holder.childCheckBox.getTag()));
                    getChild(groupPosition, childPosition).setChecked(false);
                } else {
                    orderPage.addItem(String.valueOf(holder.childCheckBox.getTag()));
                    getChild(groupPosition, childPosition).setChecked(true);
                }
                //showTotal(groupPosition);

            }
        });

        /*txtListChild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                childItem.setChecked(isChecked);
                notifyDataSetChanged();
            }
        });*/


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolder {

        public CheckBox childCheckBox;
    }

}
