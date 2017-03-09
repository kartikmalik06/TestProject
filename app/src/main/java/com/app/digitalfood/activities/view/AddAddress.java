package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.interfaces.iAddAddress;
import com.app.digitalfood.component.CustomEditText;


public class AddAddress extends AppCompatActivity implements iAddAddress,View.OnClickListener {
    private CustomEditText userName, userAddress, userCity, userPhone, userPostalCode;
    private Toolbar toolbar;
    private Button submitButton;
    private TextView toolBarTitle;
    private com.app.digitalfood.DataObject.Address addressholder;
    private Intent intent;
    private int clickedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_address);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolBarTitle = (TextView) findViewById(R.id.title_name);
        userName = (CustomEditText) findViewById(R.id.name_text);
        userAddress = (CustomEditText) findViewById(R.id.address_text);
        userCity = (CustomEditText) findViewById(R.id.city_text);
        userPhone = (CustomEditText) findViewById(R.id.phone_text);
        userPostalCode = (CustomEditText) findViewById(R.id.postal_code_text);
        submitButton = (Button) findViewById(R.id.submit_address);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            addressholder = (com.app.digitalfood.DataObject.Address) bundle.getSerializable("AddresstoEdit");
            clickedPosition = bundle.getInt("position");

            setPreviousDetailstoEdit(addressholder);
        }


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarTitle.setText("Add MyAddress");
        submitButton.setOnClickListener(this);

    }

    public void setPreviousDetailstoEdit(com.app.digitalfood.DataObject.Address addressholder) {

        userName.setText(addressholder.getUserName().toString());
        userAddress.setText(addressholder.getUserAddress().toString());
       //userCity.setText(addressholder.getUserCity().toString());
        userPhone.setText(addressholder.getUserPhone().toString());
        userPostalCode.setText(addressholder.getUserPostalCode().toString());
    }

    @Override
    public void onClick(View v) {

        if (userName.isFieldEmpty() && userAddress.isFieldEmpty() && userCity.isFieldEmpty() && userPhone.isFieldEmpty() && userPostalCode.isFieldEmpty()) {
            addressholder = new com.app.digitalfood.DataObject.Address();
            addressholder.setUserName(userName.getText().toString());
            addressholder.setUserAddress(userAddress.getText().toString());
           // addressholder.setUserCity(userCity.getText().toString());
            addressholder.setUserPhone(userPhone.getText().toString());
            addressholder.setUserPostalCode(userPostalCode.getText().toString());
            Bundle bundle = new Bundle();
            intent = new Intent(getApplicationContext(), MyAddress.class);
            bundle.putSerializable("MyAddress", addressholder);
            if (clickedPosition != -1) {
                bundle.putString("position", String.valueOf(clickedPosition));
            }

            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
