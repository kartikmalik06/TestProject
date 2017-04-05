package com.app.digitalfood.activities.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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

public class OfferListAdapter extends RecyclerView.Adapter<OfferListAdapter.MyViewHolder> implements View.OnClickListener {

    private List<OfferData> offerdatas;
    private Context context;

    public OfferListAdapter(Context context, List<OfferData> offerDatas) {
        this.offerdatas = offerDatas;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {

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
    }

    @Override
    public int getItemCount() {
        return offerdatas.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView offerImage;
        public MyViewHolder(View view) {
            super(view);

            offerImage = (ImageView) view.findViewById(R.id.offer_image);
        }


    }
}
