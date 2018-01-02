package com.softbdltd.learning.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.logging.Logger;

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

    public boolean getStatus() {
        return status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsers(List<User> users) {
        System.out.println("Accessed");
        this.users = users;
    }
}
