package com.cos.brunch.screen.apply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.ApplyFragmentAdapter;
import com.cos.brunch.adapter.ApplyTap1Adapter;
import com.cos.brunch.adapter.ApplyTap2Adapter;
import com.cos.brunch.adapter.MainFragmentAdapter;
import com.cos.brunch.adapter.PostsAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.main.MainFrag1;
import com.cos.brunch.screen.main.MainFrag2;
import com.cos.brunch.screen.main.MainFrag3;
import com.cos.brunch.screen.main.MainFrag4;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ApplyActivity extends AppCompatActivity {

    private static final String TAG = "ApplyActivity";
    private Context mContext = ApplyActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu;

    private ViewPager2 viewPager;
    private ApplyFragmentAdapter applyAdapter;
    private List<Post> posts = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    private ApplyTap2Adapter applyTap2Adapter;

    private ApplyFrag1 applyfrag1;
    private ApplyFrag2 applyfrag2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        initObject();
        initDesign();
        initData();
        initlistener();
        setupNavigationView();

    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_menu);
        applyAdapter = new ApplyFragmentAdapter(this, fragmentList);
        applyTap2Adapter = new ApplyTap2Adapter();
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);

        viewPager = findViewById(R.id.view_pager);

        applyfrag1 = new ApplyFrag1();
        applyfrag2 = new ApplyFrag2();

        applyAdapter.addFragment(applyfrag1);
        applyAdapter.addFragment(applyfrag2);

        viewPager.setAdapter(applyAdapter);

//        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Tab1");
        tabLayout.getTabAt(1).setText("Tab2");
    }

    private void initData() {
    }

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
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