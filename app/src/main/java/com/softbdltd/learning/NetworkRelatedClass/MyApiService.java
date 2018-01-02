package com.softbdltd.learning.NetworkRelatedClass;

import com.softbdltd.learning.Model.User;
import com.softbdltd.learning.Model.User2;
import com.softbdltd.learning.Model.User2ServerResponse;
import com.softbdltd.learning.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by nayeem on 1/2/18.
 */

public interface MyApiService {

    void checkUserValidity(User2 userLoginCredential, ResponseCallback<String> callback);
    void getAllUsers(ResponseCallback<List<User>> callback);
}
