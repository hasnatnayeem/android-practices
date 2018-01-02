package com.softbdltd.learning.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.softbdltd.learning.Model.User;
import com.softbdltd.learning.Model.UserResponse;
import com.softbdltd.learning.R;
import com.softbdltd.learning.Retrofit.ApiInterface;
import com.softbdltd.learning.Retrofit.RetrofitApiClient;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiInterface apiService;
    TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        tvUserInfo = (TextView) findViewById(R.id.tv_user_info);

        apiService = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<UserResponse> call = apiService.getAllUsers();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                List<User> users = response.body().getUsers();
                Logger.json(users.get(0).toJson());
                tvUserInfo.setText(userListToString(users));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    private String userListToString(List<User> users) {
        String result = "";
        for (User user: users) {
            result += user.toString() + "\n\n";
        }
        return result;
    }

    private void testLogger() {
        String json = "{name: nayeem, age: 24}";
        String xml = "<user><name>Nayeem</name><age>24</age></user>";
        Logger.json(json);
        Logger.xml(xml);
    }
}
