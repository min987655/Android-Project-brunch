package com.cos.brunch.screen.apply;

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
import com.cos.brunch.adapter.cabinet.CabinetFragmentAdapter;
import com.cos.brunch.screen.cabinet.CabinetActivity;
import com.cos.brunch.screen.cabinet.CabinetFrag1;
import com.cos.brunch.screen.cabinet.CabinetFrag2;
import com.google.android.material.tabs.TabLayout;

public class ApplyActivity extends AppCompatActivity {

    private static final String TAG = "ApplyActivity";
    private Context mContext = ApplyActivity.this;

//    private DrawerLayout drawerLayout;
    private ImageView imgMenu;

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
    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_toolbar_l);
        applyAdapter = new ApplyFragmentAdapter(getSupportFragmentManager(), 1);
        applyfrag1 = new ApplyFrag1();
        applyfrag2 = new ApplyFrag2();
        tabLayout = findViewById(R.id.tabs);
    }

    private void initDesign() {
//        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);

        applyAdapter.addFragment(applyfrag1);
        applyAdapter.addFragment(applyfrag2);

        viewPager.setAdapter(applyAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("작가소개");
        tabLayout.getTabAt(1).setText("글 "+"5");

        imgMenu.setImageResource(R.drawable.img_back_b);
    }

    private void initData() {
    }

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}