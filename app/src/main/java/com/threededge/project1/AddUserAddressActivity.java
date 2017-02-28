package com.threededge.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.threededge.project1.DataObject.Address;
import com.threededge.project1.component.CustomEditText;

import java.io.Serializable;

public class AddUserAddressActivity extends AppCompatActivity implements View.OnClickListener {
    private CustomEditText userName, userAddress, userCity, userPhone, userPostalCode;
    private Toolbar toolbar;
    private Button submitButton;
    private TextView toolBarTitle;
    private Address addressholder;
    private Intent intent;

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

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarTitle.setText("Add Address");
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (userName.isFieldEmpty() && userAddress.isFieldEmpty() && userCity.isFieldEmpty() && userPhone.isFieldEmpty() && userPostalCode.isFieldEmpty()) {
            addressholder = new Address();
            addressholder.setUserName(userName.getText().toString());
            addressholder.setUserAddress(userAddress.getText().toString());
            addressholder.setUserCity(userCity.getText().toString());
            addressholder.setUserPhone(userPhone.getText().toString());
            addressholder.setUserPostalCode(userPostalCode.getText().toString());
            Bundle bundle = new Bundle();
            intent = new Intent(getApplicationContext(), MyAddressActivity.class);
            bundle.putSerializable("Address", addressholder);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
