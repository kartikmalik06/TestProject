package component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.threededge.project1.R;

import java.util.List;

import DataObject.Address;

/**
 * Created by beyond on 24-Feb-17.
 */

public class AddressListAdapter extends BaseAdapter {
    List<Address> addresses;
    Context context;
    TextView userName,userAddress,userCity,userPhone,userPostalcode;
    public AddressListAdapter(Context context,List<Address> addresses) {
        this.context=context;
        this.addresses=addresses;

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
        userName=(TextView) convertView.findViewById(R.id.name_text);
        userAddress=(TextView) convertView.findViewById(R.id.address_text);
        userCity=(TextView) convertView.findViewById(R.id.city_text);
        userPhone=(TextView) convertView.findViewById(R.id.phone_text);
        userPostalcode=(TextView) convertView.findViewById(R.id.postal_code_text);
        userName.setText(addresses.get(position).getUserName());
        userAddress.setText(addresses.get(position).getUserAddress());
        userCity.setText(addresses.get(position).getUserCity());
        userPhone.setText(addresses.get(position).getUserPhone());
        userPostalcode.setText(addresses.get(position).getUserPostalCode());

        return null;
    }
}
