package com.cos.brunch.screen.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.post.DetailPostAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.posts.PostsActivity;

public class DetailPostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";
    private Context mContext = DetailPostActivity.this;
    private DetailPostAdapter detailPostAdapter;
    private RecyclerView rvPostPost;

    private ImageView imgBack, imgSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

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
        detailPostAdapter = new DetailPostAdapter();
        detailPostAdapter.addPost(new Post(1,1,"1.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(2,1,"2.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(3,1,"3.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(4,1,"4.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(5,1,"5.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(6,1,"6.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(7,1,"7.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(8,1,"8.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(9,1,"9.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));
        detailPostAdapter.addPost(new Post(10,1,"10.제목", "1.소제목", "1.본문", "에세이", "ok", 0, 0, "20.08.08"));

        rvPostPost.setLayoutManager(new LinearLayoutManager(this));
        rvPostPost.setAdapter(detailPostAdapter);
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });

        detailPostAdapter.setOnItemClickListener(new DetailPostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mContext, DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }

}