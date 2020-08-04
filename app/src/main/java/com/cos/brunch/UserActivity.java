package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";
    private Context mContext = UserActivity.this;

    private NavigationView nav;
    private View navHeader;
    private TextView navHome;
    private ImageView navProfile;

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
        nav = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.drawer);
        navHeader = nav.getHeaderView(0);
        navHome = navHeader.findViewById(R.id.tv_home);
        navProfile = navHeader.findViewById(R.id.img_profile);

        imgMenu = findViewById(R.id.img_menu);
        imgProfileUpdate = findViewById(R.id.img_user_profile_update);
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

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}