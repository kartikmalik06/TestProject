package com.app.digitalfood.activities.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.OfferData;
import com.app.digitalfood.DataObject.OrderedItem;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.IOrderPageController;
import com.app.digitalfood.activities.controllers.OrderPageController;
import com.app.digitalfood.activities.view.interfaces.iOrderPage;
import com.app.digitalfood.component.SwipableViewPager;
import com.app.digitalfood.activities.adapter.OrderPageAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderPage extends BaseActivity implements iOrderPage, View.OnClickListener {
    private TabLayout tabLayout;
    private SwipableViewPager mViewPager;
    private OrderPageAdapter adapter;
    private TextView itemCount;
    private ImageView cartButton;
    HashMap<Long,OrderedItem> selectedItem;
    IOrderPageController orderPageController;
    String brancch_id;
    List<CategoryData> menuList=new ArrayList<>();
    List<OfferData> offerList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);
        super.onCreateDrawer();

        orderPageController = new OrderPageController(this);
        Bundle b = getIntent().getExtras();
        Log.d("State", "Activity Called");
        if (b != null) {
            Log.d("State", "bundle not null");

            brancch_id = b.getString("branch_id");
            orderPageController.getMenuCategories(brancch_id);

        }
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (SwipableViewPager) findViewById(R.id.view_pager);
        itemCount = (TextView) findViewById(R.id.cart_item);
        selectedItem = new HashMap<>();
        cartButton=(ImageView) findViewById(R.id.cart);

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cartButton.setOnClickListener(this);

    }

    public void addItem(Long id,OrderedItem name) {
        selectedItem.put(id,name);
        setItemCount();
    }
    public void removeItem(Long id) {
        selectedItem.remove(id);
        setItemCount();
    }
    private void setItemCount() {
        if (selectedItem.size() <= 0) {
            itemCount.setVisibility(View.GONE);
        } else {
            itemCount.setVisibility(View.VISIBLE);
            itemCount.setText(String.valueOf(selectedItem.size()));
        }
    }



    @Override
    public void setMenuListinAdapter(List<CategoryData> menuList) {
        this.menuList = menuList;

    }

    @Override
    public void setOfferList(List<OfferData> offerList) {
        this.offerList = offerList;
        adapter = new OrderPageAdapter(getSupportFragmentManager(), this, this.menuList, this.offerList);
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {




    }
}
