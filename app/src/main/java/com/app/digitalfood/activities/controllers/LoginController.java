package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.activities.modals.ModalLogin;
import com.app.digitalfood.activities.modals.iModalLogin;
import com.app.digitalfood.activities.view.interfaces.iLogin;

/**
 * Created by beyond on 24-Feb-17.
 */

public class LoginController implements iLoginController {
    private iLogin login;
    private iModalLogin modalLogin;

    public LoginController(iLogin login) {
        this.login = login;
        modalLogin=new ModalLogin(this);
    }

    @Override
    public void login(String userName, String password) {

       login.setLoginStatus(modalLogin.authanticateUser(userName,password));

    }
}
