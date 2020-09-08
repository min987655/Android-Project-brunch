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
import com.cos.brunch.adapter.cabinet.CabinetTap2Adapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class CabinetFrag2 extends Fragment {

    private static final String TAG = "ApplyFrag2";
    public CabinetTap2Adapter cabinetTap2Adapter;
    private RecyclerView rvCabinetContent2;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2_cabinet, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v) {
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvCabinetContent2 = v.findViewById(R.id.rv_cabinet_content2);
        cabinetTap2Adapter = new CabinetTap2Adapter();
    }

    private void initData() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvCabinetContent2.setLayoutManager(layoutManager);
        rvCabinetContent2.setAdapter(cabinetTap2Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                cabinetTap2Adapter.setPostRespDtos(postRespDtos);
            }
        });
    }

    private void initlistener() {
        cabinetTap2Adapter.setOnClickListener(new CabinetTap2Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }

}
