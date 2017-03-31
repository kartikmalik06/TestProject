package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 29-Mar-17.
 */

public class SignupResult {

    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    SignUpData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public SignUpData getData() {
        return data;
    }
}
