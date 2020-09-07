package com.cos.brunch.screen.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cos.brunch.R;
import com.cos.brunch.databinding.Frag1MainBinding;
import com.cos.brunch.databinding.Frag2MainBinding;
import com.cos.brunch.databinding.Frag3MainBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainFrag6 extends Fragment {

    private static final String TAG = "MainFrag2";
    private MainViewModel mainViewModel;
    //    public List<Post> post = new ArrayList<>();
    public List<PostRespDto> postRespDtos = new ArrayList<>();
    private Post post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Frag1MainBinding layout = DataBindingUtil.inflate(inflater, R.layout.frag1_main, container, false);

        PostRepository postRepository = PostRepository.getInstance();

        String title7 = postRepository.getPostRespDtos().getValue().get(9).getTitle();
        String content7 = postRepository.getPostRespDtos().getValue().get(9).getContent();
        String nickName7 = postRepository.getPostRespDtos().getValue().get(9).getNickName();

        String coverImage = postRepository.getPostRespDtos().getValue().get(9).getCoverImg();
        Picasso.get().load(coverImage).into(layout.imgCover);
        Picasso.get().load(coverImage).into(layout.imgCoverBackMain);

        layout.tvTitle.setText(title7);
        layout.tvNicknameMain.setText(nickName7);
//        layout.tvConten.setText(content7);

        layout.imgCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailPostActivity.class);
                startActivity(intent);
            }
        });

        return layout.getRoot();
    }
}