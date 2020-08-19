package com.cos.brunch.network;

import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BrunchService {
    @GET("posts")
    Call<List<Post>> getPosts();

    @FormUrlEncoded
    @POST("oauth/jwt/google")
    Call<Map<String, Object>> AccessToken(@FieldMap HashMap<String, Object> param);

    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.64:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}


