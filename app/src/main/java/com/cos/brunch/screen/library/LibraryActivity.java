package com.cos.brunch.screen.library;

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
import com.cos.brunch.adapter.library.LibraryFragmentAdapter;
import com.cos.brunch.screen.apply.ApplyActivity;
import com.cos.brunch.screen.apply.ApplyFrag1;
import com.cos.brunch.screen.apply.ApplyFrag2;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class LibraryActivity extends AppCompatActivity {

    private static final String TAG = "LibraryActivity";
    private Context mContext = LibraryActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgLibraryMenu, imgLibrarySearch;

    private ViewPager viewPager;
    private LibraryFragmentAdapter libraryAdapter;

    private LibraryFrag1 libraryFrag1;
    private LibraryFrag2 libraryFrag2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initObject();
        initDesign();
        initData();
        initlistener();
        setupNavigationView();
    }
    private void initObject() {
        imgLibraryMenu = findViewById(R.id.img_toolbar_l);
        imgLibrarySearch = findViewById(R.id.img_toolbar_r);
        libraryAdapter = new LibraryFragmentAdapter(getSupportFragmentManager(), 1);
        libraryFrag1 = new LibraryFrag1();
        libraryFrag2 = new LibraryFrag2();
        tabLayout = findViewById(R.id.tabs_library);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);

        libraryAdapter.addFragment(libraryFrag1);
        libraryAdapter.addFragment(libraryFrag2);

        viewPager.setAdapter(libraryAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("최근 본");
        tabLayout.getTabAt(1).setText("라이킷");

        imgLibraryMenu.setImageResource(R.drawable.img_menu);
        imgLibrarySearch.setImageResource(R.drawable.img_search);
    }

    private void initData() {
    }

    private void initlistener() {
        imgLibraryMenu.setOnClickListener(new View.OnClickListener() {
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