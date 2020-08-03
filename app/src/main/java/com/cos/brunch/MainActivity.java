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

    private MainFrag1 frag1;
    private MainFrag2 frag2;
    private MainFrag3 frag3;
    private MainFrag4 frag4;

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

        frag1 = new MainFrag1();
        frag2 = new MainFrag2();
        frag3 = new MainFrag3();
        frag4 = new MainFrag4();

        mainAdapter.addFragment(frag1);
        mainAdapter.addFragment(frag2);
        mainAdapter.addFragment(frag3);
        mainAdapter.addFragment(frag4);

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