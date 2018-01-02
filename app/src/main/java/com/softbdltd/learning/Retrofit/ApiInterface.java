package com.softbdltd.learning.Retrofit;

import com.softbdltd.learning.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nayeem on 1/2/18.
 */

public interface ApiInterface {
    @GET("/api.php")
    Call<UserResponse> getAllUsers();
}
