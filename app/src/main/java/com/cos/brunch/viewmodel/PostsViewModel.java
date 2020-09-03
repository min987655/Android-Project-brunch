package com.cos.brunch.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.repository.PostRepository;

import java.util.List;

public class PostsViewModel extends AndroidViewModel {

    private static final String TAG = "PostsViewModel";

    private MutableLiveData<List<PostByTagRespDto>> allPostByTagRespDtos;
    private PostRepository postRepository = PostRepository.getInstance();

    public PostsViewModel(@NonNull Application application) {
        super(application);
        allPostByTagRespDtos = postRepository.getAllPostByTags();
    }

    public MutableLiveData<List<PostByTagRespDto>> PostByTagDto구독하기() {
        return allPostByTagRespDtos;
    }
}
