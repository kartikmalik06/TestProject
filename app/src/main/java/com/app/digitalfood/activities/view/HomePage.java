package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iHomePage;
import com.app.digitalfood.component.CustomEditText;


public class HomePage extends BaseActivity implements iHomePage, View.OnClickListener {


    private CustomEditText postalCode;
    private Button findStore;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        super.onCreateDrawer();
        //DatabaseHandler databaseHandler=new DatabaseHandler(this);

        findStore = (Button) findViewById(R.id.search_btn);
        postalCode = (CustomEditText) findViewById(R.id.postcode);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findStore.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.buttonAnimation(findStore);
        pd.showDialog();
        if (postalCode.isFieldEmpty()) {
            if (isLogin()) {


                //need to add server call to get restaurents list according to postal code
              /*  intent = new Intent(getApplicationContext(), OrderPage.class);
                //put restaurents lists
                startActivity(intent);*/
            } else {
               /* intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);*/
            }
        }
    }
}

