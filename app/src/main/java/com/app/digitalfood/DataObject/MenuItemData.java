package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kartik on 30-Mar-17.
 */

public class MenuItemData {


    @SerializedName("company_id")
    int company_id;
    @SerializedName("category_id")
    int category_id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("allergy_info")
    String allergy_info;
    @SerializedName("price")
    int price;
    @SerializedName("is_attribute")
    int is_attribute;
    @SerializedName("apply_image")
    int apply_image;
    @SerializedName("image")
    int image;
    @SerializedName("status")
    int status;
    @SerializedName("id")
    int id;
    @SerializedName("imageUrl")
    String imageUrl;
    @SerializedName("attributes")
    List<Attribute> attributes =new ArrayList<Attribute>();
    @SerializedName("toppings")
    List<Toppings> toppings =new ArrayList<Toppings>();

    public int getCompany_id() {
        return company_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAllergy_info() {
        return allergy_info;
    }

    public int getPrice() {
        return price;
    }

    public int getIs_attribute() {
        return is_attribute;
    }

    public int getApply_image() {
        return apply_image;
    }

    public int getImage() {
        return image;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }





}
