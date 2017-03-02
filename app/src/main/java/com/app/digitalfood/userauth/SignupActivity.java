package com.app.digitalfood.userauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.digitalfood.BaseActivity;
import com.app.digitalfood.component.CustomEditText;
import com.app.digitalfood.homepage.HomePageActivity;
import com.threededge.digitalfood.R;

public class SignupActivity extends BaseActivity implements View.OnClickListener {
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
        phoneNumber = (CustomEditText) findViewById(R.id.phone_no_text);
        password = (CustomEditText) findViewById(R.id.password_text);
        confirmPassword = (CustomEditText) findViewById(R.id.confirm_pass_text);
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
            super.setLoginStatus(true);
            //get all edit text value
            intent = new Intent(getApplicationContext(), HomePageActivity.class);
            startActivity(intent);
        }
    }
}
