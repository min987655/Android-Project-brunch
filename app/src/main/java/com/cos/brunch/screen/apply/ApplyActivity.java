package com.cos.brunch.screen.apply;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cos.brunch.R;
import com.cos.brunch.adapter.apply.ApplyFragmentAdapter;
import com.cos.brunch.adapter.apply.ApplyTap1Adapter;
import com.cos.brunch.adapter.apply.ApplyTap2Adapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ApplyActivity extends AppCompatActivity {

    private static final String TAG = "ApplyActivity";
    private Context mContext = ApplyActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgApplyMenu;

    private ViewPager viewPager;
    private ApplyFragmentAdapter applyAdapter;

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
        imgApplyMenu = findViewById(R.id.img_apply_menu);
        applyAdapter = new ApplyFragmentAdapter(getSupportFragmentManager(), 1);
        applyfrag1 = new ApplyFrag1();
        applyfrag2 = new ApplyFrag2();
        tabLayout = findViewById(R.id.tabs_apply);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);

        applyAdapter.addFragment(applyfrag1);
        applyAdapter.addFragment(applyfrag2);

        viewPager.setAdapter(applyAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("저장글");
        tabLayout.getTabAt(1).setText("발행취소글");

        imgApplyMenu.setImageResource(R.drawable.img_menu);
    }

    private void initData() {
    }

    private void initlistener() {
        imgApplyMenu.setOnClickListener(new View.OnClickListener() {
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