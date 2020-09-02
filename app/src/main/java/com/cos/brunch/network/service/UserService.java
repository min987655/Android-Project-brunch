package com.cos.brunch.network.service;

import com.cos.brunch.dto.CommonRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST("oauth/jwt/kakao/android")
    Call<CommonRespDto> kakaoAccess(@Body Map<String, Object> data);

    @PUT("user/profile")
    Call<User> updateUser(@HeaderMap Map<String, Object> data,
                          @Body User user);

    @GET("user/login")
    Call<User> getUser(@HeaderMap Map<String, Object> data);
}



