package com.cos.brunch.screen.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cos.brunch.R;
import com.cos.brunch.databinding.Frag4MainBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFrag4 extends Fragment {
    private static final String TAG = "MainFrag4";

    private MainViewModel mainViewModel;
    public List<Post> post = new ArrayList<>();
    public List<PostRespDto> postRespDtos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Frag4MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag4_main, container, false);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

//        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
//            @Override
//            public void onChanged(List<Post> posts) {
//                Log.d(TAG, "onChanged: 구독 !!!! " + posts);
//                String title = posts.get(3).getTitle();
//                String title2 = posts.get(4).getTitle();
//                layout.tvTitle4.setText(title);
//                layout.tvTitle5.setText(title2);
//                Log.d(TAG, "onChanged: layout.tvTitle : " + title.toString());
//                Log.d(TAG, "onChanged: layout.tvTitle : " + title2.toString());
//            }
//
//        });

        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                Log.d(TAG, "onChanged: 구독 !!!! " + postRespDtos);
                String title4 = postRespDtos.get(3).getTitle();
                String title5 = postRespDtos.get(4).getTitle();
                String nickName4 = postRespDtos.get(3).getNickName();
                String nickName5 = postRespDtos.get(4).getNickName();
                layout.tvTitle4.setText(title4);
                layout.tvTitle5.setText(title5);
                layout.tvNicknameMain4.setText(nickName4);
                layout.tvNicknameMain5.setText(nickName5);

                Log.d(TAG, "onChanged: title2 : " + title4);
                Log.d(TAG, "onChanged: title2 : " + title5);
                Log.d(TAG, "onChanged: nickName2 : " + nickName4);
                Log.d(TAG, "onChanged: nickName2 : " + nickName5);
            }
        });

        return layout.getRoot();

    }

}
