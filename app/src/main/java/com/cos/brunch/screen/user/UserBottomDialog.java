package com.cos.brunch.screen.user;

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
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.screen.userprofileupdate.UserProfileUpdateActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

// BottomDialog 커스텀
public class UserBottomDialog extends BottomSheetDialogFragment {

    private static final String TAG = "UserBottomDialog";
    private TextView tvProfileUpdate, tvCancel;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View dialogView = inflater.inflate(R.layout.layout_bottom_dialog, container, false);

        initObject(dialogView);
        initListener(dialogView);

        return dialogView;
    }

    private void initObject(View dialogView) {
        tvProfileUpdate = dialogView.findViewById(R.id.tv_dialog);
        tvCancel = dialogView.findViewById(R.id.tv_dialog_cancel);
    }

    private void initListener(final View dialogView) {
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
    }
}
