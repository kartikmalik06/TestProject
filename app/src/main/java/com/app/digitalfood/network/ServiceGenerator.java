package com.app.digitalfood.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beyond on 24-Feb-17.
 */

public class ServiceGenerator {
    public static Retrofit getService() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://demo.3edgetechnologies.com/takeaway/back-end/api/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        return retrofit;
    }
}
