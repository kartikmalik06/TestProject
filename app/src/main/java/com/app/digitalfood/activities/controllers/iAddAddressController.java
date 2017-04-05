package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.component.CustomEditText;

/**
 * Created by beyond on 05-Apr-17.
 */

public interface iAddAddressController {
    void addAddress(int userID, String s, String s1, String s2);

    void addressAdded();

    void updateAddress(int id, int userID, String s, String s1, String s2);


}
