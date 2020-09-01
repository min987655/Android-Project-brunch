package com.cos.brunch.screen.apply;

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
import com.cos.brunch.adapter.apply.ApplyTap1Adapter;
import com.cos.brunch.adapter.library.LibraryTap1Adapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class ApplyFrag1 extends Fragment {

    private static final String TAG = "ApplyFrag1";
    public ApplyTap1Adapter applyTap1Adapter;
    private RecyclerView rvApplyContent1;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_apply, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvApplyContent1 = v.findViewById(R.id.rv_apply_content1);
        applyTap1Adapter = new ApplyTap1Adapter();
    }

    private void initData(){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvApplyContent1.setLayoutManager(layoutManager);
        rvApplyContent1.setAdapter(applyTap1Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

//        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
//            @Override
//            public void onChanged(List<Post> posts) {
//                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);
//                applyTap1Adapter.setPosts(posts);
//
//            }
//        });

        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+postRespDtos);
                applyTap1Adapter.setPosts(postRespDtos);
            }
        });


    }

    private void initlistener() {
        applyTap1Adapter.setOnClickListener(new ApplyTap1Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }
}
