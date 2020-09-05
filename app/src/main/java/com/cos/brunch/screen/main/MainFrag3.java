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
import com.cos.brunch.adapter.main.MainFragmentAdapter;
import com.cos.brunch.databinding.Frag3MainBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainFrag3 extends Fragment {

    private static final String TAG = "MainFrag3";
    private MainViewModel mainViewModel;
    public MainFragmentAdapter mainFragmentAdapter;
    public List<PostRespDto> postRespDtos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Frag3MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag3_main, container, false);

//        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
//        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);
//
//        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
//            @Override
//            public void onChanged(List<PostRespDto> postRespDtos) {
//                Log.d(TAG, "onChanged: 구독 !!!! " + postRespDtos);
//                String title3 = postRespDtos.get(2).getTitle();
//                String content3 = postRespDtos.get(2).getContent();
//                String nickName3 = postRespDtos.get(2).getNickName();
//                layout.tvTitle3.setText(title3);
//                layout.tvNicknameMain3.setText(nickName3);
//                layout.tvContent3.setText(content3);
//
//                Log.d(TAG, "onChanged: title2 : " + title3);
//                Log.d(TAG, "onChanged: content2 : " + content3);
//                Log.d(TAG, "onChanged: nickName2 : " + nickName3);
//            }
//        });

        PostRepository postRepository = PostRepository.getInstance();

//        String title3 = postRepository.getAllPosts().getValue().get(2).getTitle();
//        String content3 = postRepository.getAllPosts().getValue().get(2).getContent();
//        String nickName3 = postRepository.getAllPosts().getValue().get(2).getNickName();

        String title3 = postRepository.getPostRespDtos().getValue().get(2).getTitle();
        String content3 = postRepository.getPostRespDtos().getValue().get(2).getContent();
        String nickName3 = postRepository.getPostRespDtos().getValue().get(2).getNickName();

        String coverImage = postRepository.getPostRespDtos().getValue().get(2).getCoverImg();
        Picasso.get().load(coverImage).into(layout.imgCoverBackMain);

        layout.tvTitle3.setText(title3);
        layout.tvNicknameMain3.setText(nickName3);
        layout.tvContent3.setText(content3);


        return layout.getRoot();
    }

}
