package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.BranchType;
import com.app.digitalfood.activities.modals.ModalHomePage;
import com.app.digitalfood.activities.modals.iModalHomePage;
import com.app.digitalfood.activities.view.interfaces.iHomePage;

import java.util.List;

/**
 * Created by beyond on 24-Feb-17.
 */

public class HomePageController implements IHomepageController {
    private iHomePage homePage;
    private iModalHomePage modalHomePage;
    List<BranchType> branchlist;

    public HomePageController(iHomePage homePage) {
        this.homePage = homePage;
        modalHomePage = new ModalHomePage(this);
    }

    @Override
    public boolean vailadateUser(String deviceId) {
        //get saved device id from server and match from the string
       /*
        if (deviceId==id_in_db)
        {
            return true;
        }else {
            return false;
        }*/
//need to delete this line
        return false;
    }

    @Override
    public void getGridViewData() {
        modalHomePage.getRestaurentList();

    }

    @Override
    public void setGridViewData(List<BranchType> branchlist) {
        homePage.setBranchList(branchlist);

    }
}
