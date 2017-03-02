package com.app.digitalfood;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.digitalfood.component.CustomEditText;
import com.threededge.digitalfood.R;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    CustomEditText oldPassword, newPassword, confirmPassword;
    Button chnagePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        super.onCreateDrawer();
        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("CHANGE PASSWORD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        oldPassword = (CustomEditText) findViewById(R.id.old_password);
        newPassword = (CustomEditText) findViewById(R.id.new_password);
        confirmPassword = (CustomEditText) findViewById(R.id.confirm_password);
        chnagePassword = (Button) findViewById(R.id.change_password);
        chnagePassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.buttonAnimation(chnagePassword);
        if (oldPassword.isFieldEmpty() && newPassword.isFieldEmpty() && confirmPassword.isFieldEmpty()) {
            if (newPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                //need to add server call
                Toast.makeText(this, "PASSWORD CHANGED", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "NEW PASSWORD DOES NOT MATCH.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
