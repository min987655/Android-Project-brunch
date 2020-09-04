package com.cos.brunch.screen.cabinet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.cos.brunch.R;
import com.cos.brunch.adapter.cabinet.CabinetFragmentAdapter;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

public class CabinetActivity extends AppCompatActivity {

    private static final String TAG = "CabinetActivity";
    private Context mContext = CabinetActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu;

    private ViewPager viewPager;
    private CabinetFragmentAdapter cabinetAdapter;

    private CabinetFrag1 cabinetfrag1;
    private CabinetFrag2 cabinetfrag2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);

        initObject();
        initDesign();
        initData();
        initlistener();
        setupNavigationView();
    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_apply_menu);
        cabinetAdapter = new CabinetFragmentAdapter(getSupportFragmentManager(), 1);
        cabinetfrag1 = new CabinetFrag1();
        cabinetfrag2 = new CabinetFrag2();
        tabLayout = findViewById(R.id.tabs);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);

        cabinetAdapter.addFragment(cabinetfrag1);
        cabinetAdapter.addFragment(cabinetfrag2);

        viewPager.setAdapter(cabinetAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("저장글");
        tabLayout.getTabAt(1).setText("발행취소글");

        imgMenu.setImageResource(R.drawable.img_menu);
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

        SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);
        String serverJwtToken = sf.getString("jwtToken", "");

        Map<String, Object> headerJwtToken = new HashMap<>();
        headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

        NavigationView navigationView = findViewById(R.id.nav);

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getLoginUser(headerJwtToken, navigationView, mContext);

        NavigationViewHelper.enableNavigation(mContext, navigationView, serverJwtToken);


    }
}