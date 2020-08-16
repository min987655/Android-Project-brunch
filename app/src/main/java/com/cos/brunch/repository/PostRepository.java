package com.cos.brunch.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.Post;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.network.BrunchSevice;
import com.cos.brunch.network.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private static final String TAG = "MainRepository";

    private MutableLiveData<List<Post>> allPosts = new MutableLiveData<>();

    private static MainRepository instance = new MainRepository();

    private MainRepository() {
    }

    public static MainRepository getInstance() {
        return instance;
    }

    public static void enableNavigation() {
    BrunchService brunchSevice = BrunchService.retrofit.create(BrunchService.class);
    Call<List<Post>> call = brunchSevice.getPosts();
        call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if (!response.isSuccessful()) {
                tvTest.setText("Code: " + response.code());
                return;
            }
            List<Post> postItems = response.body();
            Log.d(TAG, "onResponse: postItems : " + postItems);

            for (Post post : postItems) {
                String content = "";
                content += "id: " + post.getId() + "\n";
                content += "USER_ID: " + post.getUserId() + "\n";
                content += "TITLE: " + post.getTitle() + "\n";
                content += "SUB_TITLE: " + post.getSubTitle() + "\n";
                content += "POST_TYPE: " + post.getPostType() + "\n";
                content += "CONTENT: " + post.getContent() + "\n\n";
                content += "LIKE_TYPE: " + post.getLikeType() + "\n\n";
                content += "LIKE_COUNT: " + post.getLikeCount() + "\n\n";
                content += "READ_COUNT: " + post.getReadCount() + "\n\n";
                content += "CREATE_DATE: " + post.getCreateDate() + "\n\n";
                tvTest.append(content);
                Log.d(TAG, "onResponse: tvTest : " + tvTest);
            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            tvTest.setText(t.getMessage());
        }

    });

}
