package com.cos.brunch.network.service;

import com.cos.brunch.dto.CommonRespDto;
import com.cos.brunch.model.Comment;
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

public interface CommentService {

    @POST("post/commentSave")
    Call<Comment> commentSave(@HeaderMap Map<String, Object> data,
                              @Body Comment comment,
                              @Body Post post);

//    @GET("post/comment")
}



