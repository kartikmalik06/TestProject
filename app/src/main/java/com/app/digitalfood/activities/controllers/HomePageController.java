package com.app.digitalfood.activities.controllers;

import android.content.Context;

/**
 * Created by beyond on 24-Feb-17.
 */

public class HomePageController implements iHomepageController {
    private Context context;
    public HomePageController(Context context) {

        this.context=context;
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
}
