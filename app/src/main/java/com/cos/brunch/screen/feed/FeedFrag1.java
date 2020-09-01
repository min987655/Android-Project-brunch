package com.cos.brunch.screen.feed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.feed.FeedTap1Adapter;
import com.cos.brunch.adapter.library.LibraryTap1Adapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class FeedFrag1 extends Fragment {

    private static final String TAG = "ApplyFrag1";
    public FeedTap1Adapter feedTap1Adapter;
    private RecyclerView rvFeedContent1;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_feed, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvFeedContent1 = v.findViewById(R.id.rv_feed_content1);
        feedTap1Adapter = new FeedTap1Adapter();
    }

    private void initData(){

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvFeedContent1.setLayoutManager(layoutManager);
        rvFeedContent1.setAdapter(feedTap1Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);


        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                feedTap1Adapter.setPosts(postRespDtos);
            }
        });
    }

    private void initlistener() {
        feedTap1Adapter.setOnClickListener(new FeedTap1Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }

}
