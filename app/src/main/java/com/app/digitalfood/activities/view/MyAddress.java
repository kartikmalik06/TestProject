package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.AddressListAdapter;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;


import java.util.ArrayList;
import java.util.List;

public class MyAddress extends BaseActivity implements iMyAddress,View.OnClickListener {
    private ListView addressList;
    private AddressListAdapter mAddressAdapter;
    private static List<com.app.digitalfood.DataObject.Address> userAddresses = new ArrayList<com.app.digitalfood.DataObject.Address>();
    private Button addAddress;
    private Intent intent;
    private String clickedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        super.onCreateDrawer();

        addressList = (ListView) findViewById(R.id.address_list);
        addAddress = (Button) findViewById(R.id.add_address);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            com.app.digitalfood.DataObject.Address addressHolder = (com.app.digitalfood.DataObject.Address) b.getSerializable("MyAddress");
            clickedPosition = b.getString("position");
            if (addressHolder != null) {
                //need to call webservice for user address

                if (clickedPosition != null) {
                    userAddresses.remove(Integer.parseInt(clickedPosition));
                    userAddresses.add(Integer.parseInt(clickedPosition), addressHolder);
                } else {
                    userAddresses.add(addressHolder);
                }


            } else {

                if (clickedPosition != null) {
                    userAddresses.remove(Integer.parseInt(clickedPosition));
                }
            }
        }

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("MY ADDRESS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (!(userAddresses == null)) {
            mAddressAdapter = new AddressListAdapter(this, userAddresses);
            addressList.setAdapter(mAddressAdapter);
        }

        addAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(getApplicationContext(), AddAddress.class);
        startActivity(intent);
    }
}
