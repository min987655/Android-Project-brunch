package com.cos.brunch.screen.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.cos.brunch.R;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.screen.write.WriteActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";
    private Context mContext = UserActivity.this;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgProfileUpdate;
    private Button btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initData();
        initObject();
        initDesign();
        initlistener();
        setupNavigationView();
    }

    private void initData() {
    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_toolbar_l);
        btnWrite = findViewById(R.id.btn_write);
        imgProfileUpdate = findViewById(R.id.img_toolbar_r);

        imgMenu.setImageDrawable(getDrawable(R.drawable.img_menu));
        imgProfileUpdate.setImageDrawable(getDrawable(R.drawable.img_more));
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
    }


    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        imgProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBottomDialog bottomDialog = new UserBottomDialog();
                bottomDialog.show(getSupportFragmentManager(), "bottomDialog");
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WriteActivity.class);
                startActivity(intent);
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
        userRepository.getLoginUser(headerJwtToken, navigationView);

        NavigationViewHelper.enableNavigation(mContext, navigationView, serverJwtToken);

    }
}