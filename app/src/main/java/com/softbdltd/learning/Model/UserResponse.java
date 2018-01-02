package com.softbdltd.learning.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nayeem on 1/2/18.
 */

public class UserResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("users")
    private List<User> users;

    public boolean isSuccessful(){
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<User> getUsers() {
        return users;
    }

}
