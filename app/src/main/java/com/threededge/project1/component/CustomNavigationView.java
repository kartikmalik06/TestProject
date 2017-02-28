package com.threededge.project1.component;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

import com.threededge.project1.BaseActivity;
import com.threededge.project1.R;

/**
 * Created by beyond on 23-Feb-17.
 */

public class CustomNavigationView extends NavigationView {

    public CustomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNavigationView(Context context) {
        super(context);
    }


    public void setMenuItem(BaseActivity baseActivity) {
        if (baseActivity.isLogin())
        {
            inflateMenu(R.menu.navigation_menu_item_after_login);
        }
        else
        {
            inflateMenu(R.menu.navigation_menu_before_login);
        }
    }
}
