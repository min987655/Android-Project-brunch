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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainFrag2 extends Fragment {

    private static final String TAG = "MainFrag2";
    public List<PostRespDto> postRespDtos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Frag2MainBinding layout = DataBindingUtil.inflate(inflater, R.layout.frag2_main, container, false);


        PostRepository postRepository = PostRepository.getInstance();

        String title2 = postRepository.getPostRespDtos().getValue().get(1).getTitle();
        String content2 = postRepository.getPostRespDtos().getValue().get(1).getContent();
        String nickName2 = postRepository.getPostRespDtos().getValue().get(1).getNickName();

        String coverImage = postRepository.getPostRespDtos().getValue().get(1).getCoverImg();
        Picasso.get().load(coverImage).into(layout.imgCoverBackMain);

        layout.tvTitle2.setText(title2);
        layout.tvNicknameMain2.setText(nickName2);
        layout.tvContent2.setText(content2);

        return layout.getRoot();
    }
}