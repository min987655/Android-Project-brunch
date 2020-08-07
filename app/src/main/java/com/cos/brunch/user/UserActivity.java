package com.cos.brunch.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.apply.ApplyActivity;
import com.cos.brunch.R;
import com.cos.brunch.main.MainActivity;
import com.google.android.material.navigation.NavigationView;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";
    private Context mContext = UserActivity.this;

//    private NavigationView nav;
//    private View navHeader;
//    private TextView navHome, navWrite, navDrawer, navNow, navBookcase, navFeed;
//    private ImageView navProfile, navSettings;
//    private Button navApply;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgProfileUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        init();
        listener();
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawer);
        imgMenu = findViewById(R.id.img_menu);
        imgProfileUpdate = findViewById(R.id.img_user_profile_dialog);

//        nav = findViewById(R.id.nav);
//        navHeader = nav.getHeaderView(0);
//        navHome = navHeader.findViewById(R.id.tv_home);
//        navProfile = navHeader.findViewById(R.id.img_profile);
//        navApply = navHeader.findViewById(R.id.btn_apply);
//        navWrite = navHeader.findViewById(R.id.tv_write);
//        navDrawer = navHeader.findViewById(R.id.tv_drawer);
//        navNow = navHeader.findViewById(R.id.tv_now);
//        navBookcase = navHeader.findViewById(R.id.tv_bookcase);
//        navFeed = navHeader.findViewById(R.id.tv_feed);
//        navSettings = navHeader.findViewById(R.id.iv_settings);

    }

    private void listener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        imgProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog bottomDialog = new BottomDialog();
                bottomDialog.show(getSupportFragmentManager(), "bottomDialog");
            }
        });

//        navHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: ");
//                Intent intent = new Intent(mContext, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        navProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, UserActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        navApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, ApplyActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        navWrite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        navDrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        navNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        navBookcase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//        navFeed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        navSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
    }
}