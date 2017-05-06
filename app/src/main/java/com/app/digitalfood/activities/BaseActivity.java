package com.app.digitalfood.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
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

import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.DataObject.LoginResult;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.ChangePassword;
import com.app.digitalfood.activities.view.DemoCheckOut;
import com.app.digitalfood.activities.view.FavouritePage;
import com.app.digitalfood.activities.view.HomePage;
import com.app.digitalfood.activities.view.MyAddress;
import com.app.digitalfood.activities.view.ProfilePage;
import com.app.digitalfood.activities.view.ReviewPage;
import com.app.digitalfood.component.CustomNavigationView;
import com.app.digitalfood.activities.view.LoginPage;
import com.app.digitalfood.activities.view.Signup;
import com.app.digitalfood.component.LoadingView;
import com.app.digitalfood.database.DatabaseHandler;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kartik on 24-Feb-17.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener, View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private CustomNavigationView mCustomNavigationView;
    private ImageView closeImage,drawerMenu;
    private Intent intent;
    static List<ItemData> selectedItem;
    private int backPressedCount = 0;
    private TextView toolBarTitle, itemCount;
    private TextView userName, userEmail;
    private Animation animation;
    private Toolbar toolbar;
    public static String branchID;
    public LoadingView pd;
    private ImageView cartButton;
    private boolean isDrawerOpen=false;
    public DatabaseHandler db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animation = new AnimationUtils().loadAnimation(this, R.anim.alpha);
        db=DatabaseHandler.getInstance(this);
        pd = new LoadingView(this);
    }

    protected void onCreateDrawer() {
        initViews();
        mDrawerLayout.addDrawerListener(this);
        drawerMenu.setOnClickListener(this);
        setSupportActionBar(toolbar);
        mCustomNavigationView.getMenu().clear();
        mCustomNavigationView.setMenuItem(this);
        mActionBarDrawerToggle.syncState();
        mCustomNavigationView.setNavigationItemSelectedListener(this);
        closeImage.setOnClickListener(this);
        cartButton.setOnClickListener(this);
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
            case R.id.home:
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
        boolean isLogin = pref.getBoolean("IS_LOGGED_IN", true);
        Log.d("login detail", String.valueOf(isLogin));
        return isLogin;
    }

    public void buttonAnimation(Button button) {
        button.startAnimation(animation);
    }

    //must call before setDisplayHomeAsUpEnabled function
    public void setActionBarTitle(String title) {
        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.id.title_name);*/
        toolBarTitle.setText(title);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        setItemCount();
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
        if (newState == DrawerLayout.STATE_SETTLING && !mDrawerLayout.isDrawerOpen(mCustomNavigationView)) {
            closeImage.setVisibility(View.VISIBLE);
        }
        if (newState == DrawerLayout.STATE_SETTLING && mDrawerLayout.isDrawerOpen(mCustomNavigationView)) {
            closeImage.setVisibility(View.GONE);
        }
    }
public void disableCart()
{
    cartButton.setVisibility(View.INVISIBLE);
    itemCount.setVisibility(View.GONE);
}
    public String getDeviceId() {
        @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        return android_id;
    }
    public static String getBranchID() {
        return branchID;
    }

    public static void setBranchID(String branchID) {
        BaseActivity.branchID = branchID;
    }
    public void setUserDetail(LoginResult loginResult) {
        userName.setText(loginResult.getData().getFirstName() + " " + loginResult.getData().getLastName());
        userEmail.setText(loginResult.getData().getEmail());
    }

    public void startAnimation(Button button) {
        button.startAnimation(animation);
    }

    public void addItem(ItemData itemData, String branch_id) {
        db.addItem(itemData,branch_id);
       // selectedItem.add(subCategoryData);
        setItemCount();
    }

    public void removeItem(ItemData itemData) {
        if (db.removeItem(itemData.getId())) {
            //selectedItem.remove(subCategoryData);
            setItemCount();
        }
    }

    public void setItemCount() {
       if (branchID!=null)
        if ( db.getItemCount(branchID) <= 0) {
            itemCount.setVisibility(View.GONE);
        } else {
            itemCount.setVisibility(View.VISIBLE);
            itemCount.setText(String.valueOf(db.getItemCount(branchID)));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cart:
                if (db.getItemCount(branchID) > 0) {
                    pd.showDialog();
                    Intent intent = new Intent(getApplicationContext(), DemoCheckOut.class);
                   intent.putExtra("OrderedItem", (Serializable) db.getAllItem(branchID));
                    pd.hideDialog();
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Sorry you have nothing in cart", Toast.LENGTH_SHORT).show();
            }
                break;
            case R.id.im_close:
                mDrawerLayout.closeDrawer(mCustomNavigationView);
                closeImage.setVisibility(View.GONE);
                break;

            case R.id.drawer_menu:
                if (isDrawerOpen)
                {
                    mDrawerLayout.closeDrawer(mCustomNavigationView);
                }
                else
                {
                     mDrawerLayout.openDrawer(mCustomNavigationView);
                }
               isDrawerOpen=!isDrawerOpen;
                break;
        }
    }


    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mCustomNavigationView = (CustomNavigationView) findViewById(R.id.navigation_view);
        drawerMenu=(ImageView) findViewById(R.id.drawer_menu);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        closeImage = (ImageView) findViewById(R.id.im_close);
        toolBarTitle = (TextView) findViewById(R.id.title_name);
        itemCount = (TextView) findViewById(R.id.cart_item);
        userEmail = (TextView) findViewById(R.id.user_email);
        userName = (TextView) findViewById(R.id.user_name);
        selectedItem = new ArrayList<>();
        cartButton = (ImageView) findViewById(R.id.cart);


    }
}
