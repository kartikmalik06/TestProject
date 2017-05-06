package com.app.digitalfood.DataObject;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by beyond on 29-Mar-17.
 */

public class ItemData implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("company_id")
    int company_id;
    @SerializedName("category_id")
    int category_id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("allergy_info")
    String allergyInfo;
    @SerializedName("price")
    int price;
    @SerializedName("is_attribute")
    int isAttribute;
    @SerializedName("apply_image")
    int applyImage;
    @SerializedName("image")
    String image;
    @SerializedName("status")
    String status;
    @SerializedName("ip_address")
    int ipAddress;
    @SerializedName("imageUrl")
    String imageUrl;
    @SerializedName("attributes")
    String attributes;
    @SerializedName("toppings")
    String toppings;

    int quantity=1;

    boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return description;
    }

    public String getAllergyInfo() {
        return allergyInfo;
    }

    public int getPrice() {
        return price;
    }

    public int getIsAttribute() {
        return isAttribute;
    }

    public int getApplyImage() {
        return applyImage;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getToppings() {
        return toppings;
    }
}
