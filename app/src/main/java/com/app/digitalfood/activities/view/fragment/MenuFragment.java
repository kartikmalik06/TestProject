package com.app.digitalfood.activities.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.app.digitalfood.DataObject.CategoryGroup;
import com.app.digitalfood.DataObject.Categoryitem;
import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.adapter.ExpandableListBaseAdapter;
import com.app.digitalfood.activities.view.OrderPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by beyond on 23-Feb-17.
 */

public class MenuFragment extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListBaseAdapter expandableListBaseAdapter;
    ArrayList<CategoryGroup> listHeader;
    HashMap<CategoryGroup, List<Categoryitem>> listChild;
    private OrderPage orderPage;
    List<CategoryData> menuList = new ArrayList<>();

    public MenuFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public MenuFragment(OrderPage orderPage, List<CategoryData> menuList) {
        super();
        this.orderPage = orderPage;
        this.menuList = menuList;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        expandableListView = (ExpandableListView) view.findViewById(R.id.food_type);
        Log.d("string", "yes");
        expandableListView.setGroupIndicator(null);
        expandableListBaseAdapter = new ExpandableListBaseAdapter(getContext(), orderPage, menuList);
        expandableListView.setAdapter(expandableListBaseAdapter);

        return view;
    }


}
