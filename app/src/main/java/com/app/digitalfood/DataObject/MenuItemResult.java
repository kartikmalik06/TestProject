package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 30-Mar-17.
 */

public class MenuItemResult {
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
   List<MenuItemData> data=new ArrayList<MenuItemData>();

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<MenuItemData> getData() {
        return data;
    }
}
