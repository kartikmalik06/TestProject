package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 05-Apr-17.
 */
public class DefautResponce {

    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
