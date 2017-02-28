package com.threededge.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import DataObject.Address;
import component.AddressListAdapter;

public class MyAddressActivity extends BaseActivity {
    ListView addressList;
    AddressListAdapter mAddressAdapter;
    List<Address> userAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        super.onCreateDrawer();

        addressList = (ListView) findViewById(R.id.address_list);

        //need to call webservice for user address

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("MY ADDRESS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAddressAdapter = new AddressListAdapter(this, userAddresses);
        addressList.setAdapter(mAddressAdapter);
    }
}
