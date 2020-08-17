package com.cos.brunch.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;

public class UserProfileUpdateActivity extends AppCompatActivity {

    private static final String TAG = "UserProfileUpdateActivity";
    private Context mContext = UserProfileUpdateActivity.this;

    private ImageView imgCancel, imgProfileUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_update);

        initData();
        initObject();
        initlistener();
    }

    private void initData() {
    }

    private void initObject() {
        imgCancel = findViewById(R.id.img_toolbar_l);
        imgProfileUpdate = findViewById(R.id.img_toolbar_r);
    }

    private void initlistener() {

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });

        // 저장중 알림창 떠야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        imgProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}