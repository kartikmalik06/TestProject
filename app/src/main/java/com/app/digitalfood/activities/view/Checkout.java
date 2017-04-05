package com.app.digitalfood.activities.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.DataObject.SubCategoryData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.CartAdapter;
import com.app.digitalfood.activities.view.fragment.PaymentDetails;
import com.app.digitalfood.activities.view.interfaces.iCart;
import com.app.digitalfood.component.SwipableViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 02-Mar-17.
 */

public class Checkout extends BaseActivity implements iCart {
    List<SubCategoryData> orderedItem = new ArrayList<>();
    private TabLayout tabLayout;
    private SwipableViewPager mViewPager;
    Address shippingAddress = new Address();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        super.onCreateDrawer();
        Bundle b = getIntent().getExtras();
        if (b != null) {
            orderedItem = (List<SubCategoryData>) b.getSerializable("OrderedItem");
        }
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (SwipableViewPager) findViewById(R.id.view_pager);
        mViewPager.setPagingEnabled(false);
        CartAdapter cartAdapter = new CartAdapter(getSupportFragmentManager(), orderedItem);
        super.setActionBarTitle("Checkout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager.setAdapter(cartAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void changefragment(Address address) {
        CartAdapter fa = (CartAdapter) mViewPager.getAdapter();
        PaymentDetails f = (PaymentDetails) fa.getItem(1);
        f.setShippingAddress(address);
        mViewPager.setCurrentItem(1);
    }

}
