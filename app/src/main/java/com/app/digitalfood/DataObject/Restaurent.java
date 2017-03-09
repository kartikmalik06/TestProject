package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by beyond on 02-Mar-17.
 */
public class Restaurent implements Serializable {
    @SerializedName("name")
    private String restaurentName;
    @SerializedName("type")
    private String restaurentType;
   // private Image restaurentImage;

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

  /*  public Image getRestaurentImage() {
        return restaurentImage;
    }

    public void setRestaurentImage(Image restaurentImage) {
        this.restaurentImage = restaurentImage;
    }*/

    public String getRestaurentType() {
        return restaurentType;
    }

    public void setRestaurentType(String restaurentType) {
        this.restaurentType = restaurentType;
    }
}
