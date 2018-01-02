package com.softbdltd.learning.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.softbdltd.learning.Model.User;
import com.softbdltd.learning.Model.User2;
import com.softbdltd.learning.Model.User2ServerResponse;
import com.softbdltd.learning.Model.UserResponse;
import com.softbdltd.learning.NetworkRelatedClass.NetworkCall;
import com.softbdltd.learning.NetworkRelatedClass.ResponseCallback;
import com.softbdltd.learning.R;
import com.softbdltd.learning.NetworkRelatedClass.MyApiService;
import com.softbdltd.learning.NetworkRelatedClass.RetrofitApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyApiService apiService;
    TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        tvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        User2 user = new User2("nayeem", "123");
        MyApiService myApiService = new NetworkCall();
        myApiService.checkUserValidity(user, new ResponseCallback<String>() {

            @Override
            public void onSuccess(String data) {
                Logger.d(data);
            }

            @Override
            public void onError(Throwable th) {
                Logger.d(th.getMessage());
            }
        });


        myApiService.getAllUsers(new ResponseCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                tvUserInfo.setText(userListToString(users));
            }

            @Override
            public void onError(Throwable th) {
                Logger.d(th.getMessage());
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
