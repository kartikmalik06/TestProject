package com.app.digitalfood.activities.modals;

import android.util.Log;

import com.app.digitalfood.DataObject.CategoryResult;
import com.app.digitalfood.DataObject.MenuItemResult;
import com.app.digitalfood.DataObject.OfferResult;
import com.app.digitalfood.activities.controllers.IOrderPageController;

import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 29-Mar-17.
 */

public class ModalOrderPage implements IModalOrderPage {
    private IOrderPageController orderPageController;
    private ApiService service;

    public ModalOrderPage(IOrderPageController orderPageController) {
        this.orderPageController = orderPageController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }

    @Override
    public void categoryList(String branch_id) {
        Log.d("State","MenuList()");
        Call<CategoryResult> call = service.getMenucategory(branch_id);
        call.enqueue(new Callback<CategoryResult>() {
            @Override
            public void onResponse(Call<CategoryResult> call, Response<CategoryResult> response) {
                if (response.isSuccessful())
                    if (response.body().getStatus()==1)
                    {  Log.d("State","Result()");
                        orderPageController.setMenuList(response.body().getData());
                    }
            }

            @Override
            public void onFailure(Call<CategoryResult> call, Throwable t) {
                Log.d("State","Fail");
            }
        });


    }

    @Override
    public void categoryItem(String branch_id, int categoryId) {
       /* Log.d("State","getting category items");
        Call<MenuItemResult> call =service.getCategoryItem(branch_id,categoryId);
        call.enqueue(new Callback<MenuItemResult>() {
            @Override
            public void onResponse(Call<MenuItemResult> call, Response<MenuItemResult> response) {
                if (response.isSuccessful())
                    if (response.body().getStatus()==1)
                    {
                           orderPageController.addIteminList(response.body().getData());
                    }
            }

            @Override
            public void onFailure(Call<MenuItemResult> call, Throwable t) {

            }
        });*/

    }

    @Override
    public void offerlist(String branch_id) {
        Call<OfferResult> call=service.getOfferList(branch_id);
        call.enqueue(new Callback<OfferResult>() {
            @Override
            public void onResponse(Call<OfferResult> call, Response<OfferResult> response) {
                if (response.isSuccessful())
                    if (response.body().getStatus()==1)
                    {
                        orderPageController.setOffers(response.body().getData());
                    }
            }

            @Override
            public void onFailure(Call<OfferResult> call, Throwable t) {

            }
        });
    }
}
