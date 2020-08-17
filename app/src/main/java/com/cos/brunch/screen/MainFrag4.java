package com.cos.brunch.screen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cos.brunch.R;
import com.cos.brunch.databinding.Frag1MainBinding;
import com.cos.brunch.databinding.Frag4MainBinding;

public class MainFrag4 extends Fragment {
    private static final String TAG = "MainFrag4";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.frag4_main, container, false);
//
//        TextView tvTitle1 = view.findViewById(R.id.tv_title1);
//        TextView tvTitle2 = view.findViewById(R.id.tv_title2);
//        tvTitle1.setText("동적변경1");
//        tvTitle2.setText("동적변경2");
//
//        Log.d(TAG, "MainFrag4 : onCreateView: ");
//        return view;
        Frag4MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag4_main, container, false);
        return layout.getRoot();

    }

}
