package com.cos.brunch.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabinetViewModel extends AndroidViewModel {

    private static final String TAG = "CabinetViewModel";

    private MutableLiveData<List<Post>> allPost;
    private PostRepository postRepository = PostRepository.getInstance();

    public CabinetViewModel(@NonNull Application application) {
        super(application);

        SharedPreferences sf = application.getSharedPreferences("test", Context.MODE_PRIVATE);
        String serverJwtToken = sf.getString("jwtToken", "");

        Map<String, Object> headerJwtToken = new HashMap<>();
        headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

        allPost = postRepository.mtWriterPost(headerJwtToken);
    }

    public MutableLiveData<List<Post>> 구독하기() {
        return allPost;
    }
}
