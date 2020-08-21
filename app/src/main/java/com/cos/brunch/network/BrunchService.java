package com.cos.brunch.network;

import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.kakao.auth.authorization.accesstoken.AccessToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BrunchService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @FormUrlEncoded
    @POST("oauth/jwt/kakao")
    Call<Map<String, Object>> AccessToken(@Header("Authorization") String acToken);

    @FormUrlEncoded
    @POST("test1")
    Call<ResponseBody> getTest(@Field("test") String test);

    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.61:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}



