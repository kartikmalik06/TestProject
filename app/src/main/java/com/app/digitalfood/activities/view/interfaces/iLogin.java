package com.app.digitalfood.activities.view.interfaces;

import com.app.digitalfood.DataObject.LoginResult;

import org.json.JSONObject;

/**
 * Created by beyond on 03-Mar-17.
 */

public interface iLogin {


    void setLoginStatus(boolean status);

    void setFbUserData(JSONObject userData);

    void setUserData(LoginResult loginResult);

    void onSuccess();
}
