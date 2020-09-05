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

    // 메인 : post + nickName
    @GET("post/main")
    Call<List<PostRespDto>> mtPostRespDtos();

    // post
    @GET("post/list")
    Call<List<Post>> getPosts();

    // now : post + tag
    @GET("post/list/글쓰기코치")
    Call<List<PostByTagRespDto>> getPostByTag();

    // 글쓰기
    @POST("post/save")
    Call<Post> savePost(@HeaderMap Map<String, Object> data,
                          @Body Post post);

    // 작가의 서랍
    @GET("post/writer")
    Call<List<Post>> getWriterPost(@HeaderMap Map<String, Object> data);
}



