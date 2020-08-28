package com.cos.brunch.network;

import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.kakao.network.response.ResponseBody;
import com.kakao.usermgmt.response.model.Profile;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface BrunchService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("oauth/jwt/kakao")
    Call<String> AccessToken(@Body Map<String, Object> data);

//    @POST("oauth/jwt/kakao")
//    Call<String> AccessToken(@Body Object result);

    @POST("test1")
    Call<Post> createPost(@Body Post post);
}



