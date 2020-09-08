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
import com.cos.brunch.adapter.feed.FeedTap2Adapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.screen.apply.ApplyActivity;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;
import com.cos.brunch.viewmodel.UsersViewModel;

import java.util.List;

public class FeedFrag2 extends Fragment {

    private static final String TAG = "ApplyFrag1";
    public FeedTap2Adapter feedTap2Adapter;
    private RecyclerView rvFeedContent2;
    private UsersViewModel usersViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag2_feed, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){
        usersViewModel = new ViewModelProvider(requireActivity()).get(UsersViewModel.class);
        rvFeedContent2 = v.findViewById(R.id.rv_feed_content2);
        feedTap2Adapter = new FeedTap2Adapter();
    }

    private void initData(){

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvFeedContent2.setLayoutManager(layoutManager);
        rvFeedContent2.setAdapter(feedTap2Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + usersViewModel);

        usersViewModel.allUser구독하기().observe(requireActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                feedTap2Adapter.setPostRespDtos(users);
            }
        });
    }

    private void initlistener() {
        feedTap2Adapter.setOnClickListener(new FeedTap2Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), ApplyActivity.class);
                startActivity(intent);
            }
        });
    }

}
