package com.app.digitalfood.activities.view.interfaces;

import com.app.digitalfood.DataObject.Address;

import java.util.List;

/**
 * Created by beyond on 07-Mar-17.
 */

public interface iMyAddress {
    void showAddressList(List<Address> addresses);

    void deleteAddress(int id);

    void restartActivity();

    void showErrorToast(String s);
}
