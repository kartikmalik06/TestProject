package com.app.digitalfood.viewpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.app.digitalfood.component.ExpandableListBaseAdapter;
import com.threededge.digitalfood.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by beyond on 23-Feb-17.
 */

public class MenuFragment extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListBaseAdapter expandableListBaseAdapter;
    List<String> listHeader;
    HashMap<String, List<String>> listChild;

    public MenuFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.food_type);
        prepareListData();
        expandableListBaseAdapter = new ExpandableListBaseAdapter(getContext(),listHeader,listChild);
        expandableListView.setAdapter(expandableListBaseAdapter);


        return view;
    }
    //need to remove only for test purpose
    private void prepareListData() {
        listHeader = new ArrayList<String>();
        listChild = new HashMap<String, List<String>>();

        // Adding child data
        listHeader.add("Top 250");
        listHeader.add("Now Showing");
        listHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listChild.put(listHeader.get(0), top250); // Header, Child data
        listChild.put(listHeader.get(1), nowShowing);
        listChild.put(listHeader.get(2), comingSoon);
    }

}
