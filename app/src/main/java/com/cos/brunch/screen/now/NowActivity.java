package com.cos.brunch.screen.now;

import android.content.Context;
import android.content.Intent;
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
        user1.add(new User(R.drawable.img_apply_profile1, "작가1"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가2"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가3"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가4"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가5"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가6"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가7"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가8"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가9"));
        user1.add(new User(R.drawable.img_apply_profile1, "작가10"));
        allUsers.add(user1);

        List<User> user2 = new ArrayList<>();
        user2.add(new User(R.drawable.img_apply_profile2, "작가11"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가12"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가13"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가14"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가15"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가16"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가17"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가18"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가19"));
        user2.add(new User(R.drawable.img_apply_profile2, "작가20"));
        allUsers.add(user2);

        List<User> user3 = new ArrayList<>();
        user3.add(new User(R.drawable.img_apply_profile3, "작가21"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가22"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가23"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가24"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가25"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가26"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가27"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가28"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가29"));
        user3.add(new User(R.drawable.img_apply_profile3, "작가30"));
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
    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav);
        NavigationViewHelper.enableNavigation(mContext, navigationView);

    }
}