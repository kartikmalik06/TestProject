package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kartik on 24-Feb-17.
 */

public class Address implements Serializable {
    @SerializedName("name")
    private String userName;
    @SerializedName("address")
    private String userAddress;
    //private String userCity;
    @SerializedName("phone")
    private String userPhone;
    @SerializedName("postcode")
    private String userPostalCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

   /* public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
*/
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode;
    }
}
