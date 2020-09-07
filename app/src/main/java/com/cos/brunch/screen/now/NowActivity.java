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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.now.ApplyHorizontal1Adapter;
import com.cos.brunch.adapter.now.ApplyHorizontal2Adapter;
import com.cos.brunch.adapter.now.KeywordAdapter;
import com.cos.brunch.adapter.now.PostHorizontal1Adapter;
import com.cos.brunch.adapter.now.PostHorizontal2Adapter;
import com.cos.brunch.adapter.now.PostHorizontal3Adapter;
import com.cos.brunch.adapter.now.PostHorizontal4Adapter;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.Tag;
import com.cos.brunch.model.User;
import com.cos.brunch.repository.UserRepository;
import com.cos.brunch.screen.apply.ApplyActivity;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.screen.posts.PostsActivity;
import com.cos.brunch.screen.search.SearchActivity;
import com.cos.brunch.utils.NavigationViewHelper;
import com.cos.brunch.viewmodel.PostsViewModel;
import com.cos.brunch.viewmodel.UsersViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NowActivity extends AppCompatActivity {

    private static final String TAG = "NowActivity";
    private Context mContext = NowActivity.this;
    private RecyclerView rvKeyword, rvNowPost1, rvNowPost2, rvNowPost3, rvNowPost4, rvNowUser1, rvNowUser2;
    private KeywordAdapter keywordAdapter;
    private PostHorizontal1Adapter postHorizontal1Adapter;
    private PostHorizontal2Adapter postHorizontal2Adapter;
    private PostHorizontal3Adapter postHorizontal3Adapter;
    private PostHorizontal4Adapter postHorizontal4Adapter;
    private ApplyHorizontal1Adapter applyHorizontal1Adapter;
    private ApplyHorizontal2Adapter applyHorizontal2Adapter;
    private PostsViewModel postsViewModel;
    private UsersViewModel usersViewModel;

    private DrawerLayout drawerLayout;
    private ImageView imgMenu, imgSearch, ivNowPosts;
    private TextView tvToolbarHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        initObject();
        initDesign();
        initTagData();
        initPostData();
        initUserData();
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

        ivNowPosts = findViewById(R.id.iv_now_posts);
    }

    private void initDesign() {
        drawerLayout = findViewById(R.id.drawer);
        rvKeyword = findViewById(R.id.rv_now_toolbar_keyword);
        rvNowPost1 = findViewById(R.id.rv_now_post_1);
        rvNowPost2 = findViewById(R.id.rv_now_post_2);
        rvNowPost3 = findViewById(R.id.rv_now_post_3);
        rvNowPost4 = findViewById(R.id.rv_now_post_4);
        rvNowUser1 = findViewById(R.id.rv_now_apply_1);
        rvNowUser2 = findViewById(R.id.rv_now_apply_2);
    }

    private void initTagData() {
        keywordAdapter = new KeywordAdapter();
        keywordAdapter.addTag(new Tag(1, 1, 1, "지구한바퀴세계여행"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "그림·웹툰"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "시사·이슈"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "IT                 트렌트"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "사진·촬영"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "취향저격    영화 리뷰"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "오늘은        이런 책"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "뮤직            인사이드"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "글쓰기         코치"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "직장인        현실 조언"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "스타트업    경험담"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "육아            이야기"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "요리·레시피"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "건강·운동"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "멘탈 관리   심리 탐구"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "디자인        스토리"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "문화·예술"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "건축·설계"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "인문학        철학"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "쉽게 읽는   역사"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "우리집        반려동물"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "멋진            캘리그래피"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "사랑·이별"));
        keywordAdapter.addTag(new Tag(1, 1, 1, "감성            에세이"));
        rvKeyword.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        rvKeyword.scrollToPosition(keywordAdapter.getItemCount() - 1);
        rvKeyword.setAdapter(keywordAdapter);
    }

    private void initPostData() {
        postHorizontal1Adapter = new PostHorizontal1Adapter();
        rvNowPost1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowPost1.scrollToPosition(postHorizontal1Adapter.getItemCount() - 1);
        rvNowPost1.setAdapter(postHorizontal1Adapter);

        postsViewModel = new ViewModelProvider(NowActivity.this).get(PostsViewModel.class);
        postsViewModel.PostByTagDto구독하기().observe(NowActivity.this, new Observer<List<PostByTagRespDto>>() {
            @Override
            public void onChanged(List<PostByTagRespDto> postByTagRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + postByTagRespDtos);
                postHorizontal1Adapter.setPostByTagRespDto(postByTagRespDtos);
            }
        });

        postHorizontal2Adapter = new PostHorizontal2Adapter();
        rvNowPost2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowPost2.scrollToPosition(postHorizontal2Adapter.getItemCount() - 1);
        rvNowPost2.setAdapter(postHorizontal2Adapter);

        postsViewModel.PostByTagDto구독하기().observe(NowActivity.this, new Observer<List<PostByTagRespDto>>() {
            @Override
            public void onChanged(List<PostByTagRespDto> postByTagRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + postByTagRespDtos);
                postHorizontal2Adapter.setPostByTagRespDto(postByTagRespDtos);
            }
        });

        postHorizontal3Adapter = new PostHorizontal3Adapter();
        rvNowPost3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowPost3.scrollToPosition(postHorizontal3Adapter.getItemCount() - 1);
        rvNowPost3.setAdapter(postHorizontal3Adapter);

        postsViewModel.PostByTagDto구독하기().observe(NowActivity.this, new Observer<List<PostByTagRespDto>>() {
            @Override
            public void onChanged(List<PostByTagRespDto> postByTagRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + postByTagRespDtos);
                postHorizontal3Adapter.setPostByTagRespDto(postByTagRespDtos);
            }
        });

        postHorizontal4Adapter = new PostHorizontal4Adapter();
        rvNowPost4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowPost4.scrollToPosition(postHorizontal4Adapter.getItemCount() - 1);
        rvNowPost4.setAdapter(postHorizontal4Adapter);

        postsViewModel.PostByTagDto구독하기().observe(NowActivity.this, new Observer<List<PostByTagRespDto>>() {
            @Override
            public void onChanged(List<PostByTagRespDto> postByTagRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + postByTagRespDtos);
                postHorizontal4Adapter.setPostByTagRespDto(postByTagRespDtos);
            }
        });
    }

    private void initUserData() {
        applyHorizontal1Adapter = new ApplyHorizontal1Adapter();
        rvNowUser1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowUser1.scrollToPosition(applyHorizontal1Adapter.getItemCount() - 1);
        rvNowUser1.setAdapter(applyHorizontal1Adapter);

        usersViewModel = new ViewModelProvider(NowActivity.this).get(UsersViewModel.class);
        usersViewModel.allUser구독하기().observe(NowActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + users);
                applyHorizontal1Adapter.setUser(users);
            }
        });

        applyHorizontal2Adapter = new ApplyHorizontal2Adapter();
        rvNowUser2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowUser2.scrollToPosition(applyHorizontal2Adapter.getItemCount() - 1);
        rvNowUser2.setAdapter(applyHorizontal2Adapter);

        usersViewModel.allUser구독하기().observe(NowActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + users);
                applyHorizontal2Adapter.setUser(users);
            }
        });

    }

    private void initlistener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        postHorizontal2Adapter.setOnClickListener(new PostHorizontal2Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(mContext, DetailPostActivity.class);
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

        applyHorizontal1Adapter.setOnClickListener(new ApplyHorizontal1Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(mContext, ApplyActivity.class);
                startActivity(intent);
            }
        });

        ivNowPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        SharedPreferences sf = getSharedPreferences("test", MODE_PRIVATE);
        String serverJwtToken = sf.getString("jwtToken", "");

        Map<String, Object> headerJwtToken = new HashMap<>();
        headerJwtToken.put("Authorization", "Bearer " + serverJwtToken);
        Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

        NavigationView navigationView = findViewById(R.id.nav);

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getLoginUser(headerJwtToken, navigationView, mContext);

        NavigationViewHelper.enableNavigation(mContext, navigationView, serverJwtToken);

    }
}