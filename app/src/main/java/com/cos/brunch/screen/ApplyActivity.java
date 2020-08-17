package com.cos.brunch.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;

public class ApplyActivity extends AppCompatActivity {

    private static final String TAG = "ApplyActivity";
    private Context mContext = ApplyActivity.this;

//    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch;
    private TextView toolbarHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        initObject();
        initDesign();
        initlistener();
    }

    private void initObject() {

        imgMenu = findViewById(R.id.img_toolbar_l);
        toolbarHeader = findViewById(R.id.tv_toolbar_header);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgMenu.setImageDrawable(getDrawable(R.drawable.img_menu_w));
        toolbarHeader.setText("브런치 작가 신청");
        toolbarHeader.setTextColor(Color.WHITE);
        imgSearch.setImageDrawable(getDrawable(R.drawable.img_search_w));
    }

    private void initDesign() {

    }

    private void initlistener() {

    }
}