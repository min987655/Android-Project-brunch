package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.CommentRespDto;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Comment;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.network.ServiceGenerator;
import com.cos.brunch.network.service.CommentService;
import com.cos.brunch.network.service.PostService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRepository {

    private static final String TAG = "CommentRepository";

    private MutableLiveData<List<Comment>> allComments = new MutableLiveData<>();
    private MutableLiveData<List<CommentRespDto>> allCommentRespDtos = new MutableLiveData<>();
    private CommentService CommentService = ServiceGenerator.createService(CommentService.class);

    private static CommentRepository instance = new CommentRepository();

    private CommentRepository() {
    }

    public static CommentRepository getInstance() {
        return instance;
    }

    public MutableLiveData<List<CommentRespDto>> getAllComments(int postId) {

        Call<List<CommentRespDto>> call = CommentService.getComment(postId);
        call.enqueue(new Callback<List<CommentRespDto>>() {
            @Override
            public void onResponse(Call<List<CommentRespDto>> call, Response<List<CommentRespDto>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getAllComments : 연결실패 ! ");
                    return;
                }
                List<CommentRespDto> commentRespDtoItems = response.body();
                Log.d(TAG, "onResponse: getAllComments : commentRespDtoItems : " + commentRespDtoItems);

                for (CommentRespDto commentRespDto : commentRespDtoItems) {
                    // createDate format 맞춤
                    String serverDate = commentRespDto.getCreateDate();
                    Log.d(TAG, "onResponse: getAllComments : serverDate : " + serverDate);

                    SimpleDateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd. yyyy", Locale.ENGLISH);

                    try {
                        Date testServerDate = serverDateFormat.parse(serverDate);
                        String testNewDate = newDateFormat.format(testServerDate);

                        String newDate = testNewDate;
                        commentRespDto.setCreateDate(newDate);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (commentRespDtoItems != null) {
                    allCommentRespDtos.setValue(commentRespDtoItems);
                }
            }
            @Override
            public void onFailure(Call<List<CommentRespDto>> call, Throwable t) {
                Log.d(TAG, "onFailure: getAllComments : error : " + t.getMessage());
            }
        });
        return allCommentRespDtos;
    }


    // post/commentSave
    public int save(Map<String, Object> headerJwtToken, Comment comment, int postId) {
        Call<Comment> call = CommentService.commentSave(headerJwtToken, comment, postId);
        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: save : response.code() : " + response.code());
                    return;
                }
            }
            // 서버에서 돌려주는 값 json 아니라서 타입 오류남. 받을 필요 없어서 처리 안함.
            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Log.d(TAG, "onFailure: save : " + t.getMessage());
            }
        });
        return -1;
    }
}


