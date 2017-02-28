package com.threededge.project1.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by beyond on 24-Feb-17.
 */

public class CustomEditText extends EditText {
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isFieldEmpty()
    {
        if(TextUtils.isEmpty(getText()))
        {
            setError("feild required");
            return false;
        }
        return true;
    }
}
