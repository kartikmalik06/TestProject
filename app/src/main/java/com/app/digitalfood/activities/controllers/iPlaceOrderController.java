package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.Address;

import java.util.List;

/**
 * Created by beyond on 13-Apr-17.
 */

public interface iPlaceOrderController {
    void getAddressList(int user_id);
    void setAddressList(List<Address> data);
    void showErrorMessage(String s);
}
