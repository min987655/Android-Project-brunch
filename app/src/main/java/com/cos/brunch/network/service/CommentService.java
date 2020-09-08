package com.cos.brunch.network.service;

import com.cos.brunch.dto.CommentRespDto;
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

    @POST("post/commentSave/{postId}")
    Call<Comment> commentSave(@HeaderMap Map<String, Object> data,
                              @Body Comment comment,
                              @Path("postId") int postId);

    @GET("post/comment/{postId}")
    Call<List<CommentRespDto>> getComment(@Path("postId") int postId);
}



