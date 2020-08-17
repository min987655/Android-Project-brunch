package com.cos.brunch.network;

import com.cos.brunch.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface BrunchService {
    @GET("posts")
    Call<List<Post>> getPosts();

    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.219.105:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}


