package com.app.digitalfood.activities.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.TextView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iOrderPage;
import com.app.digitalfood.component.SwipableViewPager;
import com.app.digitalfood.activities.adapter.ViewpagerAdapter;


import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BaseActivity implements iOrderPage {
    private TabLayout tabLayout;
    private SwipableViewPager mViewPager;
    private ViewpagerAdapter adapter;
    private TextView itemCount;
     List<String> selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        super.onCreateDrawer();
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (SwipableViewPager) findViewById(R.id.restaurent_info);
        itemCount = (TextView) findViewById(R.id.cart_item);
        adapter = new ViewpagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
        selectedItem = new ArrayList<String>();
        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("Checkout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void addItem(String name) {
        selectedItem.add(name);
        setItemCount();
    }

    private void setItemCount() {
        itemCount.setText(String.valueOf(selectedItem.size()));

    }

    public void removeItem(String name) {
        selectedItem.remove(name);
        setItemCount();
    }
}
