package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.UsedAddressAdapter;
import com.app.digitalfood.activities.controllers.PlaceOrderController;

import java.util.List;

public class PlaceOrder extends BaseActivity {
    LinearLayout addressLayout, chnageAddressLayout, pickUp, delivery, dinning, cashPay, onlinePay;
    TextView userName1, email, mobileNumber1, userName2, userAddress, userCity, mobileNumber2, newAddress, savedAddress, btnChangeAddress;

    ImageView pickupImage, dinningImage, deliveryImage, codImage, onlineImage;
    Button placeOrder;
    RecyclerView addressListView;
    private int DELIVERY_STATE;
    private int PAYMENT_TYPE;
    private static final int UNSELECTED = 0;
    private static final int COD = 100;
    private static final int ONLINE = 200;
    private static final int PICKUP = 101;
    private static final int DELIVERY = 102;
    private static final int DINNING = 103;
    Intent intent;
    UsedAddressAdapter mAddressAdapter;
    PlaceOrderController placeOrderController;
    int amount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_pickup);
        super.onCreateDrawer();
        super.setItemCount();
        pd.showDialog();
        pickUp = (LinearLayout) findViewById(R.id.pick_up);
        delivery = (LinearLayout) findViewById(R.id.delivery);
        dinning = (LinearLayout) findViewById(R.id.dinning);
        cashPay = (LinearLayout) findViewById(R.id.cod);
        onlinePay = (LinearLayout) findViewById(R.id.online);
        addressLayout = (LinearLayout) findViewById(R.id.address_layout);
        chnageAddressLayout = (LinearLayout) findViewById(R.id.change_address_layout);

        pickupImage = (ImageView) findViewById(R.id.pick_up_image);
        dinningImage = (ImageView) findViewById(R.id.dinning_image);
        deliveryImage = (ImageView) findViewById(R.id.delivery_image);
        codImage = (ImageView) findViewById(R.id.codImage);
        onlineImage = (ImageView) findViewById(R.id.onlineImage);

        userName2 = (TextView) findViewById(R.id.name_text);
        userAddress = (TextView) findViewById(R.id.address_text);
        userCity = (TextView) findViewById(R.id.city_text);
        mobileNumber2 = (TextView) findViewById(R.id.phone_text);

        btnChangeAddress = (TextView) findViewById(R.id.change_address);

        newAddress = (TextView) findViewById(R.id.new_address);
        savedAddress = (TextView) findViewById(R.id.saved_address);

        addressListView = (RecyclerView) findViewById(R.id.list_address);

        placeOrder = (Button) findViewById(R.id.place_order);

        /*userName1 = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        mobileNumber1 = (TextView) findViewById(R.id.mobile);*/
        Bundle b = getIntent().getExtras();
        amount = b.getInt("amount");

        placeOrderController = new PlaceOrderController(this);
        super.setActionBarTitle("Place Order");
        /*Bundle b = getIntent().getExtras();
        if (b != null) {
            int orderType = b.getInt("order type");
            if (orderType == DELIVERY) {
                addressLayout.setVisibility(View.VISIBLE);
                placeOrderController.getAddressList(43);
            }

        }*/

        placeOrderController.getAddressList(43);
        pickUp.setOnClickListener(this);
        delivery.setOnClickListener(this);
        dinning.setOnClickListener(this);
        cashPay.setOnClickListener(this);
        onlinePay.setOnClickListener(this);

        btnChangeAddress.setOnClickListener(this);

        newAddress.setOnClickListener(this);
        savedAddress.setOnClickListener(this);

        //payNow.setOnClickListener(this);
        //cod.setOnClickListener(this);
        placeOrder.setOnClickListener(this);
    }

    private void setAddress(Address address) {
        userName2.setText(getValues(address.getName()));
        userAddress.setText(getValues(address.getAddress1()) + getValues(address.getAddress2()));
        userCity.setText(getValues(address.getCity()) + getValues(address.getState()) +
                getValues(address.getCountry()) + getValues(address.getPostcode()));
        mobileNumber2.setText(getValues(String.valueOf(address.getMobile())));
        pd.hideDialog();
    }

    private String getValues(String name) {
        if (name != null) {
            return name.isEmpty() ? "" : name + " ";
        } else {
            return "";
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            addressLayout.setVisibility(View.VISIBLE);
            chnageAddressLayout.setVisibility(View.GONE);
            Address address = new Address();
            address.setName(data.getStringExtra("name"));
            address.setAddress1(data.getStringExtra("address"));
            address.setCity(data.getStringExtra("city"));
            address.setMobile(data.getStringExtra("phone"));
            setAddress(address);
        }
    }

    private void changeselection(ImageView imageView, boolean isSelect) {
        imageView.setImageResource(isSelect ? R.drawable.checked : R.drawable.circumference);
    }



    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.pick_up:
                changeselection(pickupImage, true);
                changeselection(dinningImage, false);
                changeselection(deliveryImage, false);
                addressLayout.setVisibility(View.GONE);
                DELIVERY_STATE = PICKUP;
                addressListView.setVisibility(View.GONE);
                chnageAddressLayout.setVisibility(View.GONE);
                break;

            case R.id.delivery:
                changeselection(pickupImage, false);
                changeselection(dinningImage, false);
                changeselection(deliveryImage, true);
                DELIVERY_STATE = DELIVERY;
                addressLayout.setVisibility(View.VISIBLE);

                break;

            case R.id.dinning:
                changeselection(pickupImage, false);
                changeselection(dinningImage, true);
                changeselection(deliveryImage, false);
                addressLayout.setVisibility(View.GONE);
                DELIVERY_STATE = DINNING;
                addressListView.setVisibility(View.GONE);
                chnageAddressLayout.setVisibility(View.GONE);
                break;

            case R.id.cod:
                changeselection(codImage, true);
                changeselection(onlineImage, false);
                PAYMENT_TYPE = COD;
                break;

            case R.id.online:
                changeselection(codImage, false);
                changeselection(onlineImage, true);
                PAYMENT_TYPE = ONLINE;
                break;

            case R.id.change_address:
                addressLayout.setVisibility(View.GONE);
                chnageAddressLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.saved_address:
                addressListView.setVisibility(View.VISIBLE);
                break;

            case R.id.new_address:
                intent = new Intent(this, AddAddress.class);
                startActivityForResult(intent, 2);
                break;

            case R.id.place_order:
               /* if (cod.isChecked() || payNow.isChecked()) {
                    if (payNow.isChecked()) {
                        Toast.makeText(this, "Order placed as online pay", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Order placed as COD.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please select service option.", Toast.LENGTH_SHORT).show();
                }*/
                placeOrder();
                break;
        }
    }

    private void placeOrder() {
        switch (DELIVERY_STATE) {
            case PICKUP:
                //db.removeItemByBranchId(branchID);
                //setItemCount();
                checkPaymentOption();
                break;
            case DELIVERY:
                // db.removeItemByBranchId(branchID);
                //setItemCount();
                checkPaymentOption();
                break;
            case DINNING:

                // db.removeItemByBranchId(branchID);
                //setItemCount();
                checkPaymentOption();
                break;
            case UNSELECTED:
                Toast.makeText(this, "Choose service option", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkPaymentOption() {
        switch (PAYMENT_TYPE) {
            case COD:
                intent = new Intent(getApplicationContext(), BookingConfirmation.class);
                intent.putExtra("status", true);
                intent.putExtra("amount",amount);
                startActivity(intent);
                // Toast.makeText(this, "Order Booked \n Service = " + DELIVERY_STATE + "\nPayment type = " + PAYMENT_TYPE, Toast.LENGTH_SHORT).show();
                break;
            case ONLINE:
                intent = new Intent(getApplicationContext(), PayumoneyWebView.class);
                intent.putExtra("amount",amount);
                startActivity(intent);
                //Toast.makeText(this, "Order Booked \n Service = " + DELIVERY_STATE + "\nPayment type = " + PAYMENT_TYPE, Toast.LENGTH_SHORT).show();
                break;
            case UNSELECTED:
                Toast.makeText(this, "Choose payment option", Toast.LENGTH_SHORT).show();

        }
    }

    public void setAddressListView(List<Address> data) {
        mAddressAdapter = new UsedAddressAdapter(this, data);
        setAddress(data.get(0));
        ViewCompat.setNestedScrollingEnabled(addressListView, false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        addressListView.setLayoutManager(mLayoutManager);
        addressListView.setItemAnimator(new DefaultItemAnimator());
        addressListView.setAdapter(mAddressAdapter);
    }

    public void showErrorToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
