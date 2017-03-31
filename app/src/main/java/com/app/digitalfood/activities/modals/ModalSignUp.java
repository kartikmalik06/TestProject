package com.app.digitalfood.activities.modals;

import com.app.digitalfood.DataObject.SignUpData;
import com.app.digitalfood.activities.controllers.iSignupController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 28-Mar-17.
 */

public class ModalSignUp implements iModalsignup {
    private iSignupController signupController;
    ApiService service;

    public ModalSignUp(iSignupController signupController) {
        this.signupController = signupController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    @Override
    public void signUp(String name, String email, String password,String confirmPassword, String mobile, String deviceId, String device_type) {
        Call<SignUpData> call=service.signUp(name, email, password,confirmPassword, mobile, deviceId, device_type);
        call.enqueue(new Callback<SignUpData>() {
            @Override
            public void onResponse(Call<SignUpData> call, Response<SignUpData> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus() == 1) {
                        signupController.onSignUpSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpData> call, Throwable t) {
               signupController.showResult();
            }
        });
    }
}
