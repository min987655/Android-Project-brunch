package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this;

    private NavigationView nav;
    private View navHeader;
    private TextView navHome, navWrite, navDrawer, navNow, navBookcase, navFeed;
    private ImageView navProfile, navSettings;
    private Button navApply;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch;

    private ViewPager2 viewPager;
    private MainFragmentAdapter mainAdapter;

    private MainFrag1 frag1;
    private MainFrag2 frag2;
    private MainFrag3 frag3;
    private MainFrag4 frag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listener();
    }

    private void init() {

        drawerLayout = findViewById(R.id.drawer);
        imgMenu = findViewById(R.id.img_menu);

        nav = findViewById(R.id.nav);
        navHeader = nav.getHeaderView(0);
        navHome = navHeader.findViewById(R.id.tv_home);
        navProfile = navHeader.findViewById(R.id.img_profile);
        navApply = navHeader.findViewById(R.id.btn_apply);
        navWrite = navHeader.findViewById(R.id.tv_write);
        navDrawer = navHeader.findViewById(R.id.tv_drawer);
        navNow = navHeader.findViewById(R.id.tv_now);
        navBookcase = navHeader.findViewById(R.id.tv_bookcase);
        navFeed = navHeader.findViewById(R.id.tv_feed);
        navSettings = navHeader.findViewById(R.id.iv_settings);

        viewPager = findViewById(R.id.view_pager);
        mainAdapter = new MainFragmentAdapter(this);

        frag1 = new MainFrag1();
        frag2 = new MainFrag2();
        frag3 = new MainFrag3();
        frag4 = new MainFrag4();

        mainAdapter.addFragment(frag1);
        mainAdapter.addFragment(frag2);
        mainAdapter.addFragment(frag3);
        mainAdapter.addFragment(frag4);

        viewPager.setAdapter(mainAdapter);

    }

    private void listener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
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

        navApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ApplyActivity.class);
                startActivity(intent);
            }
        });

        navWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        navDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        navNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        navBookcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        navFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        navSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}