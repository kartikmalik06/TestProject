package com.app.digitalfood.activities.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.interfaces.iProfilePage;
import com.app.digitalfood.component.CustomEditText;


public class ProfilePage extends BaseActivity implements iProfilePage, View.OnClickListener {
    private TextView userName, userEmail, userPhone, userDOB;
    private CustomEditText nameText, emailText, phoneText, dobText;
    private ImageView editProfile;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        super.onCreateDrawer();

        userName = (TextView) findViewById(R.id.user_name);
        userEmail = (TextView) findViewById(R.id.user_email);
        userPhone = (TextView) findViewById(R.id.user_phone);
        userDOB = (TextView) findViewById(R.id.user_dob);

        editProfile = (ImageView) findViewById(R.id.edit_profile);

        nameText = (CustomEditText) findViewById(R.id.updated_name);
        emailText = (CustomEditText) findViewById(R.id.updated_email);
        phoneText = (CustomEditText) findViewById(R.id.updated_phone);
        dobText = (CustomEditText) findViewById(R.id.updated_dob);
        submit = (Button) findViewById(R.id.update_user_profile);

        //must call before setDisplayHomeAsUpEnabled function
        super.setActionBarTitle("MY PROFILE");

        //need to add controller to fecth data
        //ProfileController.getUserProfile();
        editProfile.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edit_profile:
                setTextInAllEditTexts();
                setEditTextVisibility(View.VISIBLE);
                setTextViewVisibility(View.GONE);
                setButtonVisibility(View.VISIBLE);
                editProfile.setVisibility(View.GONE);
                break;

            case R.id.update_user_profile:
                super.buttonAnimation(submit);
                //need to add serrver call using controller
                if (nameText.isFieldEmpty() && emailText.isFieldEmpty() && phoneText.isFieldEmpty() && dobText.isFieldEmpty()) {
                    setEditTextVisibility(View.GONE);
                    setTextViewVisibility(View.VISIBLE);
                    setButtonVisibility(View.GONE);
                    editProfile.setVisibility(View.VISIBLE);
                    setTextInAllTextViews();
                }
                break;
        }


    }
    private void setTextInAllTextViews() {
        userName.setText(nameText.getText().toString());
        userEmail.setText(emailText.getText().toString());
        userPhone.setText(phoneText.getText().toString());
        userDOB.setText(dobText.getText().toString());
    }

    private void setTextInAllEditTexts() {
        nameText.setText(userName.getText().toString());
        emailText.setText(userEmail.getText().toString());
        phoneText.setText(userPhone.getText().toString());
        dobText.setText(userDOB.getText().toString());
    }

    private void setButtonVisibility(int visible) {
        submit.setVisibility(visible);


    }

    private void setEditTextVisibility(int visible) {
        nameText.setVisibility(visible);
        emailText.setVisibility(visible);
        phoneText.setVisibility(visible);
        dobText.setVisibility(visible);
    }

    private void setTextViewVisibility(int visible) {
        userName.setVisibility(visible);
        userEmail.setVisibility(visible);
        userPhone.setVisibility(visible);
        userDOB.setVisibility(visible);
    }


}
