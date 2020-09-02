package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.User;
import com.cos.brunch.network.ServiceGenerator;
import com.cos.brunch.network.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "UserRepository";

    private MutableLiveData<List<User>> allUsers = new MutableLiveData<>();
    private List<User> user1 = new ArrayList<>();
    private UserService userService = ServiceGenerator.createService(UserService.class);

    private static UserRepository instance = new UserRepository();
    private UserRepository() { }

    public static UserRepository getInstance() {
        return instance;
    }


    public int update(Map<String,Object> headerJwtToken, User user){

        Call<User> call = userService.updateUser(headerJwtToken,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: response.code() : " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: response.body() : " + response.body());

                User updateUser = response.body();
                Log.d(TAG, "onResponse : updateUser : " + updateUser);

                if (updateUser != null) {
                    user1.add(updateUser);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return -1;
    }

    public User getLoginUser(Map<String , Object> headerJwtToken) {

        Call<User> call = userService.getUser(headerJwtToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: response.code() : " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: response.body() : " + response.body());

                User updateUser = response.body();
                Log.d(TAG, "onResponse : updateUser : " + updateUser);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return null;
    }
}
