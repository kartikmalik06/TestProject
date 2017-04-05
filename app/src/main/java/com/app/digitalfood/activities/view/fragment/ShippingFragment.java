package com.app.digitalfood.activities.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.Checkout;
import com.app.digitalfood.component.CustomEditText;


public class ShippingFragment extends Fragment implements View.OnClickListener {
    private CustomEditText name;
    private CustomEditText address;
    private CustomEditText city;
    private CustomEditText pincode;
    private CustomEditText phone;
    private CustomEditText country;
    private Button proceed;


    public ShippingFragment() {

        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shipping_detail, container, false);
        name = (CustomEditText) view.findViewById(R.id.name_text);
        address = (CustomEditText) view.findViewById(R.id.address_text);
        city = (CustomEditText) view.findViewById(R.id.city_text);
        pincode = (CustomEditText) view.findViewById(R.id.pincode_text);
        phone = (CustomEditText) view.findViewById(R.id.phone_text);
        country = (CustomEditText) view.findViewById(R.id.country_text);
        proceed = (Button) view.findViewById(R.id.btn_proceed);
        proceed.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_proceed:
                if (checkAllFields()) {
                    Address address=new Address();
                    address.setName(name.getText().toString());
                    address.setAddress1(this.address.getText().toString());
                    address.setCity(city.getText().toString());
                    address.setPostcode(pincode.getText().toString());
                    address.setCountry(country.getText().toString());
                    ((Checkout)getActivity()).changefragment(address);
                }
        }

    }

    private boolean checkAllFields() {
        if (name.isFieldEmpty() && address.isFieldEmpty()
                && city.isFieldEmpty() && phone.isFieldEmpty()
                && pincode.isFieldEmpty() && country.isFieldEmpty()) {
            return true;

        } else {

            return false;
        }
    }
}
