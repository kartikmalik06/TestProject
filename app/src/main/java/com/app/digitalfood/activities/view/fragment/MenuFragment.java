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

    public MenuFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public MenuFragment(OrderPage context) {
        super();
        this.orderPage = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.food_type);
        Log.d("string","yes");
         prepareListData();
       /* MenuController mController = new MenuController(orderPage);
        mController.getCategoryItem(5,7);*/

        expandableListBaseAdapter = new ExpandableListBaseAdapter(getContext(), orderPage, listHeader, listChild);
        expandableListView.setAdapter(expandableListBaseAdapter);

        return view;
    }


    //need to remove only for test purpose
    private void prepareListData() {
        listHeader = new ArrayList<CategoryGroup>();
        listChild = new HashMap<CategoryGroup, List<Categoryitem>>();

        for (int i = 0; i < 4; i++) {
            CategoryGroup cg = new CategoryGroup();
            cg.setName("Group " + i);
            listHeader.add(cg);
        }

        for (int i = 0; i < 4; i++) {
            List<Categoryitem> lstItem = new ArrayList<Categoryitem>();
            for (int j = 0; j < 5; j++) {
                Categoryitem ci = new Categoryitem();
                ci.setItemName("Item " + j);
                lstItem.add(ci);
            }
            listChild.put(listHeader.get(i), lstItem);
        }

    }


}
