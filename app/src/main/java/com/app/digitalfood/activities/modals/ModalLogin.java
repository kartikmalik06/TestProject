package com.app.digitalfood.activities.modals;

import com.app.digitalfood.DataObject.LoginResult;
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
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    @Override
    public void authanticateUser(String userName, String password, String deviceId, String deviceType) {
        //final boolean[] result = new boolean[1];
        Call<LoginResult> call = service.matchUser(userName, password, deviceId, deviceType);
        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus() == 1) {
                        iLoginController.onLoginSuccess(response.body());
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {

            }
        });

    }
}
