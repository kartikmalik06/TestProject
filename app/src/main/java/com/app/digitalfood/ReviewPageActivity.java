package com.app.digitalfood;

import android.os.Bundle;

import com.threededge.digitalfood.R;

public class ReviewPageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        super.onCreateDrawer();

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("MY REVIEW");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
