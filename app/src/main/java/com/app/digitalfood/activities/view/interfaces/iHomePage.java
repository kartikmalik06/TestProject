package com.app.digitalfood.activities.view.interfaces;

import com.app.digitalfood.DataObject.BranchType;

import java.util.List;

/**
 * Created by beyond on 07-Mar-17.
 */

public interface iHomePage {


    void checkDeviceid(String deviceId);

    void onReceiveBranches(List<BranchType> listBranch);

    void setDiscription(boolean expand);

    void showToast(String message);
}
