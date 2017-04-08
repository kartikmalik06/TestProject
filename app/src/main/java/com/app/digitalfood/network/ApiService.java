package com.app.digitalfood.network;

import com.app.digitalfood.DataObject.AddressResponse;
import com.app.digitalfood.DataObject.Branch;
import com.app.digitalfood.DataObject.DefautResponce;
import com.app.digitalfood.DataObject.LoginResult;
import com.app.digitalfood.DataObject.CategoryResult;
import com.app.digitalfood.DataObject.OfferResult;
import com.app.digitalfood.DataObject.SignUpData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by kartik on 24-Feb-17.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResult> matchUser(@Field("username") String name, @Field("password") String password,
                                @Field("device_id") String deviceId, @Field("device_type") String deviceType);

    @FormUrlEncoded
    @POST("signUp")
    Call<SignUpData> signUp(@Field("firstname") String name, @Field("email") String email, @Field("password") String password, @Field("confirmPassword") String confirmPassword, @Field("mobile") String mobile,
                            @Field("device_id") String deviceId, @Field("device_type") String deviceType);

    @GET("branch/list")
    Call<Branch> getBranches();

    @FormUrlEncoded
    @POST("menucategory/list")
    Call<CategoryResult> getMenucategory(@Field("branch_id") String branchId);

   /* @FormUrlEncoded
    @POST("menuitem/list")
    Call<MenuItemResult> getCategoryItem(@Field("branch_id") String branchId, @Field("category_id") int categoryId);*/

    @FormUrlEncoded
    @POST("offerimage/list")
    Call<OfferResult> getOfferList(@Field("branch_id") String branchId);

    @FormUrlEncoded
    @POST("deliveryaddress/list")
    Call<AddressResponse> getAddressList(@Field("user_id") int user_id);

    @FormUrlEncoded
    @POST("deliveryaddress/delete")
    Call<DefautResponce> deleteAddressInDB(@Field("id") int id);

    /*@FormUrlEncoded
    @POST("deliveryaddress/create")
    Call<DefautResponce> addAddressInDB(@Field("user_id") int userID, @Field("name") String userName, @Field("address1") String userAddress, @Field("mobile") String userPhone);
*/
    @FormUrlEncoded
    @POST("deliveryaddress/update")
    Call<DefautResponce> updateAddress(@Field("id") int id, @Field("user_id") int userID, @Field("name") String userName, @Field("address1") String userAddress, @Field("mobile") String userPhone);

    @FormUrlEncoded
    @POST("deliveryaddress/create")
    Call<DefautResponce> addAddressInDB(@Field("user_id") int userID, @Field("name") String userName, @Field("address1") String userAddress, @Field("mobile") String userPhone);
}
