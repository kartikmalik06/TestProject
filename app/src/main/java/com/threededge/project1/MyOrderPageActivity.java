package com.threededge.project1;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import component.SwipableViewPager;
import component.ViewpagerAdapter;

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
