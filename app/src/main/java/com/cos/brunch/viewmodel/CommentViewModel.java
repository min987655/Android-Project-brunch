package com.cos.brunch.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.CommentRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.CommentRepository;
import com.cos.brunch.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentViewModel extends AndroidViewModel {

    private static final String TAG = "CommentViewModel";

    private MutableLiveData<List<CommentRespDto>> allCommentRespDtos;
    private CommentRepository commentRepository = CommentRepository.getInstance();

    public CommentViewModel(@NonNull Application application) {
        super(application);
        int postId = 14;
        allCommentRespDtos = commentRepository.getAllComments(postId);
    }

    public MutableLiveData<List<CommentRespDto>> CommentDto구독하기() {
        return allCommentRespDtos;
    }
}
