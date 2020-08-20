package com.cos.brunch.screen.apply;

import android.os.Bundle;
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
import com.cos.brunch.adapter.ApplyTap2Adapter;

public class ApplyFrag2 extends Fragment {

    private ApplyTap2Adapter applyTap2Adapter;
    private RecyclerView rvApplyContent2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2_apply, container, false);
        applyTap2Adapter = new ApplyTap2Adapter();
        rvApplyContent2.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvApplyContent2.setAdapter(applyTap2Adapter);
        return v;
    }
}
