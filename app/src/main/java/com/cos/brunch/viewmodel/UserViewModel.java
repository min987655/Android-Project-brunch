//package com.cos.brunch.viewmodel;
//
//import android.app.Application;
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.MutableLiveData;
//
//import com.cos.brunch.model.Post;
//import com.cos.brunch.model.User;
//import com.cos.brunch.repository.PostRepository;
//import com.cos.brunch.repository.UserRepository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UserViewModel extends AndroidViewModel {
//
//    private static final String TAG = "UserViewModel";
//
//    private MutableLiveData<User> user;
//    private UserRepository userRepository = UserRepository.getInstance();
//
//    public UserViewModel(@NonNull Application application) {
//        super(application);
//
//        SharedPreferences sf = application.getSharedPreferences("test", Context.MODE_PRIVATE);
//        String serverJwtToken = sf.getString("jwtToken", "");
//
//        Map<String, Object> headerJwtToken = new HashMap<>();
//        headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
//        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);
//
//        user = userRepository.getMtLoginUser(headerJwtToken);
//        Log.d(TAG, "UserViewModel: " + user.getValue());
//    }
//
//    public MutableLiveData<User> User구독하기() {
//        Log.d(TAG, "구독하기: " + user);
//        return user;
//    }
//}
