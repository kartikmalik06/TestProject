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
    //List<OfferData> OfferDatas=new ArrayList<OfferData>();
    String brancch_id;
    public OrderPageAdapter(FragmentManager fm, OrderPage orderPage, List<CategoryData> menuList, String brancch_id) {
        super(fm);
        this.orderPage=orderPage;
        this.menuList=menuList;
        this.brancch_id=brancch_id;

       // this.OfferDatas=OfferDatas;
    }

    @Override
    public MenuFragment getItem(int position) {

       // Fragment frag = null;
        /*switch (position) {

            case 0:
                frag = new MenuFragment(orderPage,menuList);
                break;
            case 1:
                frag = new OfferFragment(OfferDatas);
                break;
            case 2:
                frag = new InfoFragment();
                break;
        }*/
        return new MenuFragment(orderPage,menuList.get(position).getItemData());
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = menuList.get(position).getName();
        /*switch (position) {
            case 0:
                title = "Menu";
                break;
            case 1:
                title = "Offer";
                break;
            case 2:
                title = "Info";
                break;

        }*/

        return title;
    }
}
