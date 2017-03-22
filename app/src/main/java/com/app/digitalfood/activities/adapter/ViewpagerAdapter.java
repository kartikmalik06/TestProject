package com.app.digitalfood.activities.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.digitalfood.activities.view.OrderPage;
import com.app.digitalfood.activities.view.fragment.MenuFragment;
import com.app.digitalfood.activities.view.fragment.ShippingActivity;

/**
 * Created by beyond on 23-Feb-17.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private OrderPage context;

    public ViewpagerAdapter(FragmentManager fm, OrderPage context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {

            case 0:
                frag = new ShippingActivity();
                break;
            case 1:
                frag = new ShippingActivity();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";
        switch (position) {
            case 0:
                title = "Billing and shipping details";
                break;
            case 1:
                title = "Payment";
                break;

        }

        return title;
    }
}
