package com.app.digitalfood.activities.view.interfaces;

import org.json.JSONObject;

/**
 * Created by beyond on 03-Mar-17.
 */

public interface iLogin {

     boolean isSignInSuccessfull();
     void setLoginStatus(boolean status);
     void setUserData(JSONObject userData);
}
