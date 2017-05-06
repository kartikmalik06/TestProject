package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.adapter.SelectedItemListAdapter;
import com.app.digitalfood.component.CustomEditText;

import java.util.ArrayList;
import java.util.List;

public class DemoCheckOut extends BaseActivity {
    List<ItemData> orderedItem = new ArrayList<>();
    TextView name, address, city_pincode, subTotal,tax, discount, total;
    LinearLayout deliveryOption,pickupOption;
    private static final int PICKUP=100;
    private static final int DELIVERY=200;
    CustomEditText voucherCode;
    Button makePayment;
    RadioButton pickUp, delivery;
    private RecyclerView recyclerView;
    Address shippingAddress;
    int subTotalAmount = 0;
    int discountAmount = 0;
    Intent intent;
    int orderOption;
    int netAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        super.onCreateDrawer();
        super.setItemCount();
        orderedItem = super.db.getAllItem(getBranchID());
        // voucherCode.setOnEditorActionListener(this);
       /* pickUp = (RadioButton) findViewById(R.id.pick_up);
        delivery = (RadioButton) findViewById(R.id.delivery);*/
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        makePayment = (Button) findViewById(R.id.button_continue);
        //deliveryOption=(LinearLayout) findViewById(R.id.delivery_option);
        //pickupOption=(LinearLayout) findViewById(R.id.pickup_optiopn);
        total = (TextView) findViewById(R.id.total);
        tax = (TextView) findViewById(R.id.tax);
        subTotal = (TextView) findViewById(R.id.subtotal);
        super.setActionBarTitle("Cart");

        SelectedItemListAdapter selectedItemListAdapter = new SelectedItemListAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        ViewCompat.setNestedScrollingEnabled(recyclerView,false);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(selectedItemListAdapter);
        makePayment.setOnClickListener(this);
       // deliveryOption.setOnClickListener(this);
        //pickupOption.setOnClickListener(this);
        //pickUp.setClickable(false);
        //delivery.setClickable(false);
        makeInvoice();
        netPay();

    }

    public void makeInvoice() {
        orderedItem=db.getAllItem(getBranchID());
        subTotalAmount = 0;
        for (ItemData itemData : orderedItem) {

            subTotalAmount = subTotalAmount + itemData.getQuantity() * itemData.getPrice();

        }
        subTotal.setText("Rs. "+String.valueOf(subTotalAmount));
        netPay();
    }

    private void netPay() {

        if (subTotalAmount > 0)
            netAmount = subTotalAmount - discountAmount;

        total.setText("Rs. "+String.valueOf(netAmount));
        pd.hideDialog();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
          /*  case R.id.pickup_optiopn:
                pickUp.setChecked(true);
                delivery.setChecked(false);
                orderOption = PICKUP;
                break;
            case R.id.delivery_option:
                delivery.setChecked(true);
                pickUp.setChecked(false);
                orderOption = DELIVERY;
                break;*/
            case R.id.button_continue:
                /*if (delivery.isChecked() || pickUp.isChecked()) {
                    if (delivery.isChecked()) {
                        intent = new Intent(getApplicationContext(), PlaceOrder.class);
                        intent.putExtra("order type",orderOption);
                        startActivity(intent);
                    } else {
                        intent = new Intent(getApplicationContext(), PlaceOrder.class);
                        intent.putExtra("order type",orderOption);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please select service option.", Toast.LENGTH_SHORT).show();
                }*/
                Intent intent=new Intent(getApplicationContext(),PlaceOrder.class);
                intent.putExtra("amount",netAmount);
                startActivity(intent);
                break;
        }
    }


}
