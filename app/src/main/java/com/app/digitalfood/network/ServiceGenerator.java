package com.app.digitalfood.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beyond on 24-Feb-17.
 */

public class ServiceGenerator {
    public static Retrofit getService() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://192.168.56.1:8080/digitalfood/back-end/api/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        return retrofit;
    }
}
