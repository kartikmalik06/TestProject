package com.app.digitalfood.network;

import com.app.digitalfood.DataObject.Address;
import com.app.digitalfood.DataObject.Login;
import com.app.digitalfood.DataObject.MenuItem;
import com.app.digitalfood.DataObject.MenuResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by kartik on 24-Feb-17.
 */

public interface ApiService {


    @GET("path")
    Call<Login> matchUser(@Path("name") String name, @Path("password") String password);

    @GET("path")
    Call<Address> getAddress(@Path("id") int id);

    @FormUrlEncoded
    @POST("menuitem/list")
    Call<MenuResponse> getMenuItem(@Field("branch_id") int branchId, @Field("category_id") int companyId);

}
