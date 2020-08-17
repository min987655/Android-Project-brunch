package com.cos.brunch.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.PostsAdapter;

public class PostsActivity extends AppCompatActivity {

    private static final String TAG = "PostsActivity";
    private Context mContext = PostsActivity.this;
    private PostsAdapter postsAdapter;
    private RecyclerView rvPostsContent;

    private ImageView imgBack, imgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        initObject();
        initDesign();
        initData();
        initlistener();
    }

    private void initObject() {
        imgBack = findViewById(R.id.img_toolbar_l);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgBack.setImageDrawable(getDrawable(R.drawable.img_back_b));
        imgSearch.setImageDrawable(getDrawable(R.drawable.img_search));
    }

    private void initDesign() {
        rvPostsContent = findViewById(R.id.rv_posts_content);
    }

    private void initData() {
        postsAdapter = new PostsAdapter();
//        postsAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_apply_profile3, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));

        rvPostsContent.setLayoutManager(new LinearLayoutManager(this));
        rvPostsContent.setAdapter(postsAdapter);
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NowActivity.class);
                startActivity(intent);
            }
        });

        postsAdapter.setOnItemClickListener(new PostsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext, PostActivity.class);
                startActivity(intent);
            }
        });
    }
}