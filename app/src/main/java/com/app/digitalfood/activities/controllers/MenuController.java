package com.app.digitalfood.activities.controllers;

import android.content.Context;
import android.util.Log;

import com.app.digitalfood.DataObject.MenuItem;
import com.app.digitalfood.DataObject.MenuResponse;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 04-Mar-17.
 */

public class MenuController implements iMenuController {
    Context context;

    public MenuController(Context context) {
        this.context=context;
    }

    @Override
    public void getCategoryItem(int branchId, int categoryId) {
        Retrofit retrofit = ServiceGenerator.getService();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<MenuResponse> call=apiService.getMenuItem(branchId, categoryId);
        call.enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                Log.d("Result","True");
                List<MenuItem> menuList=response.body().getResults();
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.d("Result",t.getMessage());
            }
        });

    }
}
