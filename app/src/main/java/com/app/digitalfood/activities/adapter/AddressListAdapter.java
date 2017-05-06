package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.AddAddress;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by beyond on 24-Feb-17.
 */

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.MyViewHolder> implements View.OnClickListener {
    private List<Address> addresses;
    private Context context;
    iMyAddress myAddress;

    public AddressListAdapter(Context context, iMyAddress myAddress, List<Address> addresses) {
        this.context = context;
        this.addresses = addresses;
        this.myAddress = myAddress;
    }

    @Override
    public AddressListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.address_list_item, parent, false);
        return new AddressListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddressListAdapter.MyViewHolder holder, int position) {
        Address address = getItem(position);
        holder.userName.setText(getValues(address.getName()));
        holder.userAddress.setText(getValues(address.getAddress1()) + getValues(address.getAddress2()));
        holder.userCity.setText(getValues(address.getCity()) + getValues(address.getState()) + getValues(address.getCountry()) + getValues(address.getPostcode()));
        holder.userPhone.setText(getValues(String.valueOf(address.getMobile())));
        holder.options.setTag(position);
        holder.options.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public Address getItem(int position) {
        return addresses.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName, userAddress, userCity, userPhone;
        public ImageView options;

        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.name_text);
            userAddress = (TextView) itemView.findViewById(R.id.address_text);
            userCity = (TextView) itemView.findViewById(R.id.city_text);
            userPhone = (TextView) itemView.findViewById(R.id.phone_text);
            options = (ImageView) itemView.findViewById(R.id.options);
        }
    }

    private String getValues(String name) {
        if (name != null) {
            return name.isEmpty() ? "" : name + " ";
        } else {
            return "";
        }

    }

    @Override
    public void onClick(final View v) {
        if (v.getId()==R.id.options) {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.edit:
                            Intent intent = new Intent(context, AddAddress.class);
                            Address addressToEdit = getItem((Integer) v.getTag());
                            intent.putExtra("AddressToEdit", addressToEdit);
                            context.startActivity(intent);
                            break;
                        case R.id.delete:
                            myAddress.deleteAddress(getItem((Integer) v.getTag()).getId());
                            //server call to delete address with user and address id
                            break;
                    }
                    return true;
                }
            });
            popupMenu.show();
        }
    }
}
