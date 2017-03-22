package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iSignup;
import com.app.digitalfood.component.CustomEditText;


public class Signup extends BaseActivity implements iSignup, View.OnClickListener {
    CustomEditText name, email, phoneNumber, password, confirmPassword;
    Button submit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        super.onCreateDrawer();
        name = (CustomEditText) findViewById(R.id.name_text);
        email = (CustomEditText) findViewById(R.id.email_text);
        phoneNumber = (CustomEditText) findViewById(R.id.phone_text);
        password = (CustomEditText) findViewById(R.id.password_text);
       // confirmPassword = (CustomEditText) findViewById(R.id.confirm_pass_text);
        submit = (Button) findViewById(R.id.sign_up_button);

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("SIGN UP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if ((name.isFieldEmpty()&&email.isFieldEmpty()&&
                phoneNumber.isFieldEmpty()&&
                password.isFieldEmpty()&&
                confirmPassword.isFieldEmpty()&&email.isVaildEmail())) {
            /*DatabaseHandler databaseHandler=new DatabaseHandler(this);
            databaseHandler.addUserInfo(name.getText().toString(),true);*/
            super.updateLoginStatus(true);
            //get all edit text value
            intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
        }
    }
}
