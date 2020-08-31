package com.cos.brunch.network;

import com.cos.brunch.dto.CommonRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

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

    @POST("oauth/jwt/kakao/android")
    Call<CommonRespDto> kakaoAccess(@Body Map<String, Object> data);

    @POST("test1")
    Call<Post> createPost(@Body Post post);

    @POST("userProfileUpdate")
    Call<User> updateUser(@HeaderMap Map<String, Object> data,
                            @Body User user);
}



