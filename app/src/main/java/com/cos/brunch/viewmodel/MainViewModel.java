package com.cos.brunch.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    private MutableLiveData<List<Post>> allPosts;
    private PostRepository postRepository = PostRepository.getInstance();

    public MainViewModel(@NonNull Application application) {
        super(application);
        allPosts = postRepository.getAllPosts();
        Log.d(TAG, "MainViewModel: " + allPosts.getValue());
    }

    public MutableLiveData<List<Post>> 구독하기() {
        Log.d(TAG, "구독하기: " + allPosts);
        return allPosts;
    }
}