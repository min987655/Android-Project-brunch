package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.Post;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.network.ServiceGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private static final String TAG = "PostRepository";

    private MutableLiveData<List<Post>> allPosts = new MutableLiveData<>();
    private BrunchService brunchService = ServiceGenerator.createService(BrunchService.class);

    private static PostRepository instance = new PostRepository();
    private PostRepository() { }

    public static PostRepository getInstance() {
        return instance;
    }

    public MutableLiveData<List<Post>> getAllPosts() {

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

    public int save(Post post){

        Map<String, Object> header = new HashMap<>();
        header.put("Authorization", "Bearer ");

        Call<Post> call = brunchService.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: response.code() : " + response.code());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return -1;
    }
}
