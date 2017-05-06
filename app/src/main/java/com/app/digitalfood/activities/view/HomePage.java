package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.digitalfood.DataObject.BranchType;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.CustomGrid;
import com.app.digitalfood.activities.controllers.HomePageController;
import com.app.digitalfood.activities.controllers.IHomepageController;
import com.app.digitalfood.activities.view.interfaces.iHomePage;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BaseActivity implements iHomePage, View.OnClickListener {


    private Intent intent;
    private IHomepageController iHomepageController;
    private TextView userName, userEmail, discription;
    ImageView userProfile;
    private RecyclerView grid;
    boolean expand=true;
    int comapnyID=6;
    String demoText="Restaurants range from inexpensive and informal lunching or dining places catering to people working nearby, with modest food served in simple settings at low prices, to expensive establishments serving refined food and fine wines in a formal setting";
    private List<BranchType> listBranch = new ArrayList<BranchType>();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        super.onCreateDrawer();
        //DatabaseHandler databaseHandler=new DatabaseHandler(this);
        disableCart();
        userName = (TextView) findViewById(R.id.user_name);
        userEmail = (TextView) findViewById(R.id.user_email);
        userProfile = (ImageView) findViewById(R.id.userProfile);

        //discription = (TextView) findViewById(R.id.discription);

     /*   CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);*/

        super.setActionBarTitle("Home Page");
        iHomepageController = new HomePageController(this);

        setDiscription(expand);

        //  checkDeviceid(getDeviceId());
        if (isLogin()) {
            pd.showDialog();
            Log.d("Fetching:"," Start");
            iHomepageController.getBranches();
            if (listBranch.size() != 0) {
                initGridView();
            }
        } else {
            intent = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(intent);

        }
//      discription.setOnClickListener(this);
    }

    @Override
    public void onReceiveBranches(List<BranchType> listBranch) {
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
        grid = (RecyclerView) findViewById(R.id.grid);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        //ViewCompat.setNestedScrollingEnabled(grid,false);
        grid.setLayoutManager(mLayoutManager);
        grid.setItemAnimator(new DefaultItemAnimator());
        grid.setAdapter(adapter);

        pd.hideDialog();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId()==R.id.discription)
        setDiscription(expand);

    }

   @Override
   public void setDiscription(boolean expand)
    {
       /* if (expand)
        {
            if (discription.getText().length() > 150) {
                String text = discription.getText().toString().substring(0, 80) + "...";
                discription.setText(Html.fromHtml(text + "<font color='green'> <u>View More</u></font>"));
                this.expand=false;
            }
        }
        else
        {
            discription.setText(demoText);
            this.expand=true;
        }*/
    }

    @Override
    public void showToast(String message) {
        pd.hideDialog();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}

