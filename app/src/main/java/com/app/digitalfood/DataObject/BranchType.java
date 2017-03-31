package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 02-Mar-17.
 */

public class BranchType {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("status")
    int status;


    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {

        return id;
    }
}
