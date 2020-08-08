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
import com.cos.brunch.model.User;
import com.cos.brunch.user.BottomDialog;
import com.cos.brunch.userProfile.UserProfileUpdateActivity;
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
        rvNowContent = findViewById(R.id.rv_now_content);
    }

    private void initData() {
        keywordAdapter = new KeywordAdapter();
        keywordAdapter.addPost(new Post("지구한바퀴세계여행"));
        keywordAdapter.addPost(new Post("그림·웹툰"));
        keywordAdapter.addPost(new Post("시사·이슈"));
        keywordAdapter.addPost(new Post("IT트렌드"));
        keywordAdapter.addPost(new Post("사진·촬영"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰1"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰2"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰3"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰4"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰4"));
        keywordAdapter.addPost(new Post("취향저격영화리뷰5"));
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

        List<User> user4 = new ArrayList<>();
        user4.add(new User(R.drawable.img_apply_profile1, "작가1"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가2"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가3"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가4"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가5"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가6"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가7"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가8"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가9"));
        user4.add(new User(R.drawable.img_apply_profile1, "작가10"));
        allUsers.add(user4);

        List<User> user5 = new ArrayList<>();
        user5.add(new User(R.drawable.img_apply_profile2, "작가11"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가12"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가13"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가14"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가15"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가16"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가17"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가18"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가19"));
        user5.add(new User(R.drawable.img_apply_profile2, "작가20"));
        allUsers.add(user5);

        List<User> user6 = new ArrayList<>();
        user6.add(new User(R.drawable.img_apply_profile3, "작가21"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가22"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가23"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가24"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가25"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가26"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가27"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가28"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가29"));
        user6.add(new User(R.drawable.img_apply_profile3, "작가30"));
        allUsers.add(user6);
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