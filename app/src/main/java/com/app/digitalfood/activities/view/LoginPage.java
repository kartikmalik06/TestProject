package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.iLoginController;
import com.app.digitalfood.activities.view.interfaces.iLogin;
import com.app.digitalfood.component.CustomEditText;


/**
 * Created by kartik on 03-Mar-17.
 */

public class LoginPage extends BaseActivity implements View.OnClickListener, iLogin {
    private CustomEditText emailId, password;
    private Button signIn;
    private TextView createAccount, forgotPassword;
    private CheckBox rememberMe;
    private Intent intent;
    private Animation animation;
    private iLoginController iLoginController;
    private boolean loginStatus=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        super.onCreateDrawer();

        //filed decalaration
        emailId = (CustomEditText) findViewById(R.id.email_text);
        password = (CustomEditText) findViewById(R.id.password_text);
        signIn = (Button) findViewById(R.id.sign_in_btn);
        rememberMe = (CheckBox) findViewById(R.id.remember_me_check);
        createAccount = (TextView) findViewById(R.id.new_user);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("Sign In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //button animation
        animation = new AnimationUtils().loadAnimation(this, R.anim.alpha);

        //controller object
//        iLoginController = new LoginController(this);

        //on click listeners
        signIn.setOnClickListener(this);
        createAccount.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_in_btn:
                signIn.startAnimation(animation);
                if ((emailId.isFieldEmpty() && password.isFieldEmpty()) && emailId.isVaildEmail()) {
                   // iLoginController.login(emailId.getText().toString(), password.getText().toString());
                    if (isSignInSuccessfull()) {
                        // set login status to true
                        super.setLoginStatus(true);
                        intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                        break;
                    } else {
                        Toast.makeText(this, "Sign in error..!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                break;

            case R.id.new_user:
                intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                break;
            case R.id.forgot_password:
                intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
                break;
        }

    }


    @Override
    public boolean isSignInSuccessfull() {

        return loginStatus;
    }

    public void setLoginStatus(boolean status)
    {
        loginStatus=status;
    }
}
