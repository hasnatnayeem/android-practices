package com.softbdltd.learning.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nayeem on 1/2/18.
 */

public class User2 {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("password")
    private String password;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User2(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
