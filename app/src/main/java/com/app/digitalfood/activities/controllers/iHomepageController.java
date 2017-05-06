package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.BranchType;

import java.util.List;

/**
 * Created by beyond on 24-Feb-17.
 */

public interface IHomepageController {

    boolean vailadateUser(String deviceId);
    void getBranches();
    void onResult(List<BranchType> branchlist);
    void showError(String message);

}
