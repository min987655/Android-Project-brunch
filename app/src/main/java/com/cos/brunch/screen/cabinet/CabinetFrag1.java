package com.cos.brunch.screen.cabinet;

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
import com.cos.brunch.adapter.cabinet.CabinetTap1Adapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.CabinetViewModel;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class CabinetFrag1 extends Fragment {

    private static final String TAG = "CabinetFrag1";
    public CabinetTap1Adapter cabinetTap1Adapter;
    private RecyclerView rvCabinetContent1;
    private CabinetViewModel cabinetViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_cabinet, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){
        cabinetViewModel = new ViewModelProvider(requireActivity()).get(CabinetViewModel.class);
        rvCabinetContent1 = v.findViewById(R.id.rv_cabinet_content1);
        cabinetTap1Adapter = new CabinetTap1Adapter();
    }

    private void initData(){

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvCabinetContent1.setLayoutManager(layoutManager);
        rvCabinetContent1.setAdapter(cabinetTap1Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + cabinetViewModel);

        cabinetViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);
                cabinetTap1Adapter.setPost(posts);
            }
        });

//        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
//            @Override
//            public void onChanged(List<Post> posts) {
//                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);
//
//                cabinetTap1Adapter.setPosts(posts);
//
//            }
//        });
    }

    private void initlistener() {
        cabinetTap1Adapter.setOnClickListener(new CabinetTap1Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }
}
