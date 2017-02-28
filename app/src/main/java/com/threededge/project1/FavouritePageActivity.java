package com.threededge.project1;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
