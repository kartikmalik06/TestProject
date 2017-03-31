package com.app.digitalfood.activities.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.OfferData;
import com.app.digitalfood.activities.view.fragment.OfferFragment;
import com.app.digitalfood.activities.view.OrderPage;
import com.app.digitalfood.activities.view.fragment.InfoFragment;
import com.app.digitalfood.activities.view.fragment.MenuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 23-Feb-17.
 */

public class OrderPageAdapter extends FragmentStatePagerAdapter {
    private OrderPage orderPage;
    List<CategoryData> menuList=new ArrayList<CategoryData>();
    List<OfferData> OfferDatas=new ArrayList<OfferData>();
    public OrderPageAdapter(FragmentManager fm, OrderPage orderPage, List<CategoryData> menuList, List<OfferData> OfferDatas) {
        super(fm);
        this.orderPage=orderPage;
        this.menuList=menuList;
        this.OfferDatas=OfferDatas;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {

            case 0:
                frag = new MenuFragment(orderPage,menuList);
                break;
            case 1:
                frag = new OfferFragment(OfferDatas);
                break;
            case 2:
                frag = new InfoFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";
        switch (position) {
            case 0:
                title = "Menu";
                break;
            case 1:
                title = "Offer";
                break;
            case 2:
                title = "Info";
                break;

        }

        return title;
    }
}
