package com.cos.brunch.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.screen.apply.ApplyActivity;
import com.cos.brunch.screen.feed.FeedActivity;
import com.cos.brunch.screen.library.LibraryActivity;
import com.cos.brunch.screen.login.LoginActivity;
import com.cos.brunch.screen.main.MainActivity;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.screen.user.UserActivity;
import com.cos.brunch.screen.write.WriteActivity;
import com.google.android.material.navigation.NavigationView;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enableNavigation(final Context context, NavigationView view) {
        NavigationView nav;
        View navHeader;
        TextView navHome, navWrite, navDrawer, navNow, navLibrary, navFeed;
        ImageView navProfile, navSettings;
        Button navApply;

        nav = view.findViewById(R.id.nav);
        navHeader = nav.getHeaderView(0);
        navHome = navHeader.findViewById(R.id.tv_home);
        navProfile = navHeader.findViewById(R.id.img_profile);
        navWrite = navHeader.findViewById(R.id.btn_write);
        navDrawer = navHeader.findViewById(R.id.tv_drawer);
        navNow = navHeader.findViewById(R.id.tv_now);
        navLibrary = navHeader.findViewById(R.id.tv_library);
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
                Intent intent = new Intent(context, ApplyActivity.class);
                context.startActivity(intent);
            }
        });

        navNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NowActivity.class);
                context.startActivity(intent);
            }
        });

        navLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LibraryActivity.class);
                context.startActivity(intent);
            }
        });

        navFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FeedActivity.class);
                context.startActivity(intent);
            }
        });

        navSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance().requestUnlink(new UnLinkResponseCallback() {
                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        Log.d(TAG, "onSessionClosed: 회원탈퇴 성공 ");
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onSuccess(Long result) {

                    }
                });
            }
        });
    }
}