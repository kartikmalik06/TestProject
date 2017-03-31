package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 06-Mar-17.
 */

public class CategoryResult {
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<CategoryData> data=new ArrayList<CategoryData>();

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<CategoryData> getData() {
        return data;
    }
}
