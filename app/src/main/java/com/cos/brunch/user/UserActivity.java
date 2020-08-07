package com.cos.brunch.user;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.cos.brunch.R;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";
    private Context mContext = UserActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgProfileUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        initData();
        initObject();
        initDesign();
        initlistener();
        setupNavigationView();
    }

    private void initData() {
    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_menu);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        imgProfileUpdate = findViewById(R.id.img_user_profile_dialog);
    }


    private void initlistener() {
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
    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav);
        NavigationViewHelper.enableNavigation(mContext, navigationView);

    }
}