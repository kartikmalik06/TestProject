package com.app.digitalfood.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by beyond on 05-Jun-17.
 */

public class OpenSansBoldTextView extends TextView{
    public OpenSansBoldTextView(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "OpenSans-Bold.ttf");
        this.setTypeface(face);
    }

    public OpenSansBoldTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "OpenSans-Bold.ttf");
        this.setTypeface(face);
    }

    public OpenSansBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "OpenSans-Bold.ttf");
        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);

    }

}
