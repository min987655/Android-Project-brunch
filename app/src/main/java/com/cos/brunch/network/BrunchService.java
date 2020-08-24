package com.cos.brunch.network;

import com.cos.brunch.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface BrunchService {

    @GET("posts")
    Call<List<Post>> getPosts();

//    @POST("oauth/jwt/kakao")
//    Call<Post> AccessToken(@Header("Authorization") String acToken);

    @POST("oauth/jwt/kakao")
    Call<Post> AccessToken(@HeaderMap Map<String, String> headers);

    @POST("test1")
    Call<Post> createPost(@Body Post post);
}



