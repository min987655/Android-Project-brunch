package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.Post;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.network.ServiceGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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

                // createDate format 맞춤
                for (Post post : postItems) {

                    String serverDate = post.getCreateDate();
                    Log.d(TAG, "onResponse: serverDate : " + serverDate);

                    SimpleDateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

                    try {
                        Date testServerDate = serverDateFormat.parse(serverDate);
                        String testNewDate = newDateFormat.format(testServerDate);

                        String newDate = testNewDate;
                        post.setCreateDate(newDate);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                if (postItems != null) {
                    allPosts.setValue(postItems);
                }
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
