package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.controllers.AddAddressController;
import com.app.digitalfood.activities.controllers.iAddAddressController;
import com.app.digitalfood.activities.view.interfaces.iAddAddress;
import com.app.digitalfood.component.CustomEditText;


public class AddAddress extends BaseActivity implements iAddAddress, View.OnClickListener {
    private CustomEditText userName, userAddress, userCity, userPhone, userPostalCode, userCountry;
    private Button submitButton;
    private Intent intent;
    private iAddAddressController addAddressController;
    int id = 10;
    int userID = 43;
    boolean isEditable = false;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_address);
        onCreateDrawer();
        initViews();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            i = bundle.getInt("placeorder", 0);
            if (i != 101) {
                isEditable = true;
                Address address = (Address) bundle.getSerializable("AddressToEdit");
                setPreviousDetailstoEdit(address);
            }
        }
        addAddressController = new AddAddressController(this);
        super.setActionBarTitle("Address");
        submitButton.setOnClickListener(this);
    }

    public void setPreviousDetailstoEdit(Address addressholder) {

        userName.setText(addressholder.getName());
        userAddress.setText(addressholder.getAddress1());
        userCity.setText(addressholder.getCity());
        userPhone.setText(addressholder.getMobile());
        userPostalCode.setText(addressholder.getPostcode());
        userCountry.setText(addressholder.getCountry());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_proceed: {

                if (!isEditable) {
                    Log.d("add address", "clicked");
                    if (userName.isFieldEmpty() && userAddress.isFieldEmpty() && userCity.isFieldEmpty() && userPhone.isFieldEmpty() && userPostalCode.isFieldEmpty()) {
                        pd.showDialog();
                        addAddressController.addAddress(userID, userName.getText().toString(), userAddress.getText().toString(), userPhone.getText().toString());
                    }
                } else {
                    Log.d("update address", "clicked");
                    isEditable = false;
                    if (userName.isFieldEmpty() && userAddress.isFieldEmpty() && userCity.isFieldEmpty() && userPhone.isFieldEmpty() && userPostalCode.isFieldEmpty()) {
                        pd.showDialog();
                        addAddressController.updateAddress(id, userID, userName.getText().toString(), userAddress.getText().toString(), userPhone.getText().toString());
                        if (i==101)
                        {
                            Intent intent=new Intent();
                            intent.putExtra("name",userName.getText().toString());
                            intent.putExtra("address",userAddress.getText().toString());
                            intent.putExtra("city",userCity.getText().toString());
                            intent.putExtra("phone",userPhone.getText().toString());
                            intent.putExtra("postcode",userPostalCode.getText().toString());
                            setResult(2,intent);
                            finish();
                        }
                    }
                }
                break;
            }
        }
    }

    private void initViews() {
        userName = (CustomEditText) findViewById(R.id.name_text);
        userAddress = (CustomEditText) findViewById(R.id.address_text);
        userCity = (CustomEditText) findViewById(R.id.city_text);
        userPhone = (CustomEditText) findViewById(R.id.phone_text);
        userPostalCode = (CustomEditText) findViewById(R.id.pincode_text);
        userCountry = (CustomEditText) findViewById(R.id.country_text);
        submitButton = (Button) findViewById(R.id.btn_proceed);
    }

    public void onAddressadded(String message) {
        pd.hideDialog();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(), MyAddress.class);
        startActivity(intent);
    }
}
