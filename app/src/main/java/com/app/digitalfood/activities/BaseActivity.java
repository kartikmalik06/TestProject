package com.app.digitalfood.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.ChangePassword;
import com.app.digitalfood.activities.view.FavouritePage;
import com.app.digitalfood.activities.view.HomePage;
import com.app.digitalfood.activities.view.MyAddress;
import com.app.digitalfood.activities.view.OrderPage;
import com.app.digitalfood.activities.view.ProfilePage;
import com.app.digitalfood.activities.view.ReviewPage;
import com.app.digitalfood.component.CustomNavigationView;
import com.app.digitalfood.activities.view.LoginPage;
import com.app.digitalfood.activities.view.Signup;
import com.app.digitalfood.component.LoadingView;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kartik on 24-Feb-17.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private CustomNavigationView mCustomNavigationView;
    private ImageView closeImage;
    private Intent intent;
    private int backPressedCount = 0;
    TextView toolBarTitle;
    private Animation animation;
    private Toolbar toolbar;
    protected LoadingView pd;

    protected void onCreateDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mCustomNavigationView = (CustomNavigationView) findViewById(R.id.navigation_view);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        closeImage = (ImageView) findViewById(R.id.im_close);
        toolBarTitle = (TextView) findViewById(R.id.title_name);
        mDrawerLayout.addDrawerListener(this);
       // mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
       // mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        setSupportActionBar(toolbar);
        mCustomNavigationView.getMenu().clear();
        mCustomNavigationView.setMenuItem(this);
        mActionBarDrawerToggle.syncState();
        animation = new AnimationUtils().loadAnimation(this, R.anim.alpha);
        mCustomNavigationView.setNavigationItemSelectedListener(this);
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.closeDrawer(mCustomNavigationView);
                closeImage.setVisibility(View.GONE);
            }
        });
        pd = new LoadingView(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int v = item.getItemId();
        switch (v) {
            case R.id.find_restaurent:
                intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
                break;

            case R.id.login:
                intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
                break;

            case R.id.registration:
                intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                break;

            case R.id.my_order:
                intent = new Intent(getApplicationContext(), OrderPage.class);
                startActivity(intent);
                break;

            case R.id.help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;

            case R.id.profile:
                intent = new Intent(getApplicationContext(), ProfilePage.class);
                startActivity(intent);
                break;

            case R.id.my_address:
                intent = new Intent(getApplicationContext(), MyAddress.class);
                startActivity(intent);
                break;

            case R.id.change_password:
                intent = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(intent);
                break;

            case R.id.favourites:
                intent = new Intent(getApplicationContext(), FavouritePage.class);
                startActivity(intent);
                break;

            case R.id.reviews:
                intent = new Intent(getApplicationContext(), ReviewPage.class);
                startActivity(intent);
                break;

            case R.id.log_out:
                updateLoginStatus(false);
                //erase all login states
                intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
                break;
        }
        mDrawerLayout.closeDrawer(mCustomNavigationView);
        return false;
    }


    public void updateLoginStatus(boolean Login) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        pref.edit().putBoolean("IS_LOGGED_IN", Login).commit();
    }

    public boolean isLogin() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean isLogin = pref.getBoolean("IS_LOGGED_IN", false);
        Log.d("login detail", String.valueOf(isLogin));
        return isLogin;
    }

    public void buttonAnimation(Button button) {
        button.startAnimation(animation);
    }

    //must call before setDisplayHomeAsUpEnabled function
    public void setActionBarTitle(String title) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_title);
        toolBarTitle.setText(title);
    }

    @Override
    public void onBackPressed() {
        if (backPressedCount >= 1) {
            Log.d("back pressed", String.valueOf(backPressedCount));

            moveTaskToBack(true);
            System.exit(1);
        } else {
            backPressedCount = backPressedCount + 1;

            Log.d("back pressed", String.valueOf(backPressedCount));

            Toast.makeText(this, "Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {

                    backPressedCount = 0;

                    Log.d("back pressed", String.valueOf(backPressedCount));
                }
            }, 3000);

        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {


    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {


    }

    @Override
    public void onDrawerStateChanged(int newState) {
        if( newState == DrawerLayout.STATE_SETTLING && mDrawerLayout.isDrawerOpen(mCustomNavigationView) == false )
        {
            closeImage.setVisibility(View.VISIBLE);
        }
        if( newState == DrawerLayout.STATE_SETTLING && mDrawerLayout.isDrawerOpen(mCustomNavigationView) == true )
        {
            closeImage.setVisibility(View.GONE);
        }
    }
}
