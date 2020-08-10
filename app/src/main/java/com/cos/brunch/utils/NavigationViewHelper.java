package com.cos.brunch.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.apply.ApplyActivity;
import com.cos.brunch.main.MainActivity;
import com.cos.brunch.now.NowActivity;
import com.cos.brunch.user.UserActivity;
import com.cos.brunch.write.WriteActivity;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enableNavigation(final Context context, NavigationView view) {

        NavigationView nav;
        View navHeader;
        TextView navHome, navWrite, navDrawer, navNow, navBookcase, navFeed;
        ImageView navProfile, navSettings;
        Button navApply;


        nav = view.findViewById(R.id.nav);
        navHeader = nav.getHeaderView(0);
        navHome = navHeader.findViewById(R.id.tv_home);
        navProfile = navHeader.findViewById(R.id.img_profile);
//        navApply = navHeader.findViewById(R.id.btn_apply);
        navWrite = navHeader.findViewById(R.id.btn_write);
        navDrawer = navHeader.findViewById(R.id.tv_drawer);
        navNow = navHeader.findViewById(R.id.tv_now);
//        navBookcase = navHeader.findViewById(R.id.tv_bookcase);
        navFeed = navHeader.findViewById(R.id.tv_feed);
        navSettings = navHeader.findViewById(R.id.iv_settings);


        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                context.startActivity(intent);
            }
        });

//        navApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ApplyActivity.class);
//                context.startActivity(intent);
//            }
//        });

        navWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WriteActivity.class);
                context.startActivity(intent);
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
                Intent intent = new Intent(context, NowActivity.class);
                context.startActivity(intent);
            }
        });

//        navBookcase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
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