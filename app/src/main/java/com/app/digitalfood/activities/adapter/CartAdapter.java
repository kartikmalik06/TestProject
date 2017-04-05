package com.app.digitalfood.activities.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.digitalfood.DataObject.SubCategoryData;
import com.app.digitalfood.activities.view.fragment.PaymentDetails;
import com.app.digitalfood.activities.view.fragment.ShippingFragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by beyond on 04-Apr-17.
 */

public class CartAdapter extends FragmentStatePagerAdapter {
    List<SubCategoryData> orderedItem;
    private HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();
    public CartAdapter(FragmentManager fm, List<SubCategoryData> orderedItem) {
        super(fm);
        this.orderedItem=orderedItem;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentHashMap.get(position) != null) {
            return fragmentHashMap.get(position);
        }
        Fragment frag = null;
        switch (position) {

            case 0:
                frag = new ShippingFragment();
                break;
            case 1:
                frag = new PaymentDetails(orderedItem);
                fragmentHashMap.put(position, frag);
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
                title = "Address";
                break;
            case 1:
                title = "Payment";
                break;
        }

        return title;
    }
}
