package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.User;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.network.ServiceGenerator;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "UserRepository";

    private MutableLiveData<List<User>> allUsers = new MutableLiveData<>();
    private BrunchService brunchService = ServiceGenerator.createService(BrunchService.class);

    private static UserRepository instance = new UserRepository();
    private UserRepository() { }

    public static UserRepository getInstance() {
        return instance;
    }


    public int update(Map<String,Object> headerJwtToken, User user){

        Call<User> call = brunchService.updateUser(headerJwtToken,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: response.code() : " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: response.body() : " + response.body());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return -1;
    }
}
