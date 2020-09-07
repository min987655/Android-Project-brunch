package com.cos.brunch.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.model.User;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.repository.UserRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {

    private static final String TAG = "UsersViewModel";

    private MutableLiveData<List<User>> allUsers;
    private UserRepository userRepository = UserRepository.getInstance();

    public UsersViewModel(@NonNull Application application) {
        super(application);
        allUsers = userRepository.mtAllUser();
    }

    public MutableLiveData<List<User>> allUser구독하기() {
        return allUsers;
    }
}
