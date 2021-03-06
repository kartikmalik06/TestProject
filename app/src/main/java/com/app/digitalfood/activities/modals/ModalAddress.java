package com.app.digitalfood.activities.modals;

import android.util.Log;

import com.app.digitalfood.DataObject.AddressResponse;
import com.app.digitalfood.DataObject.DefautResponce;
import com.app.digitalfood.activities.controllers.iAddAddressController;
import com.app.digitalfood.activities.controllers.iAddressController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 05-Apr-17.
 */

public class ModalAddress implements IModalAddress {
    private iAddressController addressController;
    private iAddAddressController addAddressController;
    private ApiService service;

    public ModalAddress(iAddressController addressController) {
        this.addressController = addressController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    public ModalAddress(iAddAddressController addAddressController) {
        this.addAddressController = addAddressController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }


    @Override
    public void getuserAddressList(int user_id) {

        Call<AddressResponse> call = service.getAddressList(user_id);
        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                if (response.isSuccessful())
                    if (response.body().getMessage().trim().isEmpty()) {
                        addressController.setAddressList(response.body().getData());
                    } else {
                        addressController.showErrorMessage("No address to show");
                    }
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                addressController.showErrorMessage(t.getMessage());
            }
        });

    }

    @Override
    public void deleteUserAddress(int id) {
        Call<DefautResponce> call = service.deleteAddressInDB(id);
        call.enqueue(new Callback<DefautResponce>() {
            @Override
            public void onResponse(Call<DefautResponce> call, Response<DefautResponce> response) {
                if (response.isSuccessful())
                    addressController.deletedSuccessfully();
            }

            @Override
            public void onFailure(Call<DefautResponce> call, Throwable t) {

            }
        });
    }

    @Override
    public void addAddressInDB(int userID, String userName, String userAddress, String userPhone) {
        Log.d("addAddressInDB", "called");
        Call<DefautResponce> call = service.addAddressInDB(userID, userName, userAddress, userPhone);
        call.enqueue(new Callback<DefautResponce>() {
            @Override
            public void onResponse(Call<DefautResponce> call, Response<DefautResponce> response) {
                Log.d("onResponse", "called");
                if (response.body().getMessage() != "") {
                    Log.d("onResponse.body", "called");
                    addAddressController.addressAdded(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<DefautResponce> call, Throwable t) {
                Log.d("onFailure", "called");
            }
        });
    }


    @Override
    public void updateAddressInDB(int id, int userID, String userName, String userAddress, String userPhone) {
        Call<DefautResponce> call = service.updateAddress(id, userID, userName, userAddress, userPhone);
        call.enqueue(new Callback<DefautResponce>() {
            @Override
            public void onResponse(Call<DefautResponce> call, Response<DefautResponce> response) {
                addAddressController.addressAdded(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<DefautResponce> call, Throwable t) {

            }
        });
    }
}
