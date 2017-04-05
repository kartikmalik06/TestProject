package com.app.digitalfood.activities.controllers;

import android.content.Context;

import com.app.digitalfood.DataObject.LoginData;
import com.app.digitalfood.DataObject.LoginResult;
import com.app.digitalfood.activities.modals.ModalLogin;
import com.app.digitalfood.activities.view.interfaces.iLogin;
import com.app.digitalfood.database.DatabaseHandler;

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
    public void onLoginSuccess(LoginData loginData) {
        iLogin.setLoginStatus(true);
        DatabaseHandler databaseHandler = new DatabaseHandler((Context) iLogin);
        databaseHandler.addUserInfo(loginData.getId(), loginData.getFirstName(), loginData.getEmail(), loginData.getMobile(), true);
        // iLogin.setUserData(loginResult);
    }
}
