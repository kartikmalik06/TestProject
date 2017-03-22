package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.HomePageController;
import com.app.digitalfood.activities.controllers.iHomepageController;
import com.app.digitalfood.activities.view.interfaces.iHomePage;
import com.app.digitalfood.component.CustomEditText;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class HomePage extends BaseActivity implements iHomePage, View.OnClickListener {


    private CustomEditText postalCode;
    private Button findStore;
    private Intent intent;
    private iHomepageController iHomepageController;
    private TextView userName, userEmail;
    ImageView userProfile;
    // GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        super.onCreateDrawer();
        //DatabaseHandler databaseHandler=new DatabaseHandler(this);
        //   final LatLng HAMBURG = new LatLng(53.558, 9.927);

        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        findStore = (Button) findViewById(R.id.search_btn);
        postalCode = (CustomEditText) findViewById(R.id.postcode);
        userName = (TextView) findViewById(R.id.user_name);
        userEmail = (TextView) findViewById(R.id.user_email);
        userProfile = (ImageView) findViewById(R.id.userProfile);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        iHomepageController = new HomePageController(this);
        checkDeviceid(android_id);
        findStore.setOnClickListener(this);
        Bundle b = getIntent().getExtras();
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
        userProfile.setImageBitmap(bmp);
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


    @Override
    public void onClick(View v) {
        super.buttonAnimation(findStore);
        pd.showDialog();
        if (postalCode.isFieldEmpty()) {
            if (isLogin()) {


                //need to add server call to get restaurents list according to postal code
              /*  intent = new Intent(getApplicationContext(), OrderPage.class);
                //put restaurents lists
                startActivity(intent);*/
            } else {
                intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void checkDeviceid(String deviceId) {

        if (iHomepageController.vailadateUser(deviceId)) {

        } else {
            updateLoginStatus(false);
            //need to add db clear command

        }
    }
}

