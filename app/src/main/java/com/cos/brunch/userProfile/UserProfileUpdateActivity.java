package com.cos.brunch.userProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.user.UserActivity;

public class UserProfileUpdateActivity extends AppCompatActivity {

    private static final String TAG = "UserProfileUpdateActivi";
    private Context mContext = UserProfileUpdateActivity.this;

    private ImageView imgCancel, imgProfileUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_update);

        init();
        listener();
    }

    private void init() {
        imgCancel = findViewById(R.id.img_toolbar_l);
        imgProfileUpdate = findViewById(R.id.img_toolbar_r);
    }

    private void listener() {

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });

        // 저장중 알림창 뜸 !
        imgProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}