package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 30-Mar-17.
 */
public class OfferData {

    @SerializedName("offer_image")
    String offer_image;
    @SerializedName("imageUrl")
    String imageUrl;

    public String getOffer_image() {
        return offer_image;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
