package com.app.digitalfood.activities.controllers;

import android.util.Log;

import com.app.digitalfood.activities.modals.IModalAddress;
import com.app.digitalfood.activities.modals.ModalAddress;
import com.app.digitalfood.activities.view.interfaces.iAddAddress;

/**
 * Created by beyond on 05-Apr-17.
 */

public class AddAddressController implements iAddAddressController {
    private iAddAddress addAddress;
    private IModalAddress modalAddress;

    public AddAddressController(iAddAddress addAddress) {
        this.addAddress = addAddress;
        modalAddress = new ModalAddress(this);
    }

    @Override
    public void addressAdded(String message) {
        addAddress.onAddressadded(message);
    }

    @Override
    public void updateAddress(int id, int userID,String userName, String userAddress, String userPhone) {
        Log.d("updateaddresscontroller","called");
        modalAddress.updateAddressInDB(id,userID, userName, userAddress, userPhone);
    }

    @Override
    public void addAddress(int userID, String userName, String userAddress, String userPhone) {
        Log.d("add address controller","called");
        modalAddress.addAddressInDB(userID, userName, userAddress, userPhone);
    }

}
