package com.app.digitalfood.component;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.app.digitalfood.activities.view.CategoryMenu;

/**
 * Created by beyond on 23-Feb-17.
 */

public class SwipableViewPager extends ViewPager {

    private boolean enabled;
    public SwipableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onTouchEvent(ev);
        }

        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(ev);
        }

        return false;
    }
    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }



}
