package com.threededge.project1.userauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.threededge.project1.R;

import com.threededge.project1.component.CustomEditText;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private CustomEditText emailId;
    private Button submit;
    private Intent intent;
    private Toolbar toolBar;
    private TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        toolBar = (Toolbar) findViewById(R.id.tool_bar);
        toolBarTitle=(TextView) findViewById(R.id.title_name);
        emailId = (CustomEditText) findViewById(R.id.email_text);
        submit = (Button) findViewById(R.id.submit_btn);
        submit.setOnClickListener(this);
        setSupportActionBar(toolBar);
        toolBarTitle.setText("Forgot Password");
        //must call before setDisplayHomeAsUpEnabled function
        //  super.setActionBarTitle("SIGN IN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {

        if (emailId.isFieldEmpty()) {
            emailId.getText();

            //need to add webservice call

        /*intent = new Intent(getApplicationContext(), VerificationActivity.class);
        startActivity(intent);*/
        }
    }

}
