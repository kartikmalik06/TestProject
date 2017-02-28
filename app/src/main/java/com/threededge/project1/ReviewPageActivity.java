package com.threededge.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
