package com.app.digitalfood.activities.modals;

import android.util.Log;

import com.app.digitalfood.DataObject.Branch;
import com.app.digitalfood.activities.controllers.IHomepageController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 28-Mar-17.
 */

public class ModalHomePage implements iModalHomePage {
    private IHomepageController homepageController;
    private ApiService service;

    public ModalHomePage(IHomepageController homepageController) {
        this.homepageController = homepageController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    @Override
    public void getRestaurentList() {
        Call<Branch> call = service.getBranches();
        call.enqueue(new Callback<Branch>() {
            @Override
            public void onResponse(Call<Branch> call, Response<Branch> response) {
                if (response.isSuccessful())
                    if (response.body().getStatus()==1) {
                        Log.d("branch result","pass");
                        homepageController.setGridViewData(response.body().getData());
                    }
                else
                        Log.d("branch result",response.body().getMessage());
            }

            @Override
            public void onFailure(Call<Branch> call, Throwable t) {
                Log.d("branch result","failure");
            }
        });


    }
}
