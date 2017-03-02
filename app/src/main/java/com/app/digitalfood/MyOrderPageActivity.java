package com.app.digitalfood;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.app.digitalfood.component.SwipableViewPager;
import com.app.digitalfood.component.ViewpagerAdapter;
import com.threededge.digitalfood.R;

public class MyOrderPageActivity extends BaseActivity {
    private TabLayout tabLayout;
    private SwipableViewPager mViewPager;
    private ViewpagerAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_order_page);
        super.onCreateDrawer();
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (SwipableViewPager) findViewById(R.id.restaurent_info);
        adapter=new ViewpagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("My Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
