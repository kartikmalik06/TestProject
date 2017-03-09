package com.app.digitalfood.activities.view;

import android.os.Bundle;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iReviewPage;


public class ReviewPage extends BaseActivity implements iReviewPage {

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
