package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;

import java.util.List;

/**
 * Created by beyond on 13-Apr-17.
 */

public class UsedAddressAdapter extends RecyclerView.Adapter<UsedAddressAdapter.MyViewHolder> {
    private List<Address> addresses;
    private Context context;
    boolean selected;
    int checkedPosition=-1;

    public UsedAddressAdapter(Context context, List<Address> addresses) {
        this.context = context;
        this.addresses = addresses;

    }

    @Override
    public UsedAddressAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.used_address_list_item, parent, false);
        return new UsedAddressAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final UsedAddressAdapter.MyViewHolder holder, final int position) {
        Address address = getItem(position);

        holder.userAddress.setText(getValues(address.getAddress1()) + getValues(address.getAddress2()));
        /*holder.userCity.setText(getValues(address.getCity()) + getValues(address.getState()) + getValues(address.getCountry()) + getValues(address.getPostcode()));
        holder.userPhone.setText(getValues(String.valueOf(address.getMobile())));
        holder.userName.setText(getValues(address.getName()));*/
        holder.options.setImageResource(position == checkedPosition ? R.drawable.checked : R.drawable.circumference);
        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedPosition = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public Address getItem(int position) {
        return addresses.get(position);
    }

    private String getValues(String name) {
        if (name != null) {
            return name.isEmpty() ? "" : name + " ";
        } else {
            return "";
        }

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView /*userName,*/ userAddress/*, userCity, userPhone*/;
        public ImageView options;
        public LinearLayout address;

        public MyViewHolder(View itemView) {
            super(itemView);
            userAddress = (TextView) itemView.findViewById(R.id.address_text);
           /* userName = (TextView) itemView.findViewById(R.id.name_text);
            userCity = (TextView) itemView.findViewById(R.id.city_text);
            userPhone = (TextView) itemView.findViewById(R.id.phone_text);*/
            options = (ImageView) itemView.findViewById(R.id.selectedaddress);
            address = (LinearLayout) itemView.findViewById(R.id.address);
        }
    }
}