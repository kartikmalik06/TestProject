package com.threededge.project1.userauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.threededge.project1.BaseActivity;
import com.threededge.project1.R;
import com.threededge.project1.homepage.HomePageActivity;

import com.threededge.project1.component.CustomEditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    CustomEditText emailId, password;
    Button signIn;
    TextView createAccount, forgotPassword;
    CheckBox rememberMe;
    Intent intent;
    private Animation animation;

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
                if ((emailId.isFieldEmpty() && password.isFieldEmpty())) {
                    emailId.getText();
                    password.getText().toString();
                    //need to add webservice call to sign in
                    if (isSignInSuccessfull()) {
                        // set login status to true
                        super.setLoginStatus(true);
                        intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                        break;
                    } else {
                        Toast.makeText(this, "Sign in error..!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                break;

            case R.id.new_user:
                intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
            case R.id.forgot_password:
                intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
                break;
        }

    }


    private boolean isSignInSuccessfull() {
        return true;
    }
}
