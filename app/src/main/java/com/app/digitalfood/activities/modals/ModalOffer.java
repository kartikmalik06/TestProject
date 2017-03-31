package com.app.digitalfood.activities.modals;

import com.app.digitalfood.DataObject.OfferResult;
import com.app.digitalfood.activities.controllers.IOfferController;
import com.app.digitalfood.network.ApiService;
import com.app.digitalfood.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by beyond on 30-Mar-17.
 */

public class ModalOffer implements IModalOffer {

    private IOfferController offerController;
    private ApiService service;

    public ModalOffer(IOfferController offerController) {
        this.offerController=offerController;
        Retrofit retrofit = ServiceGenerator.getService();
        service = retrofit.create(ApiService.class);
    }



}
