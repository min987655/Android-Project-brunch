package com.cos.brunch.screen.reply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;

public class ReplyActivity extends AppCompatActivity {

    private static final String TAG = "ReplyActivity";
    private Context mContext = ReplyActivity.this;
    private ImageView imgCancel;
    private TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        initObject();
        initDesign();
        initListener();
    }

    private void initObject(){
        imgCancel = findViewById(R.id.img_toolbar_l);
        imgCancel.setImageResource(R.drawable.img_cancel);

        tvHeader =findViewById(R.id.tv_toolbar_header);
        tvHeader.setText("댓글");
    }

    private void initDesign(){

    }

    private void initListener(){
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}