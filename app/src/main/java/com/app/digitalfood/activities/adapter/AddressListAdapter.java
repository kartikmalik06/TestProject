package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.AddAddress;
import com.app.digitalfood.activities.view.MyAddress;


import java.util.List;

/**
 * Created by beyond on 24-Feb-17.
 */

public class AddressListAdapter extends BaseAdapter implements View.OnClickListener {
    List<com.app.digitalfood.DataObject.Address> addresses;
    Context context;
    TextView userName, userAddress, userCity, userPhone, userPostalcode;
    ImageView editaddress, deleteaddress;
    Intent intent;
    int currentPosition;
    Bundle bundle;

    public AddressListAdapter(Context context, List<com.app.digitalfood.DataObject.Address> addresses) {
        this.context = context;
        this.addresses = addresses;
    }

    @Override
    public int getCount() {
        return addresses.size();

    }

    @Override
    public Object getItem(int position) {
        return addresses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.address_list_item, null);
        }
        userName = (TextView) convertView.findViewById(R.id.name_text);
        userAddress = (TextView) convertView.findViewById(R.id.address_text);
        userCity = (TextView) convertView.findViewById(R.id.city_text);
        userPhone = (TextView) convertView.findViewById(R.id.phone_text);
        userPostalcode = (TextView) convertView.findViewById(R.id.postal_code_text);

        editaddress = (ImageView) convertView.findViewById(R.id.edit_address);
        deleteaddress = (ImageView) convertView.findViewById(R.id.delete_address);

        userName.setText(addresses.get(position).getUserName());
        userAddress.setText(addresses.get(position).getUserAddress());
        //userCity.setText(addresses.get(position).getUserCity());
        userPhone.setText(addresses.get(position).getUserPhone());
        userPostalcode.setText(addresses.get(position).getUserPostalCode());

        editaddress.setTag(position);
        editaddress.setOnClickListener(this);
        deleteaddress.setTag(position);
        deleteaddress.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.edit_address:
                currentPosition = (int) v.getTag();
                intent = new Intent(context, AddAddress.class);
                bundle = new Bundle();
                bundle.putSerializable("AddresstoEdit", addresses.get(currentPosition));
                bundle.putInt("position", currentPosition);
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;

            case R.id.delete_address:
                currentPosition = (int) v.getTag();
                intent = new Intent(context, MyAddress.class);
                bundle = new Bundle();
                bundle.putString("position", String.valueOf(currentPosition));
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;

        }
    }


}
