package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 30-Mar-17.
 */

public class Attribute
{
    @SerializedName("name")
    String name;
    @SerializedName("id")
    int id;
    @SerializedName("attributesGroup")
    List<AttributeGroups> attributesGroup =new ArrayList<AttributeGroups>();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<AttributeGroups> getAttributesGroup() {
        return attributesGroup;
    }
}