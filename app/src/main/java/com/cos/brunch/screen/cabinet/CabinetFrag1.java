package com.cos.brunch.screen.cabinet;

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
import com.cos.brunch.model.Post;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class CabinetFrag1 extends Fragment {

    private static final String TAG = "ApplyFrag1";
    public CabinetTap1Adapter cabinetTap1Adapter;
    private RecyclerView rvApplyContent1;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_apply, container, false);

        init(v);
        initData();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvApplyContent1.setLayoutManager(layoutManager);
        rvApplyContent1.setAdapter(cabinetTap1Adapter);

        return v;
    }

    private void init(View v){
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvApplyContent1 = v.findViewById(R.id.rv_apply_content1);
        cabinetTap1Adapter = new CabinetTap1Adapter();
    }

    private void initData(){
        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);

                cabinetTap1Adapter.setPosts(posts);

            }
        });
    }
}
