package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.digitalfood.DataObject.Restaurent;
import com.app.digitalfood.R;


import java.util.List;

/**
 * Created by beyond on 02-Mar-17.
 */

public class RestaurentListAdapter extends BaseAdapter {
    private List<Restaurent> restaurents;
    private Context context;
    private TextView restaurentName,type;
   // private ImageView restaurentImage;

    public RestaurentListAdapter(Context context, List<Restaurent> restaurents) {
        this.context = context;
        this.restaurents = restaurents;

    }

    @Override
    public int getCount() {
        return restaurents.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView!=null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.restaurent_list_item,null);
        }
        restaurentName=(TextView) convertView.findViewById(R.id.restaurent_name);
        type=(TextView) convertView.findViewById(R.id.restaurent_type);
        //restaurentImage=(ImageView) convertView.findViewById(R.id.restaurent_image);
        restaurentName.setText(restaurents.get(position).getRestaurentName());
        type.setText(restaurents.get(position).getRestaurentType());
        //restaurentImage.setImage(restaurents.get(position).getRestaurentImage());
        return convertView;
    }
}
