package com.app.digitalfood.DataObject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beyond on 05-May-17.
 */

public class HashData {
    @SerializedName("hash_string")
    String hashString;
    @SerializedName("hash")
    String hash;
    @SerializedName("key")
    String key;
    @SerializedName("action")
    String action;

    public String getHashString() {
        return hashString;
    }

    public String getHash() {
        return hash;
    }

    public String getKey() {
        return key;
    }

    public String getAction() {
        return action;
    }
}
