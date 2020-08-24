package com.cos.brunch.network;

import com.cos.brunch.model.Post;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BrunchService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("oauth/jwt/kakao")
    Call<Post> AccessToken(@Header("Authorization") String acToken);

    @POST("test1")
    Call<Post> createPost(@Body Post post);

    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.61:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}



