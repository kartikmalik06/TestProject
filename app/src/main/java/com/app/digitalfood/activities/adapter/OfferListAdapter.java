package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.app.digitalfood.DataObject.OfferData;
import com.app.digitalfood.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by beyond on 30-Mar-17.
 */

public class OfferListAdapter extends BaseAdapter implements View.OnClickListener {

    private List<OfferData> offerdatas;
    private Context context;

    public OfferListAdapter(Context context, List<OfferData> offerDatas) {
        this.offerdatas = offerDatas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return offerdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return offerdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

       final ViewHolder viewHolder=new ViewHolder();
        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.offer, null);
        }
        viewHolder.offerImage = (ImageView) convertView.findViewById(R.id.offer_image);
         new Thread(new Runnable() {
            URL newurl = null;
            @Override
            public void run() {
                try
                {
                    final Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(offerdatas.get(position).getImageUrl()).getContent());
                    viewHolder.offerImage.post(new Runnable()
                    {
                        public void run()
                        {
                            if(bitmap !=null)
                            {
                                viewHolder.offerImage.setImageBitmap(bitmap);
                            }
                        }
                    });
                } catch (Exception e)
                {
                    // TODO: handle exception
                }
            }
        }).start();


        return convertView;
    }


    @Override
    public void onClick(View v) {

    }


    class ViewHolder
    {
        ImageView offerImage;
    }
}
