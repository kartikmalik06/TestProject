package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;



/**
 * Created by beyond on 05-May-17.
 */

public class HashResponse {

    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    HashData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public HashData getData() {
        return data;
    }
}
