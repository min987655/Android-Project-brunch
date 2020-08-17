package com.cos.brunch.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.PostAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";
    private Context mContext = PostActivity.this;
    private PostAdapter postAdapter;
    private RecyclerView rvPostPost;

    private MainViewModel mainViewModel;

    private ImageView imgBack, imgSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        initObject();
        initDesign();
        initData();
        initlistener();
    }

    private void initObject() {
        imgBack = findViewById(R.id.img_toolbar_l);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgBack.setImageDrawable(getDrawable(R.drawable.img_back_b));
        imgSearch.setImageDrawable(null);
    }

    private void initDesign() {
        rvPostPost = findViewById(R.id.rv_post_post);
        rvPostPost.setNestedScrollingEnabled(false);
    }

    private void initData() {
        postAdapter = new PostAdapter();
//        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));

        rvPostPost.setLayoutManager(new LinearLayoutManager(this));
        rvPostPost.setAdapter(postAdapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // 콜백함수 : 컬랙션을 덮어 씌움
        mainViewModel.구독하기().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다.");
                postAdapter.setPosts(posts);
            }
        });
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });

        postAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext, PostActivity.class);
                startActivity(intent);
            }
        });
    }
}