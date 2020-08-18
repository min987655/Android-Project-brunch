package com.cos.brunch.repository;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.Post;
import com.cos.brunch.network.BrunchService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class PostRepository {

    private static final String TAG = "PostRepository";
    private MutableLiveData<List<Post>> allPosts = new MutableLiveData<>();
    private static PostRepository instance = new PostRepository();
    private PostRepository() { }

    public static PostRepository getInstance() {
        return instance;
    }

    public MutableLiveData<List<Post>> getAllPosts() {
        
        BrunchService brunchService = BrunchService.retrofit.create(BrunchService.class);
        
        Call<List<Post>> call = brunchService.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: 연결실패 ! ");
                    return;
                }
                List<Post> postItems = response.body();
                Log.d(TAG, "onResponse: postItems : " + postItems);

                if (postItems != null) {
                    allPosts.setValue(postItems);
                }
                Log.d(TAG, "onResponse: allPosts : " + allPosts.getValue());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: error : " + t.getMessage());
            }

        });
        return allPosts;
    }
}
