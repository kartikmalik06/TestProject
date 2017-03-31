package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 30-Mar-17.
 */

public class Toppings
{
    @SerializedName("name")
    String name;
    @SerializedName("status")
    int status;
    @SerializedName("id")
    int id;
    @SerializedName("price")
    int price;

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
