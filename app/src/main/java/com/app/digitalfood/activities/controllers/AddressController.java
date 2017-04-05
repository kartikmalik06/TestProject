package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.activities.modals.IModalAddress;
import com.app.digitalfood.activities.modals.ModalAddress;
import com.app.digitalfood.activities.modals.ModalOffer;
import com.app.digitalfood.activities.view.MyAddress;
import com.app.digitalfood.activities.view.interfaces.iMyAddress;

import java.util.List;

/**
 * Created by kartik on 03-Mar-17.
 */

public class AddressController implements iAddressController {
    IModalAddress modalAddress;
    iMyAddress myAddress;

    public AddressController(iMyAddress myAddress) {
        this.myAddress = myAddress;
        modalAddress = new ModalAddress(this);
    }

    @Override
    public void getAddressList(int id) {
        modalAddress.getuserAddressList(id);
    }

    @Override
    public void setAddressList(List<Address> data) {
myAddress.showAddressList(data);
    }

    @Override
    public void deleteAddress(int id) {
        modalAddress.deleteUserAddress(id);
    }

    @Override
    public void deletedSuccessfully() {
        myAddress.restartActivity();
    }

    @Override
    public void showErrorMessage(String s) {
        myAddress.showErrorToast(s);
    }
}
