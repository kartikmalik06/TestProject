package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 29-Mar-17.
 */

public class LoginData {
    @SerializedName("id")
    int id;
    @SerializedName("company_id")
    String companyID;
    @SerializedName("username")
    String userName;
    @SerializedName("email")
    String email;

    @SerializedName("usertype")
    String userType;
    @SerializedName("company_customer_id")
    String companyCustomerId;
    @SerializedName("firstname")
    String firstName;
    @SerializedName("lastname")
    String lastName;
    @SerializedName("mobile")
    String mobile;
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public String getCompanyID() {
        return companyID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public String getUserType() {
        return userType;
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
