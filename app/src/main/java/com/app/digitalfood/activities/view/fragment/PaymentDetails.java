package com.app.digitalfood.activities.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.Checkout;
import com.app.digitalfood.component.CustomEditText;

import java.util.List;


public class PaymentDetails extends Fragment implements TextView.OnEditorActionListener {

    List<ItemData> orderedItem;
    TextView name, address, city_pincode, subTotal, discount, total;
    CustomEditText voucherCode;
    Button makePayment;
    private RecyclerView recyclerView;
    Address shippingAddress;
    int subTotalAmount = 0;
    int discountAmount = 0;

    public PaymentDetails() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public PaymentDetails(List<ItemData> orderedItem) {
        this.orderedItem = orderedItem;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Checkout)getActivity()).pd.showDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment, container, false);
        initViews(view);
        if (shippingAddress != null) {
            displayAddress();
        }
        voucherCode.setOnEditorActionListener(this);
        //SelectedItemListAdapter selectedItemListAdapter = new SelectedItemListAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setAdapter(selectedItemListAdapter);
        makeInvoice();
        netPay();
        return view;
    }

    private void makeInvoice() {

        for (ItemData subCategoryData : orderedItem) {
            if (subCategoryData.isChecked()) {
                subTotalAmount = subTotalAmount + subCategoryData.getQuantity() * 150;
            }
        }
        subTotal.setText(String.valueOf(subTotalAmount));
    }

    private void netPay() {
        int netAmount = 0;
        if (subTotalAmount > 0)
            netAmount = subTotalAmount - discountAmount;

        total.setText(String.valueOf(netAmount));
        ((Checkout)getActivity()).pd.hideDialog();
    }

    private void displayAddress() {
        name.setText(shippingAddress.getName());
        address.setText(shippingAddress.getAddress1()+", "+shippingAddress.getAddress2());
        city_pincode.setText(shippingAddress.getCity() + ", " +shippingAddress.getState()+", "
                +shippingAddress.getCountry()+","+ shippingAddress.getPostcode());
    }

    private void initViews(View view) {
        name = (TextView) view.findViewById(R.id.user_name);
        address = (TextView) view.findViewById(R.id.address);
        city_pincode = (TextView) view.findViewById(R.id.city);
        subTotal = (TextView) view.findViewById(R.id.sub_total);
        discount = (TextView) view.findViewById(R.id.discount);
        total = (TextView) view.findViewById(R.id.total);
        voucherCode = (CustomEditText) view.findViewById(R.id.voucher_code);
        makePayment = (Button) view.findViewById(R.id.make_payment);
        recyclerView = (RecyclerView) view.findViewById(R.id.product_list);
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        displayAddress();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        ((Checkout)getActivity()).pd.showDialog();
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // server call to get voucher amount to discount
            //set Discount amount here
            netPay();
            handled = true;
        }
        return handled;
    }
}
