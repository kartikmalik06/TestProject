package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.SignupController;
import com.app.digitalfood.activities.controllers.iSignupController;
import com.app.digitalfood.activities.view.interfaces.iSignup;
import com.app.digitalfood.component.CustomEditText;
import com.app.digitalfood.database.DatabaseHandler;

public class Signup extends BaseActivity implements iSignup, View.OnClickListener {
    CustomEditText name, email, phoneNumber, password, confirmPassword;
    Button submit;
    private iSignupController iSignupController;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //super.onCreateDrawer();
        name = (CustomEditText) findViewById(R.id.name_text);
        email = (CustomEditText) findViewById(R.id.email_text);
        phoneNumber = (CustomEditText) findViewById(R.id.phone_text);
        password = (CustomEditText) findViewById(R.id.password_text);
        // confirmPassword = (CustomEditText) findViewById(R.id.confirm_pass_text);

        iSignupController = new SignupController(this);
        submit = (Button) findViewById(R.id.sign_up_button);
        //must call before setDisplayHomeAsUpEnabled function
        //super.setActionBarTitle("SIGN UP");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if ((name.isFieldEmpty() && email.isFieldEmpty() && phoneNumber.isFieldEmpty() && password.isFieldEmpty() && email.isVaildEmail())) {


            iSignupController.addUser(name.getText().toString(), email.getText().toString(), password.getText().toString(), password.getText().toString(), phoneNumber.getText().toString(), getDeviceId(), "Android");

            if (isLogin()) {
            DatabaseHandler databaseHandler=new DatabaseHandler(this);
            databaseHandler.addUserInfo(name.getText().toString(),true);
            intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
                //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void setResult(boolean status) {
        updateLoginStatus(status);
    }
}
