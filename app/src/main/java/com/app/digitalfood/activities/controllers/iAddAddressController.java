package com.app.digitalfood.activities.controllers;



/**
 * Created by kartik on 05-Apr-17.
 */

public interface iAddAddressController {


    void addressAdded(String message);

    void updateAddress(int id, int userID, String userName, String userAddress, String userPhone);


    void addAddress(int userID, String userName, String userAddress, String userPhone);
}
