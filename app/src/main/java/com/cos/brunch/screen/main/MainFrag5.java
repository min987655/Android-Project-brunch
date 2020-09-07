package com.cos.brunch.screen.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cos.brunch.R;
import com.cos.brunch.adapter.main.MainFragmentAdapter;
import com.cos.brunch.databinding.Frag2MainBinding;
import com.cos.brunch.databinding.Frag3MainBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainFrag5 extends Fragment {

    private static final String TAG = "MainFrag3";
    private MainViewModel mainViewModel;
    public MainFragmentAdapter mainFragmentAdapter;
    public List<PostRespDto> postRespDtos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Frag2MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag2_main, container, false);

        PostRepository postRepository = PostRepository.getInstance();

        String title6 = postRepository.getPostRespDtos().getValue().get(8).getTitle();
        String content6 = postRepository.getPostRespDtos().getValue().get(8).getContent();
        String nickName6 = postRepository.getPostRespDtos().getValue().get(8).getNickName();

        String coverImage = postRepository.getPostRespDtos().getValue().get(8).getCoverImg();
        Picasso.get().load(coverImage).into(layout.imgCoverBackMain);

        layout.tvTitle2.setText(title6);
        layout.tvNicknameMain2.setText(nickName6);
        layout.tvContent2.setText(content6);

        return layout.getRoot();
    }

}
