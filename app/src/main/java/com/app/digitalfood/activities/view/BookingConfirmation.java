package com.app.digitalfood.activities.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.digitalfood.DataObject.HashResponse;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.database.DatabaseHandler;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;
import com.payUMoney.sdk.PayUmoneySdkInitilizer;
import com.payUMoney.sdk.SdkConstants;
import com.paytm.pgsdk.Log;
import com.paytm.pgsdk.PaytmClientCertificate;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.payu.india.Model.PaymentParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Checksum;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class BookingConfirmation extends BaseActivity {

    boolean status;
    TextView wish, orderInfo, tryAgain;
    Intent intent;
    int amount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        super.onCreateDrawer();
        wish = (TextView) findViewById(R.id.wish);
        orderInfo = (TextView) findViewById(R.id.order_info);
        tryAgain = (TextView) findViewById(R.id.try_again);
        Bundle b = getIntent().getExtras();
        status = b.getBoolean("status");
        amount=b.getInt("amount");
        if (status) {
            db.removeItemByBranchId(branchID);
            setItemCount();
        } else {
            wish.setText("Sorry");
            orderInfo.setText(" Your order has not been placed");
            tryAgain.setClickable(true);
            tryAgain.setText("Try Again");
            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(getApplicationContext(), PayumoneyWebView.class);
                    intent.putExtra("amount",amount);
                    startActivity(intent);

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),HomePage.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
