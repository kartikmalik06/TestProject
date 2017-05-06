package com.app.digitalfood.activities.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.digitalfood.DataObject.CategoryGroup;
import com.app.digitalfood.DataObject.Categoryitem;
import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.adapter.ItemListAdapter;
import com.app.digitalfood.activities.view.OrderPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by beyond on 23-Feb-17.
 */

public class MenuFragment extends Fragment {

    RecyclerView listView;
    ItemListAdapter expandableListBaseAdapter;
    ArrayList<CategoryGroup> listHeader;
    HashMap<CategoryGroup, List<Categoryitem>> listChild;
    private OrderPage orderPage;
    List<ItemData> itemList = new ArrayList<>();

    public MenuFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public MenuFragment(OrderPage orderPage, List<ItemData> itemList) {
        super();
        this.orderPage = orderPage;
        this.itemList = itemList;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        listView = (RecyclerView) view.findViewById(R.id.recycler_view);
        Log.d("string", "yes");
        expandableListBaseAdapter = new ItemListAdapter(orderPage, itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(orderPage);
        //ViewCompat.setNestedScrollingEnabled(grid,false);
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(expandableListBaseAdapter);
        return view;
    }


}
