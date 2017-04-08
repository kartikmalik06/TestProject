package com.app.digitalfood.activities.modals;

/**
 * Created by beyond on 05-Apr-17.
 */

public interface IModalAddress {


    void getuserAddressList(int user_id);

    void deleteUserAddress(int id);

    void addAddressInDB(int userID, String userName, String userAddress, String userPhone);

    void updateAddressInDB(int id, int userID, String userName, String userAddress, String userPhone);
}
