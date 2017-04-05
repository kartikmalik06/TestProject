package com.app.digitalfood.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by beyond on 24-Feb-17.
 */

public class CustomEditText extends EditText {
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Context context;
    public CustomEditText(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.context=context;
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

    public boolean isVaildEmail()
    {
        if (getText().toString().matches(emailPattern))
        {
            return true;
        }
        else {
            setError("Not vaild Email address");
            return false;
        }
    }

    public void showKeyBoard()
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT);
    }
}
