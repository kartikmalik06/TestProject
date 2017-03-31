package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 28-Mar-17.
 */

public class SignUpData {
    @SerializedName("usertype")
    String userType;
    @SerializedName("status")
    int status;
    @SerializedName("username")
    String userName;
    @SerializedName("email")
    String email;
    @SerializedName("id")
    int id;
    @SerializedName("company_customer_id")
    String companyCustomerId;
    @SerializedName("firstname")
    String firstName;
    @SerializedName("lastname")
    String lastName;
    @SerializedName("mobile")
    String mobile;
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

    public String getUserType() {
        return userType;
    }

    public int getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getCompanyCustomerId() {
        return companyCustomerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }
}
