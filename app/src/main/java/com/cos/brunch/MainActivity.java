package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private Context mContext = MainActivity.this;
    private ViewPager2 viewPager;
    private MainFragmentAdapter mainAdapter;

    private NavigationView nav;
    private DrawerLayout drawerLayout;
    private ImageView imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listener();
    }

    private void init() {
        nav = findViewById(R.id.nav);
        imgMenu = findViewById(R.id.img_menu);
        drawerLayout = findViewById(R.id.drawer);

        viewPager = findViewById(R.id.view_pager);
        mainAdapter = new MainFragmentAdapter(this);

        mainAdapter.addFragment(new MainFrag1());
        mainAdapter.addFragment(new MainFrag2());
        mainAdapter.addFragment(new MainFrag3());

        viewPager.setAdapter(mainAdapter);
    }

    private void listener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

}