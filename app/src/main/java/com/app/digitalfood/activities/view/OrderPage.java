package com.app.digitalfood.activities.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.OfferData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.IOrderPageController;
import com.app.digitalfood.activities.controllers.OrderPageController;
import com.app.digitalfood.activities.view.interfaces.iOrderPage;
import com.app.digitalfood.component.SwipableViewPager;
import com.app.digitalfood.activities.adapter.OrderPageAdapter;


import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BaseActivity implements iOrderPage {
    private TabLayout tabLayout;
    private SwipableViewPager mViewPager;
    private OrderPageAdapter adapter;
    private TextView discription;
    boolean expand=true;
    String demoText="Restaurants range from inexpensive and informal lunching or dining places catering to people working nearby, with modest food served in simple settings at low prices, to expensive establishments serving refined food and fine wines in a formal setting";

    IOrderPageController orderPageController;
    String brancch_id;
    List<CategoryData> menuList = new ArrayList<>();
    List<OfferData> offerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);
        super.onCreateDrawer();

        orderPageController = new OrderPageController(this);
        Bundle b = getIntent().getExtras();
        Log.d("State", "order Page");
        if (b != null) {
            Log.d("State", "bundle not null");
            brancch_id = b.getString("branch_id");
            setBranchID(brancch_id);
            orderPageController.getMenuCategories(brancch_id);
        }
        super.setItemCount();
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (SwipableViewPager) findViewById(R.id.view_pager);
       // discription = (TextView) findViewById(R.id.discription);
       // setDiscription(expand);
       /* if (discription.getText().length() > 150) {
            String text = discription.getText().toString().substring(0,80) + "...";
            discription.setText(Html.fromHtml(text + "<font color='green'> <u>View More</u></font>"));
        }*/
        super.setActionBarTitle("Order");
        pd.showDialog();
    }


    @Override
    public void setMenuListinAdapter(List<CategoryData> menuList) {
        this.menuList = menuList;
        adapter = new OrderPageAdapter(getSupportFragmentManager(), this, this.menuList,brancch_id);
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);
        pd.hideDialog();
    }

   /* @Override
    public void setOfferList(List<OfferData> offerList) {
        this.offerList = offerList;
        adapter = new OrderPageAdapter(getSupportFragmentManager(), this, this.menuList, this.offerList);
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);
        pd.hideDialog();
    }*/

    @Override
    public void setDiscription(boolean expand) {
        if (expand) {
            if (discription.getText().length() > 150) {
                String text = discription.getText().toString().substring(0, 80) + "...";
                discription.setText(Html.fromHtml(text + "<font color='green'> <u>View More</u></font>"));
                this.expand = false;
            }
        } else {
            discription.setText(demoText);
            this.expand = true;
        }
    }
}
