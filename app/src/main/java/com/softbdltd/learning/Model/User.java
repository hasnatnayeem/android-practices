package com.softbdltd.learning.Model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nayeem on 1/2/18.
 */

public class User {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public User(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
