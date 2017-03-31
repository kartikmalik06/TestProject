package com.app.digitalfood.activities.adapter;

/**
 * Created by beyond on 28-Mar-17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.BranchType;
import com.app.digitalfood.R;

import java.util.ArrayList;
import java.util.List;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private List<BranchType> web=new ArrayList<BranchType>();


    public CustomGrid(Context c, List<BranchType> web ) {
        mContext = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        Holder holder=new Holder();
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_item, null);
            holder.title = (TextView) grid.findViewById(R.id.grid_text);
            holder.img = (ImageView)grid.findViewById(R.id.grid_image);
            holder.title.setText(web.get(position).getName());
            holder.img.setImageResource(R.mipmap.ic_launcher);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

    public class Holder
    {
        ImageView img;
        TextView title;
    }
}