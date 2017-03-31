package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 30-Mar-17.
 */
public class OfferResult {
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<OfferData> data=new ArrayList<OfferData>();

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<OfferData> getData() {
        return data;
    }
}
