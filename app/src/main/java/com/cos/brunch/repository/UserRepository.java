package com.cos.brunch.repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.R;
import com.cos.brunch.model.User;
import com.cos.brunch.network.ServiceGenerator;
import com.cos.brunch.network.service.UserService;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "UserRepository";

    private MutableLiveData<List<User>> allUsers = new MutableLiveData<>();
    private List<User> loginUser = new ArrayList<>();
    private UserService userService = ServiceGenerator.createService(UserService.class);

    private static UserRepository instance = new UserRepository();
    private UserRepository() { }

    public static UserRepository getInstance() {
        return instance;
    }


    public int update(Map<String,Object> headerJwtToken, User user, final View v){

        Call<User> call = userService.updateUser(headerJwtToken,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: updateUser : response.code() : " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: updateUser : response.body() : " + response.body());

                User updateUser = response.body();
                Log.d(TAG, "onResponse : updateUser : " + updateUser);

//                Uri imgUri = Uri.parse(updateUser.getProfileImage());

//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(v.getContext().getContentResolver(), imgUri);

                TextView tvNickName;
                ImageView ivProfile;

                tvNickName = v.findViewById(R.id.tv_nickname);
                tvNickName.setText(updateUser.getNickName());

                ivProfile = v.findViewById(R.id.img_profile);
//                ivProfile.set

                if (updateUser != null) {
                    loginUser.add(updateUser);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return -1;
    }

    public User getLoginUser(Map<String , Object> headerJwtToken, NavigationView view) {

        NavigationView nav;
        final View navHeader;
        final ImageView navProfile;
        final TextView navNickName;

        nav = view.findViewById(R.id.nav);
        navHeader = nav.getHeaderView(0);

        navProfile = navHeader.findViewById(R.id.img_profile);
        navNickName = navHeader.findViewById(R.id.tv_nickname);

        Call<User> call = userService.getLoginUser(headerJwtToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getLoginUser : response.code() : " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse: getLoginUser : response.body() : " + response.body());

                User updateUser = response.body();
                Log.d(TAG, "onResponse : getLoginUser : updateUser : " + updateUser);


//                navProfile.setImageURI(updateUser.getProfileImage());
                navNickName.setText(updateUser.getNickName());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: getLoginUser : " + t.getMessage());
            }
        });
        return null;
    }
}
