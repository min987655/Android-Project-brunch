package com.cos.brunch.screen.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.post.DetailPostAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.posts.PostsActivity;
import com.cos.brunch.screen.reply.ReplyActivity;

public class DetailPostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";
    private Context mContext = DetailPostActivity.this;
    private DetailPostAdapter detailPostAdapter;
    private RecyclerView rvPostPost;

    private ImageView imgBack, imgSearch;
    private TextView tvReply;

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

        tvReply = findViewById(R.id.tv_post_comment_count);
        imgBack.setImageDrawable(getDrawable(R.drawable.img_back_b));
        imgSearch.setImageDrawable(null);
    }

    private void initDesign() {
        rvPostPost = findViewById(R.id.rv_post_post);
        rvPostPost.setNestedScrollingEnabled(false);
    }
    private void initData() {
        detailPostAdapter = new DetailPostAdapter();
        detailPostAdapter.addPost(new Post(1,"1.제목", "1.소제목", "1.본문", "에세이", 0, null));

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

        tvReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyActivity.class);
                startActivity(intent);
            }
        });
    }

}