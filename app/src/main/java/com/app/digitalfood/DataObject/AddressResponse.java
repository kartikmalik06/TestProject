package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beyond on 05-Apr-17.
 */

public class AddressResponse {
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Address> data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Address> getData() {
        return data;
    }


}
