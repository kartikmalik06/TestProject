package com.app.digitalfood.DataObject;

import java.io.Serializable;

/**
 * Created by beyond on 02-Mar-17.
 */
public class Restaurent implements Serializable {
    private String restaurentName,restaurentType;
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
