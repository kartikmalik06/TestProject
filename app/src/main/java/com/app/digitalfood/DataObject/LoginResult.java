package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by beyond on 03-Mar-17.
 */

public class LoginResult {



    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    LoginData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LoginData getData() {
        return data;
    }
}
