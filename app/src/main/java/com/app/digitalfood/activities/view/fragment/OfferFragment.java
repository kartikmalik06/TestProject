package com.app.digitalfood.activities.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.app.digitalfood.DataObject.OfferData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.adapter.OfferListAdapter;
import com.app.digitalfood.activities.controllers.IOfferController;
import com.app.digitalfood.activities.controllers.OfferController;

import java.util.ArrayList;
import java.util.List;

public class OfferFragment extends Fragment {


    private List<OfferData> offerDatas=new ArrayList<>();

    private RecyclerView recyclerView;

    public OfferFragment() {
       super();
    }

    @SuppressLint("ValidFragment")
    public OfferFragment(List<OfferData> offerDatas) {
        this.offerDatas=offerDatas;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        OfferListAdapter offerListAdapter = new OfferListAdapter(getContext(), offerDatas);
        /*offerList = (ListView) view.findViewById(R.id.offer_list);

        offerList.setAdapter(offerListAdapter);*/
        recyclerView = (RecyclerView) view.findViewById(R.id.offer_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(offerListAdapter);
        // Inflate the layout for this fragment
        return view;
    }


}
