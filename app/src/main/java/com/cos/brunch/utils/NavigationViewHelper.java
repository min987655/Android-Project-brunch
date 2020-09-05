package com.cos.brunch.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.screen.cabinet.CabinetActivity;
import com.cos.brunch.screen.feed.FeedActivity;
import com.cos.brunch.screen.library.LibraryActivity;
import com.cos.brunch.screen.login.LoginActivity;
import com.cos.brunch.screen.main.MainActivity;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.screen.user.UserActivity;
import com.cos.brunch.screen.write.WriteActivity;
import com.google.android.material.navigation.NavigationView;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import java.util.HashMap;
import java.util.Map;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enableNavigation(final Context context, NavigationView view, final String jwtToken) {
        NavigationView nav;
        View navHeader;
        TextView navHome, navWrite, navCabinet, navNow, navLibrary, navFeed;
        ImageView navProfile;
        Button navLogout;

        Log.d(TAG, "enableNavigation: " + jwtToken);

        nav = view.findViewById(R.id.nav);
        navHeader = nav.getHeaderView(0);
        navHome = navHeader.findViewById(R.id.tv_home);
        navProfile = navHeader.findViewById(R.id.img_profile_header);
        navWrite = navHeader.findViewById(R.id.btn_write);
        navCabinet = navHeader.findViewById(R.id.tv_cabinet);
        navNow = navHeader.findViewById(R.id.tv_now);
        navLibrary = navHeader.findViewById(R.id.tv_library);
        navFeed = navHeader.findViewById(R.id.tv_feed);
        navLogout = navHeader.findViewById(R.id.btn_logout);

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WriteActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navCabinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CabinetActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NowActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LibraryActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FeedActivity.class);
                intent.putExtra("jwtToken", jwtToken);
                context.startActivity(intent);
            }
        });

        navLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        Log.d(TAG, "onCompleteLogout: 로그아웃 성공 ! ");
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
        });

        // 카카오 회원탈퇴(카카오개발자에서도 사라짐)
//        navSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserManagement.getInstance().requestUnlink(new UnLinkResponseCallback() {
//                    @Override
//                    public void onSessionClosed(ErrorResult errorResult) {
//                        Log.d(TAG, "onSessionClosed: 회원탈퇴 성공 ");
//                        Intent intent = new Intent(context, LoginActivity.class);
//                        intent.putExtra("jwtToken", jwtToken);
//                        context.startActivity(intent);
//                    }
//
//                    @Override
//                    public void onSuccess(Long result) {
//
//                    }
//                });
//            }
//        });
    }
}