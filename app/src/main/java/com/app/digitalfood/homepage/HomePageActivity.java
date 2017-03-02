package com.app.digitalfood.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.digitalfood.BaseActivity;
import com.app.digitalfood.ListRestaurentActivity;
import com.app.digitalfood.component.CustomEditText;
import com.app.digitalfood.userauth.LoginActivity;
import com.threededge.digitalfood.R;

public class HomePageActivity extends BaseActivity implements View.OnClickListener {


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
        if (postalCode.isFieldEmpty()) {
            if (isLogin()) {
                //need to add server call to get restaurents list according to postal code
                intent = new Intent(getApplicationContext(), ListRestaurentActivity.class);
                //put restaurents lists
                startActivity(intent);
            } else {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        }
    }
}

