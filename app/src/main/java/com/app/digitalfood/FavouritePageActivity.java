package com.app.digitalfood;

import android.os.Bundle;

import com.threededge.digitalfood.R;

public class FavouritePageActivity extends BaseActivity {

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
