package com.cos.brunch.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cos.brunch.R;
import com.cos.brunch.databinding.Frag1MainBinding;
import com.cos.brunch.databinding.Frag2MainBinding;

public class MainFrag2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Frag2MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag2_main, container, false);
        return layout.getRoot();
    }

}
