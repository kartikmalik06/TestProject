package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.LoginData;
import com.app.digitalfood.DataObject.LoginResult;

/**
 * Created by beyond on 24-Feb-17.
 */

public interface iLoginController {

    void login(String userName, String password, String deviceId, String deviceType);

    void onLoginSuccess(LoginData loginData);
}
