package com.cos.brunch.screen.now;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.now.ContentVerticalAdapter;
import com.cos.brunch.adapter.now.KeywordAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.screen.posts.PostsActivity;
import com.cos.brunch.screen.search.SearchActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class NowActivity extends AppCompatActivity {

    private static final String TAG = "NowActivity";
    private Context mContext = NowActivity.this;
    private RecyclerView rvKeyword, rvNowContent;
    private KeywordAdapter keywordAdapter;
    private ContentVerticalAdapter contentVerticalAdapter;
    private List<List<User>> allUsers = new ArrayList<>();
    private List<List<Post>> allPosts = new ArrayList<>();

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch;
    private TextView tvToolbarHeader;

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

    private void initObject() {
        imgMenu = findViewById(R.id.img_toolbar_l);
        tvToolbarHeader = findViewById(R.id.tv_toolbar_header);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgMenu.setImageDrawable(getDrawable(R.drawable.img_menu_w));
        tvToolbarHeader.setText("브런치 나우");
        tvToolbarHeader.setTextColor(Color.WHITE);
        imgSearch.setImageDrawable(getDrawable(R.drawable.img_search_w));
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        rvKeyword = findViewById(R.id.rv_now_toolbar_keyword);
        rvNowContent = findViewById(R.id.rv_now_content);
    }

    private void initData() {
        keywordAdapter = new KeywordAdapter();
//        keywordAdapter.addPost(new Post("그림·웹툰"));
        rvKeyword.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        rvKeyword.scrollToPosition(keywordAdapter.getItemCount()-1);
        rvKeyword.setAdapter(keywordAdapter);

        contentVerticalAdapter = new ContentVerticalAdapter(allUsers, this);
        rvNowContent.setHasFixedSize(true);
        rvNowContent.setLayoutManager(new LinearLayoutManager(this));
        rvNowContent.setAdapter(contentVerticalAdapter);

        List<User> user1 = new ArrayList<>();
        allUsers.add(user1);

        List<User> user2 = new ArrayList<>();
        allUsers.add(user2);

        List<User> user3 = new ArrayList<>();
        allUsers.add(user3);
    }

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        contentVerticalAdapter.setOnItemClickListener(new ContentVerticalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });

        keywordAdapter.setOnItemClickListener(new KeywordAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupNavigationView() {

        SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);
        String serverJwtToken = sf.getString("jwtToken", "");

        NavigationView navigationView = findViewById(R.id.nav);
        NavigationViewHelper.enableNavigation(mContext, navigationView, serverJwtToken);

    }
}