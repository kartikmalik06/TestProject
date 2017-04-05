package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.AddressListAdapter;
import com.app.digitalfood.activities.controllers.AddressController;
import com.app.digitalfood.activities.controllers.iAddressController;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;


import java.util.ArrayList;
import java.util.List;

public class MyAddress extends BaseActivity implements iMyAddress, View.OnClickListener {
    private ListView addressList;
    private AddressListAdapter mAddressAdapter;
    private Button addAddress;
    private Intent intent;
    private iAddressController addressController;
    int id=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        super.onCreateDrawer();

        addressList = (ListView) findViewById(R.id.address_list);
        addAddress = (Button) findViewById(R.id.add_address);
        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("MY ADDRESS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addressController = new AddressController(this);
      //  addressController.getAddressList(id);
      // pd.showDialog();
        addAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(getApplicationContext(), AddAddress.class);
        startActivity(intent);
    }


    @Override
    public void showAddressList(List<Address> addresses) {

        if (!(addressList == null)) {
            mAddressAdapter = new AddressListAdapter(this,this, addresses);
            addressList.setAdapter(mAddressAdapter);
            pd.hideDialog();
        }
    }

    @Override
    public void deleteAddress(int id) {
        pd.showDialog();
        addressController.deleteAddress(id);
    }

    @Override
    public void restartActivity() {
        pd.hideDialog();
        Toast.makeText(this, "Address Removed.", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),MyAddress.class);
        startActivity(intent);
    }

    @Override
    public void showErrorToast(String s) {
        pd.hideDialog();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
