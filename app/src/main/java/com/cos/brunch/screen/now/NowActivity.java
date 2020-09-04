package com.cos.brunch.screen.now;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import com.cos.brunch.model.Tag;
import com.cos.brunch.model.User;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.screen.posts.PostsActivity;
import com.cos.brunch.screen.search.SearchActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        keywordAdapter.addTag(new Tag(1, 1, 1, "지구한바퀴세계여행"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "그림·웹툰"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "시사·이슈"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "IT트렌트"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "사진·촬영"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "취향저격영화 리뷰"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "오늘은 이런 책"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "뮤직 인사이드"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "글쓰기 코치"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "직장인 현실 조언"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "스타트업 경험담"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "육아이야기"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "요리·레시피"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "건강·운동"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "멘탈 관리 심리 탐구"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "디자인 스토리"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "문화·예술"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "건축·설계"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "인문학·철학"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "쉽게 읽는 역사"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "우리집 반려동물"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "멋진 캘리그래피"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "사랑·이별"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "감성 에세이"));
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

        Map<String, Object> headerJwtToken = new HashMap<>();
        headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

        NavigationView navigationView = findViewById(R.id.nav);

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getLoginUser(headerJwtToken, navigationView, mContext);

        NavigationViewHelper.enableNavigation(mContext, navigationView, serverJwtToken);

    }
}