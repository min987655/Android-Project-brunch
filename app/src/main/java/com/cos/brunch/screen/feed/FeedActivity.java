package com.cos.brunch.screen.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.apply.ApplyFragmentAdapter;
import com.cos.brunch.adapter.feed.FeedFragmentAdapter;
import com.cos.brunch.screen.apply.ApplyActivity;
import com.cos.brunch.screen.apply.ApplyFrag1;
import com.cos.brunch.screen.apply.ApplyFrag2;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class FeedActivity extends AppCompatActivity {

    private static final String TAG = "FeedActivity";
    private Context mContext = FeedActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgFeedMenu, imgFeedSearch;

    private ViewPager viewPager;
    private FeedFragmentAdapter feedAdapter;

    private FeedFrag1 feedfrag1;
    private FeedFrag2 feedfrag2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initObject();
        initDesign();
        initData();
        initlistener();
        setupNavigationView();
    }

    private void initObject() {
        imgFeedMenu = findViewById(R.id.img_apply_menu);
        imgFeedSearch = findViewById(R.id.img_user_profile_dialog);
        feedAdapter = new FeedFragmentAdapter(getSupportFragmentManager(), 1);
        feedfrag1 = new FeedFrag1();
        feedfrag2 = new FeedFrag2();
        tabLayout = findViewById(R.id.tabs_apply);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);

        feedAdapter.addFragment(feedfrag1);
        feedAdapter.addFragment(feedfrag2);

        viewPager.setAdapter(feedAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("피드");
        tabLayout.getTabAt(1).setText("작가");

        imgFeedMenu.setImageResource(R.drawable.img_menu);
        imgFeedSearch.setImageResource(R.drawable.img_search);
    }

    private void initData() {
    }

    private void initlistener() {
        imgFeedMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav);
        NavigationViewHelper.enableNavigation(mContext, navigationView);
    }
}