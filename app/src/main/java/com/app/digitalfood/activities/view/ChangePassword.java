package com.app.digitalfood.activities.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iChangePassword;
import com.app.digitalfood.component.CustomEditText;


public class ChangePassword extends BaseActivity implements iChangePassword, View.OnClickListener {
    CustomEditText oldPassword, newPassword, confirmPassword;
    Button chnagePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        super.onCreateDrawer();
        super.setActionBarTitle("CHANGE PASSWORD");
        oldPassword = (CustomEditText) findViewById(R.id.old_password);
        newPassword = (CustomEditText) findViewById(R.id.new_password);
        confirmPassword = (CustomEditText) findViewById(R.id.confirm_password);
        chnagePassword = (Button) findViewById(R.id.change_password);
        chnagePassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.change_password) {
            super.buttonAnimation(chnagePassword);
            if (oldPassword.isFieldEmpty() && newPassword.isFieldEmpty() && confirmPassword.isFieldEmpty()) {
                if (newPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                    //need to add server call
                    Toast.makeText(this, "PASSWORD CHANGED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "NEW PASSWORD DOES NOT MATCH.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
