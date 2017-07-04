package com.app.digitalfood.activities.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.digitalfood.activities.view.fragment.WhatsNewFragment;

/**
 * Created by beyond on 01-Jun-17.
 */

public class CategoryMenuPagerAdapter extends FragmentPagerAdapter {
    int[] imgRes;
    public CategoryMenuPagerAdapter(FragmentManager fm, int[] imgRes) {
        super(fm);
        this.imgRes=imgRes;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        frag = new WhatsNewFragment(imgRes[position]);
        return frag;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }
}
