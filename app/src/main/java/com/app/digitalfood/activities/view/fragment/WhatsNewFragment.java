package com.app.digitalfood.activities.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.digitalfood.R;
import com.app.digitalfood.component.OpenSansRegularTextView;

/**
 * Created by beyond on 01-Jun-17.
 */
@SuppressLint("ValidFragment")
public class WhatsNewFragment extends Fragment {
    int imgRe;

    public WhatsNewFragment(int imgRe) {
        this.imgRe=imgRe;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.whats_new_layout,container,false);
        ImageView img= (ImageView) view.findViewById(R.id.image);
        //OpenSansRegularTextView title=(OpenSansRegularTextView) view.findViewById(R.id.title);
        img.setImageResource(imgRe);
        return view;
    }
}
