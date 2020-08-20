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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.ApplyTap1Adapter;

public class ApplyFrag1 extends Fragment {

    private static final String TAG = "ApplyFrag1";
    private ApplyTap1Adapter applyTap1Adapter;
    private RecyclerView rvApplyContent1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1_apply, container, false);
        Log.d(TAG, "onCreateView: v : " + v);
        applyTap1Adapter = new ApplyTap1Adapter();
        rvApplyContent1.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d(TAG, "onCreateView: 실행?");
        rvApplyContent1.setAdapter(applyTap1Adapter);
        return v;
    }
}
