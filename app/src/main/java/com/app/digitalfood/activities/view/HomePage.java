package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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
import com.app.digitalfood.component.CustomEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomePage extends BaseActivity implements iHomePage, View.OnClickListener {


    private Intent intent;
    private IHomepageController iHomepageController;
    private TextView userName, userEmail, discription;
    ImageView userProfile;
    private GridView grid;
    boolean expand=true;
    String demoText="Restaurants range from inexpensive and informal lunching or dining places catering to people working nearby, with modest food served in simple settings at low prices, to expensive establishments serving refined food and fine wines in a formal setting";
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

        discription = (TextView) findViewById(R.id.discription);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        super.setActionBarTitle("Home Page");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iHomepageController = new HomePageController(this);

        setDiscription(expand);

        //  checkDeviceid(getDeviceId());
        if (true) {
            pd.showDialog();
            iHomepageController.getGridViewData();
            if (listBranch.size() != 0) {
                initGridView();
            }
        } else {
            intent = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(intent);

        }
      discription.setOnClickListener(this);
    }

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
                Bundle b = new Bundle();
                // b.putString("branch_id", String.valueOf(listBranch.get(position).getId()));
                intent.putExtra("branch_id", String.valueOf(listBranch.get(position).getId()));
                startActivity(intent);

            }
        });
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
        if (expand)
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
        }
    }
}

