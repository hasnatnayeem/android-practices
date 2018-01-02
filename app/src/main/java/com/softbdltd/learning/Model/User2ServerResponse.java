package com.softbdltd.learning.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nayeem on 1/2/18.
 */

public class User2ServerResponse {
    @SerializedName("status")
    boolean statusString; //variable name is statusString but it'll map with "status"
    @SerializedName("message")
    String messageString; //variable name is messageString but it'll map with "message"

    public boolean isSuccess(){
        return statusString;
    }

    public String getMessage() {
        return messageString;
    }
}