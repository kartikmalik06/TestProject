package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.LoginResult;
import com.app.digitalfood.activities.modals.ModalLogin;
import com.app.digitalfood.activities.view.interfaces.iLogin;

/**
 * Created by kartik on 28-Mar-17.
 */


public class LoginController implements iLoginController {
    iLogin iLogin;
    ModalLogin modalLogin;

    public LoginController(iLogin iLogin) {
        this.iLogin = iLogin;
        modalLogin = new ModalLogin(this);
    }

    @Override
    public void login(String userName, String password, String deviceId, String deviceType) {

        modalLogin.authanticateUser(userName, password, deviceId, deviceType);
    }

    @Override
    public void onLoginSuccess(LoginResult loginResult) {
        iLogin.setLoginStatus(true);
       // iLogin.setUserData(loginResult);
    }
}
