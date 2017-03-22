package com.app.digitalfood.activities.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.digitalfood.R;
import com.app.digitalfood.component.CustomEditText;


public class ShippingActivity extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CustomEditText name;
    private CustomEditText address;
    private CustomEditText city;
    private CustomEditText pincode;
    private CustomEditText phone;
    private CustomEditText country;
    private Button proceed;


    public ShippingActivity() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ShippingActivity newInstance(String param1, String param2) {
        ShippingActivity fragment = new ShippingActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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
        proceed=(Button) view.findViewById(R.id.btn_proceed);

        proceed.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
