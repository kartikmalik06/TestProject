package com.app.digitalfood.DataObject;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 29-Mar-17.
 */

public class SubCategoryData {
    @SerializedName("parent_id")
    int parent_id;
    @SerializedName("company_id")
    int company_id;
    @SerializedName("name")
    String name;
    @SerializedName("image")
    String image;
    @SerializedName("priority")
    int priority;
    @SerializedName("background_color")
    String background_color;
    @SerializedName("text_color")
    String text_color;
    @SerializedName("status")
    int status;
    @SerializedName("id")
    int id;
    @SerializedName("imageUrl")
    String imageUrl;
    @SerializedName("itemCount")
    int itemCount;

    boolean isChecked=false;

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public int getParent_id() {
        return parent_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getPriority() {
        return priority;
    }

    public String getBackground_color() {
        return background_color;
    }

    public String getText_color() {
        return text_color;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getItemCount() {
        return itemCount;
    }
}
