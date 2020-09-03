package com.cos.brunch.screen.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cos.brunch.R;
import com.cos.brunch.databinding.Frag2MainBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFrag2 extends Fragment {

    private static final String TAG = "MainFrag2";
    private MainViewModel mainViewModel;
//    public List<Post> post = new ArrayList<>();
    public List<PostRespDto> postRespDtos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Frag2MainBinding layout = DataBindingUtil.inflate(inflater, R.layout.frag2_main, container, false);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                Log.d(TAG, "onChanged: 구독 !!!! " + postRespDtos);
                String title2 = postRespDtos.get(1).getTitle();
                String content2 = postRespDtos.get(1).getContent();
                String nickName2 = postRespDtos.get(1).getNickName();
                layout.tvTitle2.setText(title2);
                layout.tvNicknameMain2.setText(nickName2);
                layout.tvContent2.setText(content2);

                Log.d(TAG, "onChanged: title2 : " + title2);
                Log.d(TAG, "onChanged: title2 : layout : " + layout.tvTitle2.getText());
                Log.d(TAG, "onChanged: content2 : " + content2);
                Log.d(TAG, "onChanged: nickName2 : " + nickName2);
            }
        });

        return layout.getRoot();
    }
}