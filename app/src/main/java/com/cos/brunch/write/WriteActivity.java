package com.cos.brunch.write;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.posts.PostsActivity;
import com.cos.brunch.user.UserActivity;
import com.cos.brunch.userProfile.UserProfileUpdateActivity;

public class WriteActivity extends AppCompatActivity {

    private static final String TAG = "WriteActivity";
    private Context mContext = WriteActivity.this;

    private ImageView imgCancel, imgWriteUpdate;
    private TextView tvToolbarHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        initData();
        initObject();
        initlistener();
    }

    private void initData() {
    }

    private void initObject() {
        imgCancel = findViewById(R.id.img_toolbar_l);
        tvToolbarHeader = findViewById(R.id.tv_toolbar_header);
        tvToolbarHeader.setText("글쓰기");
        imgWriteUpdate = findViewById(R.id.img_toolbar_r);
    }

    private void initlistener() {

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 저장중 알림창 떠야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        imgWriteUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });
    }
}