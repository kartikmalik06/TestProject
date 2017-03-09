package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beyond on 06-Mar-17.
 */

public class MenuResponse {
    @SerializedName("data")
    List<MenuItem> results;

    public List<MenuItem> getResults() {
        return results;
    }

    public void setResults(List<MenuItem> results) {
        this.results = results;
    }
}
