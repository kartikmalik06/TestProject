package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.BranchType;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.CustomGrid;
import com.app.digitalfood.activities.controllers.HomePageController;
import com.app.digitalfood.activities.controllers.IHomepageController;
import com.app.digitalfood.activities.view.interfaces.iHomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomePage extends BaseActivity implements iHomePage {


    private Intent intent;
    private IHomepageController iHomepageController;
    private TextView userName, userEmail;
    private EditText searchText;
    ImageView userProfile;
    private GridView grid;
    private List<BranchType> listBranch = new ArrayList<BranchType>();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        super.onCreateDrawer();
        //DatabaseHandler databaseHandler=new DatabaseHandler(this);

        userName = (TextView) findViewById(R.id.user_name);
        userEmail = (TextView) findViewById(R.id.user_email);
        userProfile = (ImageView) findViewById(R.id.userProfile);
        searchText=(EditText) findViewById(R.id.searchtext);
        searchText.setShowSoftInputOnFocus(false);
        super.setActionBarTitle("Home Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        iHomepageController = new HomePageController(this);
        //  checkDeviceid(getDeviceId());
        if (isLogin()) {
            pd.showDialog();
            iHomepageController.getGridViewData();
            if (listBranch.size() != 0) {
                initGridView();
            }
        } else {
            intent = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(intent);

        }
       /* Bundle b = getIntent().getExtras();
        userName.setText(b.getString("name"));
        userEmail.setText(b.getString("email"));
        URL url = null;
        try {
            url = new URL(b.getString("profilepic"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        userProfile.setImageBitmap(bmp);*/
       /* map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        Marker marker1 = map.addMarker(new MarkerOptions().position(HAMBURG));
        marker1.setTitle("Hotel Location");
        // Marker marker2=map.addMarker(new MarkerOptions().position(KIEL));
        CameraUpdate center =
                CameraUpdateFactory.newLatLng(HAMBURG);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        map.moveCamera(center);
        map.animateCamera(zoom);*/
    }


    /* @Override
     public void onClick(View v) {
         super.buttonAnimation(findStore);
         pd.showDialog();
         if (postalCode.isFieldEmpty()) {
             if (isLogin()) {


                 //need to add server call to get restaurents list according to postal code
               *//*  intent = new Intent(getApplicationContext(), OrderPage.class);
                //put restaurents lists
                startActivity(intent);*//*
            } else {
                intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        }
    }*/
    @Override
    public void setBranchList(List<BranchType> listBranch) {
        this.listBranch = listBranch;
        initGridView();
    }

    @Override
    public void checkDeviceid(String deviceId) {

        if (iHomepageController.vailadateUser(deviceId)) {

        } else {
            updateLoginStatus(false);
            //need to add db clear command

        }
    }

    public void initGridView() {
        CustomGrid adapter = new CustomGrid(this, listBranch);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), OrderPage.class);
                Bundle b=new Bundle();
               // b.putString("branch_id", String.valueOf(listBranch.get(position).getId()));
                intent.putExtra("branch_id",String.valueOf(listBranch.get(position).getId()));
                startActivity(intent);

            }
        });
        pd.hideDialog();
    }
}

