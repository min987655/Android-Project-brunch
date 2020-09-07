package com.cos.brunch.screen.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.cos.brunch.R;
import com.cos.brunch.adapter.main.MainFragmentAdapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.network.ServiceGenerator;
import com.cos.brunch.network.SessionCallback;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.screen.search.SearchActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private MainActivity mContext = MainActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch;

    private ViewPager2 viewPager;
    private MainFragmentAdapter mainAdapter;
    private List<PostRespDto> postRespDtos = new ArrayList<>();

    private MainFrag1 frag1;
    private MainFrag2 frag2;
    private MainFrag3 frag3;
    private MainFrag4 frag4;
    private MainFrag5 frag5;
    private MainFrag6 frag6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();
        initDesign();
        initlistener();
        setupNavigationView();
        initData();
    }

    private void initData() {
    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_menu);
        imgSearch = findViewById(R.id.img_search);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);

        viewPager = findViewById(R.id.view_pager);
        mainAdapter = new MainFragmentAdapter(this, postRespDtos);

        frag1 = new MainFrag1();
        frag2 = new MainFrag2();
        frag3 = new MainFrag3();
        frag4 = new MainFrag4();
        frag5 = new MainFrag5();
        frag6 = new MainFrag6();

        mainAdapter.addFragment(frag1);
        mainAdapter.addFragment(frag2);
        mainAdapter.addFragment(frag3);
        mainAdapter.addFragment(frag4);
        mainAdapter.addFragment(frag6);
        mainAdapter.addFragment(frag5);
        viewPager.setAdapter(mainAdapter);
    }

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);

                SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);
                String serverJwtToken = sf.getString("jwtToken", "");

                Map<String, Object> headerJwtToken = new HashMap<>();
                headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
                Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

                UserRepository userRepository = UserRepository.getInstance();
                userRepository.loginUserProfile(headerJwtToken);
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              서버 특정유저 주소값 넘기기 테스트
//                int id = 1;
//                UserRepository userRepository = UserRepository.getInstance();
//                userRepository.findById(id);

                Intent intent = new Intent(mContext, SearchActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setupNavigationView() {

        Intent intent = getIntent();
        String jwtToken = intent.getExtras().getString("jwtToken");

        Log.d(TAG, "initData: jwtToken : " + jwtToken);
        SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);
        SharedPreferences.Editor stEditor = sf.edit();
        stEditor.putString("jwtToken", jwtToken);
        stEditor.commit();

        String serverJwtToken = sf.getString("jwtToken", "");

        Map<String, Object> headerJwtToken = new HashMap<>();
        headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

        NavigationView navigationView = findViewById(R.id.nav);

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getLoginUser(headerJwtToken, navigationView, mContext);

        NavigationViewHelper.enableNavigation(mContext, navigationView, jwtToken);
    }

}