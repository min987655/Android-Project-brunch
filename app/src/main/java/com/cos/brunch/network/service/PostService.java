package com.cos.brunch.network.service;

import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostService {

    @GET("post/main")
    Call<List<PostRespDto>> getPostRespDto();

    @GET("post/list")
    Call<List<PostRespDto>> getPosts();

    @GET("post/list/그림웹툰")
    Call<List<PostByTagRespDto>> getPostByTag();

    @POST("post/save")
    Call<Post> createPost(@HeaderMap Map<String, Object> data,
                          @Body Post post);

    @GET("/post/writer")
    Call<Post> getWriterPost(@HeaderMap Map<String, Object> data);
}



