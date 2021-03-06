package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 29-Mar-17.
 */

public class Branch {

    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<BranchType> data=new ArrayList<BranchType>();

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<BranchType> getData() {
        return data;
    }
}
