package com.app.digitalfood.activities.modals;

import com.app.digitalfood.DataObject.Login;
import com.app.digitalfood.activities.controllers.iLoginController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by kartik on 03-Mar-17.
 */

// modal for login class
public class ModalLogin implements iModalLogin {
    private iLoginController iLoginController;
    ApiService service;
    public ModalLogin(iLoginController iLoginController) {
        this.iLoginController = iLoginController;
        Retrofit retrofit= ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    @Override
    public boolean authanticateUser(String userName, String password) {
        final boolean[] result = new boolean[1];
        Call<Login> call=service.matchUser(userName,password);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                result[0] = response.body().isLogin();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
        return result[0];
    }
}
