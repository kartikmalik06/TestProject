package com.threededge.project1.homepage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.threededge.project1.BaseActivity;
import com.threededge.project1.R;

import component.CustomEditText;

public class HomePageActivity extends BaseActivity implements View.OnClickListener {


    private CustomEditText postalCode;
    private Button findStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        super.onCreateDrawer();
        //DatabaseHandler databaseHandler=new DatabaseHandler(this);

        findStore = (Button) findViewById(R.id.search_btn);
        postalCode=(CustomEditText) findViewById(R.id.postcode);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findStore.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
       super.buttonAnimation(findStore);
        if(postalCode.isFieldEmpty())
        {

            //need to add server call
        }
    }
}

