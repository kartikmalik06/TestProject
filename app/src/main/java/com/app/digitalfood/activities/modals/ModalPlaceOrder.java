package com.app.digitalfood.activities.modals;

import com.app.digitalfood.DataObject.AddressResponse;
import com.app.digitalfood.activities.controllers.PlaceOrderController;
import com.app.digitalfood.activities.controllers.iPlaceOrderController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 13-Apr-17.
 */

public class ModalPlaceOrder implements iModalPlaceOrder {
    iPlaceOrderController placeOrderController;
    private ApiService service;
    public ModalPlaceOrder(iPlaceOrderController placeOrderController) {
        this.placeOrderController=placeOrderController;
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
                        placeOrderController.setAddressList(response.body().getData());
                    } else {
                        placeOrderController.showErrorMessage("No address to show");
                    }
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                placeOrderController.showErrorMessage(t.getMessage());
            }
        });
    }
}
