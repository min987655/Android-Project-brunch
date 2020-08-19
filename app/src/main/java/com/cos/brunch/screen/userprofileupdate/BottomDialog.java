package com.cos.brunch.screen.userprofileupdate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cos.brunch.R;
import com.cos.brunch.screen.userprofileupdate.UserProfileUpdateActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

// BottomDialog 커스텀
public class BottomDialog extends BottomSheetDialogFragment {

    private static final String TAG = "BottomDialog";
    private TextView tvProfileUpdate, tvCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View dialogView = inflater.inflate(R.layout.layout_bottom_dialog, container, false);

        tvProfileUpdate = dialogView.findViewById(R.id.tv_user_profile_update);
        tvCancel = dialogView.findViewById(R.id.tv_cancel);

        tvProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + tvProfileUpdate);
                Intent intent = new Intent(dialogView.getContext(), UserProfileUpdateActivity.class);
                startActivity(intent);
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismiss();
            }
        });
        return dialogView;
    }

}
