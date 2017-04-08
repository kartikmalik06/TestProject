package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kartik on 24-Feb-17.
 */

public class Address implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name="";
    @SerializedName("user_id")
    private int userId;
    @SerializedName("address1")
    private String address1;
    @SerializedName("address2")
    private String address2;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("delivery_instruction")
    private String delivery_instruction;
    @SerializedName("country")
    private String country="";



    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getDelivery_instruction() {
        return delivery_instruction;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setDelivery_instruction(String delivery_instruction) {
        this.delivery_instruction = delivery_instruction;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
