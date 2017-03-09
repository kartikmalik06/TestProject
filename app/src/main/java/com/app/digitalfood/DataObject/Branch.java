package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 02-Mar-17.
 */

public class Branch {
    @SerializedName("company_id")
    private String companyId;
    @SerializedName("name")
    private String companyName;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("min_order")
    private String minOrder;
    @SerializedName("is_delivery")
    private String isDelivery;
    @SerializedName("delivery_time")
    private String deliveryTime;
    @SerializedName("is_pickup")
    private String isPickUp;
    @SerializedName("pickup_time")
    private String pickUpTime;
    @SerializedName("pickup_charge")
    private String pickUpCharge;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(String minOrder) {
        this.minOrder = minOrder;
    }

    public String getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getIsPickUp() {
        return isPickUp;
    }

    public void setIsPickUp(String isPickUp) {
        this.isPickUp = isPickUp;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpCharge() {
        return pickUpCharge;
    }

    public void setPickUpCharge(String pickUpCharge) {
        this.pickUpCharge = pickUpCharge;
    }


}
