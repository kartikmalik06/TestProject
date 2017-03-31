package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.app.digitalfood.DataObject.LoginResult;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;

import com.app.digitalfood.activities.controllers.LoginController;
import com.app.digitalfood.activities.controllers.iLoginController;
import com.app.digitalfood.activities.view.interfaces.iLogin;
import com.app.digitalfood.component.CustomEditText;
import com.app.digitalfood.component.FbLogin;
import com.app.digitalfood.component.GoogleSignIn;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;


import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by kartik on 03-Mar-17.
 */

public class LoginPage extends BaseActivity implements View.OnClickListener, iLogin {
    private CustomEditText emailId, password;
    private Button signIn;
    private TextView createAccount, twLogin, fbLogin;
    private TextView rememberMe;
    String name, email, gender, birthday;
    private Intent intent;
    private Animation animation;
    private iLoginController iLoginController;
    private boolean loginStatus = false;

    String profile_pic;
    private ImageLoader imageLoader;

    private int RC_SIGN_IN = 100;
    //google api client

    private FbLogin fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fb = new FbLogin(this);
        setContentView(R.layout.activity_login);
        //filed decalaration
        initViews();

        //controller object
        iLoginController = new LoginController(this);
        //on click listeners
        signIn.setOnClickListener(this);
        createAccount.setOnClickListener(this);
        fbLogin.setOnClickListener(this);
        twLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_btn:
                signIn.startAnimation(animation);
                if ((emailId.isFieldEmpty() && password.isFieldEmpty()) && emailId.isVaildEmail()) {

                    iLoginController.login(emailId.getText().toString(), password.getText().toString(),super.getDeviceId(),"Android");
                    if (isLogin()) {
                        // set login status to true
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
            case R.id.login_fb:
                fb.login();
                break;
            case R.id.login_tw:
                Log.d("tw", "true");
                GoogleSignIn googleSignIn = new GoogleSignIn(this, this);
                googleSignIn.signIn();
                break;
        }

    }




    @Override
    public void setLoginStatus(boolean status) {
        loginStatus = status;
        updateLoginStatus(status);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If signin
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Calling a new function to handle signin
            handleSignInResult(result);
            Toast.makeText(this, result.getSignInAccount().getDisplayName(), Toast.LENGTH_SHORT).show();
        } else {
            fb.callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    //After the signing we are calling this function
    private void handleSignInResult(GoogleSignInResult result) {
        //If the login succeed
        if (result.isSuccess()) {
            //Getting google account
            GoogleSignInAccount acct = result.getSignInAccount();

          /*  //Displaying name and email
            textViewName.setText(acct.getDisplayName());
            textViewEmail.setText(acct.getEmail());

            //Initializing image loader
            imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                    .getImageLoader();

            imageLoader.get(acct.getPhotoUrl().toString(),
                    ImageLoader.getImageListener(profilePhoto,
                            R.mipmap.ic_launcher,
                            R.mipmap.ic_launcher));

            //Loading image
            profilePhoto.setImageUrl(acct.getPhotoUrl().toString(), imageLoader);*/

        } else {
            //If login fails
            Toast.makeText(this, "LoginResult Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void initViews() {
        emailId = (CustomEditText) findViewById(R.id.email_text);
        password = (CustomEditText) findViewById(R.id.password_text);
        signIn = (Button) findViewById(R.id.sign_in_btn);
        rememberMe = (TextView) findViewById(R.id.remember_me);
        createAccount = (TextView) findViewById(R.id.new_user);
        fbLogin = (TextView) findViewById(R.id.login_fb);
        twLogin = (TextView) findViewById(R.id.login_tw);
        animation = new AnimationUtils().loadAnimation(this, R.anim.alpha);
    }

    public void setFbUserData(JSONObject userData) {
        try {
            userData.getString("name");
            Toast.makeText(this, userData.getString("name"), Toast.LENGTH_SHORT).show();
            /*facebookId = object.getString("id");
            facebookName = object.getString("name");
            facebookFirstName = object.getString("first_name");
            facebookLastName = object.getString("last_name");
            facebookEmail = object.getString("email");*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setUserData(LoginResult loginResult) {
        setUserDetail(loginResult);
    }


}
