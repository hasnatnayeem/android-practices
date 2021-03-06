package com.softbdltd.learning.NetworkRelatedClass;

import com.softbdltd.learning.Model.User2;
import com.softbdltd.learning.Model.User2ServerResponse;
import com.softbdltd.learning.Model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by nayeem on 1/2/18.
 */

public interface RetrofitApiInterface {
    @GET("/api.php")
    Call<UserResponse> getAllUsers();

    @POST("/check.php")
    Call<User2ServerResponse> checkUserValidity(@Body User2 credential);
}
