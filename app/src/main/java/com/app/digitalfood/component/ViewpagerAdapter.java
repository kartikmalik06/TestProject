package com.app.digitalfood.component;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.digitalfood.viewpagerfragment.MenuFragment;
import com.app.digitalfood.viewpagerfragment.ReviewFragment;

/**
 * Created by beyond on 23-Feb-17.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new MenuFragment();
                break;
           case 1:
                frag = new ReviewFragment();
                break;
            case 2:
                frag = new ReviewFragment();
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
                title = "Review";
                break;
            case 2:
                title = "Info";
                break;
        }

        return title;
    }
}
