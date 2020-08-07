package com.cos.brunch.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.apply.ApplyActivity;
import com.cos.brunch.R;
import com.cos.brunch.user.UserActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this;

//    private NavigationView nav;
//    private View navHeader;
//    private TextView navHome, navWrite, navDrawer, navNow, navBookcase, navFeed;
//    private ImageView navProfile, navSettings;
//    private Button navApply;

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

    private void initDesign(){
        drawerLayout = findViewById(R.id.drawer);

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

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
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

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav);
        NavigationViewHelper.enableNavigation(mContext, navigationView);

    }
}