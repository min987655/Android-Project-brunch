package com.cos.brunch.screen.feed;

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
import com.cos.brunch.adapter.apply.ApplyTap1Adapter;
import com.cos.brunch.adapter.feed.FeedTap1Adapter;
import com.cos.brunch.model.Post;
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

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvFeedContent1.setLayoutManager(layoutManager);
        rvFeedContent1.setAdapter(feedTap1Adapter);

        return v;
    }

    private void init(View v){
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvFeedContent1 = v.findViewById(R.id.rv_feed_content1);
        feedTap1Adapter = new FeedTap1Adapter();
    }

    private void initData(){
        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);

                feedTap1Adapter.setPosts(posts);

            }
        });
    }
}
