package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.activities.modals.ModalPlaceOrder;
import com.app.digitalfood.activities.modals.iModalPlaceOrder;
import com.app.digitalfood.activities.view.PlaceOrder;

import java.util.List;

/**
 * Created by beyond on 13-Apr-17.
 */

public class PlaceOrderController implements iPlaceOrderController {

    PlaceOrder placeOrder;
    iModalPlaceOrder modalPlaceOrder;

    public PlaceOrderController(PlaceOrder placeOrder) {

        this.placeOrder = placeOrder;
        modalPlaceOrder = new ModalPlaceOrder(this);
    }

    @Override
    public void getAddressList(int user_id) {
        modalPlaceOrder.getuserAddressList(user_id);
    }

    @Override
    public void setAddressList(List<Address> data) {
        placeOrder.setAddressListView(data);
    }

    @Override
    public void showErrorMessage(String s) {
        placeOrder.showErrorToast(s);
    }
}
