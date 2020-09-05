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
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

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

        PostRepository postRepository = PostRepository.getInstance();

        String title4 = postRepository.getPostRespDtos().getValue().get(3).getTitle();
        String nickName4 = postRepository.getPostRespDtos().getValue().get(3).getNickName();

        String title5 = postRepository.getPostRespDtos().getValue().get(4).getTitle();
        String nickName5 = postRepository.getPostRespDtos().getValue().get(4).getNickName();

//        String title4 = postRepository.getAllPosts().getValue().get(3).getTitle();
//        String nickName4 = postRepository.getAllPosts().getValue().get(3).getNickName();
//
//        String title5 = postRepository.getAllPosts().getValue().get(4).getTitle();
//        String nickName5 = postRepository.getAllPosts().getValue().get(4).getNickName();

        String coverImage4 = postRepository.getPostRespDtos().getValue().get(3).getCoverImg();
        String coverImage5 = postRepository.getPostRespDtos().getValue().get(4).getCoverImg();
        Picasso.get().load(coverImage4).into(layout.imgCoverBackMain1);
        Picasso.get().load(coverImage5).into(layout.imgCoverBackMain2);



        layout.tvTitle4.setText(title4);
        layout.tvNicknameMain4.setText(nickName4);

        Log.d(TAG, "onCreateView: title4 : " + title4);
        Log.d(TAG, "onCreateView: nickName4 : " + nickName4);

        layout.tvTitle5.setText(title5);
        layout.tvNicknameMain5.setText(nickName5);


        return layout.getRoot();
    }
}
