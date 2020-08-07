package com.cos.brunch.now;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.user.BottomDialog;
import com.cos.brunch.userProfile.UserProfileUpdateActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class NowActivity extends AppCompatActivity {

    private static final String TAG = "NowActivity";
    private Context mContext = NowActivity.this;
    private RecyclerView rvKeyword;
    private KeywordAdapter adapter;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch;
    private TextView toolbarHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        initObject();
        initDesign();
        initData();
        initlistener();
        setupNavigationView();
    }

    private void initData() {
        adapter = new KeywordAdapter();
        Log.d(TAG, "initData: ");

        adapter.addPost(new Post("지구한바퀴세계여행"));
        adapter.addPost(new Post("그림·웹툰"));
        adapter.addPost(new Post("시사·이슈"));
        adapter.addPost(new Post("IT트렌드"));
        adapter.addPost(new Post("사진·촬영"));
        adapter.addPost(new Post("취향저격영화리뷰"));
        adapter.addPost(new Post("취향저격영화리뷰1"));
        adapter.addPost(new Post("취향저격영화리뷰2"));
        adapter.addPost(new Post("취향저격영화리뷰3"));
        adapter.addPost(new Post("취향저격영화리뷰4"));
        adapter.addPost(new Post("취향저격영화리뷰4"));
        adapter.addPost(new Post("취향저격영화리뷰5"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true);
//        rvKeyword.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        rvKeyword.setLayoutManager(layoutManager);

        rvKeyword.scrollToPosition(adapter.getItemCount()-1);
        rvKeyword.setAdapter(adapter);

    }

    private void initObject() {
        imgMenu = findViewById(R.id.img_toolbar_l);
        toolbarHeader = findViewById(R.id.tv_toolbar_header);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgMenu.setImageDrawable(getDrawable(R.drawable.img_menu_w));
        toolbarHeader.setText("브런치 나우");
        toolbarHeader.setTextColor(Color.WHITE);
        imgSearch.setImageDrawable(getDrawable(R.drawable.img_search_w));
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        rvKeyword = findViewById(R.id.rv_now_toolbar_keyword);
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