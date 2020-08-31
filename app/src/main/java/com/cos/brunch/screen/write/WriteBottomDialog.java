package com.cos.brunch.screen.write;

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
import com.cos.brunch.screen.cabinet.CabinetActivity;
import com.cos.brunch.utils.DialogCallBack;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

// BottomDialog 커스텀
public class WriteBottomDialog extends BottomSheetDialogFragment {

    private static final String TAG = "WriteBottomDialog";
    private TextView tvWrite, tvCancel;
    private DialogCallBack dialogCallBack;

    public WriteBottomDialog() {
    }

    // 커스텀 인터페이스, DialogCallBack 사용을 위한 생성자
    public WriteBottomDialog(DialogCallBack dialogCallBack) {
        this.dialogCallBack = dialogCallBack;
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.layout_bottom_dialog, container, false);

        Log.d(TAG, "onCreateView: 실행됨");
        initObject(v);
        initListener(v);

        return v;
    }

    private void initObject(View v) {
        tvWrite = v.findViewById(R.id.tv_dialog);
        tvWrite.setText("발행");
        tvCancel = v.findViewById(R.id.tv_dialog_cancel);
    }

    private void initListener(final View v) {
        tvWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 클릭됨 ");

                // 커스텀한 WriteActivity의 onClick
                dialogCallBack.onClick();

                Intent intent = new Intent(v.getContext(), CabinetActivity.class);
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
