package com.softbdltd.learning.NetworkRelatedClass;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.softbdltd.learning.Model.User;
import com.softbdltd.learning.Model.User2;
import com.softbdltd.learning.Model.User2ServerResponse;
import com.softbdltd.learning.Model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nayeem on 1/2/18.
 */

public class NetworkCall implements MyApiService
{







    @Override
    public void checkUserValidity(User2 userCredential, final ResponseCallback<String> userValidityCheckListener){
        Logger.addLogAdapter(new AndroidLogAdapter());
        RetrofitApiInterface retrofitApiInterface = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);


        Call<User2ServerResponse> call = retrofitApiInterface.checkUserValidity(userCredential);

        call.enqueue(new Callback<User2ServerResponse>() {

            @Override
            public void onResponse(Call<User2ServerResponse> call, Response<User2ServerResponse> response) {
                User2ServerResponse validity = response.body();
                if (validity.isSuccess()) {
                    userValidityCheckListener.onSuccess(validity.getMessage());
                }
                else {
                    userValidityCheckListener.onError(new Exception(validity.getMessage()));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Logger.d(t.toString());
            }
        });
    }
    @Override
    public void getAllUsers(final ResponseCallback<List<User>> listener) {
        RetrofitApiInterface retrofitApiInterface = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);

        Call<UserResponse> call = retrofitApiInterface.getAllUsers();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                List<User> users = response.body().getUsers();
                listener.onSuccess(users);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                listener.onError(t);
            }
        });
    }


}
