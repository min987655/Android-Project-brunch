package com.cos.brunch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

// BottomDialog 커스텀
// https://codinginflow.com/tutorials/android/modal-bottom-sheet
public class BottomDialog extends BottomSheetDialogFragment {

    private TextView tvProfileUpdate, tvCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog, container, false);

        tvProfileUpdate = view.findViewById(R.id.tv_user_profile_update);
        tvCancel = view.findViewById(R.id.tv_cancel);

        tvProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(this, )
            }
        });

        return view;
    }

}
