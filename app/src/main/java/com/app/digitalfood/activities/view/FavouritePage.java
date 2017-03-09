package com.app.digitalfood.activities.view;

import android.os.Bundle;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iFavouritePage;


public class FavouritePage extends BaseActivity implements iFavouritePage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_page);
        super.onCreateDrawer();

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("FAVOURITES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
