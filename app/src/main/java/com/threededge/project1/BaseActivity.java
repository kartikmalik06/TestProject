package com.threededge.project1;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.threededge.project1.homepage.HomePageActivity;
import com.threededge.project1.userauth.LoginActivity;
import com.threededge.project1.userauth.SignupActivity;

import java.util.Timer;
import java.util.TimerTask;

import com.threededge.project1.component.CustomNavigationView;

/**
 * Created by beyond on 24-Feb-17.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private CustomNavigationView mCustomNavigationView;
    private Intent intent;
    private int backPressedCount = 0;
    TextView toolBarTitle;
    private Animation animation;
    private Toolbar toolbar;


    protected void onCreateDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mCustomNavigationView = (CustomNavigationView) findViewById(R.id.navigation_view);
        toolbar=(Toolbar)  findViewById(R.id.tool_bar);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        toolBarTitle = (TextView) findViewById(R.id.title_name);
        setSupportActionBar(toolbar);
        mCustomNavigationView.getMenu().clear();
        mCustomNavigationView.setMenuItem(this);
        mActionBarDrawerToggle.syncState();
        animation = new AnimationUtils().loadAnimation(this, R.anim.alpha);
        mCustomNavigationView.setNavigationItemSelectedListener(this);
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
                intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
                break;

            case R.id.login:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.registration:
                intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;

            case R.id.my_order:
                intent = new Intent(getApplicationContext(), MyOrderPageActivity.class);
                startActivity(intent);
                break;

            case R.id.help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;

            case R.id.profile:
                intent = new Intent(getApplicationContext(), ProfilePageActivity.class);
                startActivity(intent);
                break;

            case R.id.my_address:
                intent = new Intent(getApplicationContext(), MyAddressActivity.class);
                startActivity(intent);
                break;

            case R.id.change_password:
                intent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                startActivity(intent);
                break;

            case R.id.favourites:
                intent = new Intent(getApplicationContext(), FavouritePageActivity.class);
                startActivity(intent);
                break;

            case R.id.reviews:
                intent = new Intent(getApplicationContext(), ReviewPageActivity.class);
                startActivity(intent);
                break;

            case R.id.log_out:
                setLoginStatus(false);
                intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
                break;
        }
        mDrawerLayout.closeDrawer(mCustomNavigationView);
        return false;
    }


    public void setLoginStatus(boolean Login) {
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
}
