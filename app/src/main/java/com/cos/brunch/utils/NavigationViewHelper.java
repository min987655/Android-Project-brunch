package com.cos.brunch.utils;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
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
        navApply = navHeader.findViewById(R.id.btn_apply);
        navWrite = navHeader.findViewById(R.id.tv_write);
        navDrawer = navHeader.findViewById(R.id.tv_drawer);
        navNow = navHeader.findViewById(R.id.tv_now);
        navBookcase = navHeader.findViewById(R.id.tv_bookcase);
        navFeed = navHeader.findViewById(R.id.tv_feed);
        navSettings = navHeader.findViewById(R.id.iv_settings);
    }
}
