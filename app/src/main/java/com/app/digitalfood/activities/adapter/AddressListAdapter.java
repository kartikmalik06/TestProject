package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.AddAddress;
import com.app.digitalfood.activities.view.MyAddress;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;


import java.util.List;

/**
 * Created by beyond on 24-Feb-17.
 */

public class AddressListAdapter extends BaseAdapter implements View.OnClickListener {
    private List<Address> addresses;
    private Context context;
    private TextView userName, userAddress, userCity, userPhone;
    private ImageView options;
    iMyAddress myAddress;


    public AddressListAdapter(Context context, iMyAddress myAddress, List<Address> addresses) {
        this.context = context;
        this.addresses = addresses;
        this.myAddress=myAddress;
    }

    @Override
    public int getCount() {
        return addresses.size();
    }

    @Override
    public Address getItem(int position) {
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
        initViews(convertView);
        Address address = getItem(position);

        userName.setText(address.getName());
        userAddress.setText(address.getAddress1() + ", " + address.getAddress2());
        userCity.setText(address.getCity() + ", " + address.getState() + ", " + address.getCountry() + ", " + address.getPostcode());
        userPhone.setText(String.valueOf(address.getMobile()));

        options.setTag(position);
        options.setOnClickListener(this);
        return convertView;
    }


    @Override
    public void onClick(View v) {

        PopupMenu popupMenu = new PopupMenu(context, options);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.edit:
                        Intent intent = new Intent(context, AddAddress.class);
                        Address addressToEdit = getItem((Integer) options.getTag());
                        intent.putExtra("AddressToEdit", addressToEdit);
                        context.startActivity(intent);
                        break;
                    case R.id.delete:
                        myAddress.deleteAddress(getItem((Integer) options.getTag()).getId());
                        //server call to delete address with user and address id
                        break;
                }
                return true;
            }
        });
        popupMenu.show();

    }

    private void initViews(View convertView) {
        userName = (TextView) convertView.findViewById(R.id.name_text);
        userAddress = (TextView) convertView.findViewById(R.id.address_text);
        userCity = (TextView) convertView.findViewById(R.id.city_text);
        userPhone = (TextView) convertView.findViewById(R.id.phone_text);
        options = (ImageView) convertView.findViewById(R.id.options);
    }


}
