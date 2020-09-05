package com.cos.brunch.screen.posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cos.brunch.R;
import com.cos.brunch.adapter.posts.PostsAdapter;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;
import com.cos.brunch.viewmodel.PostsViewModel;

import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private static final String TAG = "PostsActivity";
    private Context mContext = PostsActivity.this;
    private PostsAdapter postsAdapter;
    private RecyclerView rvPostsContent;

    private MainViewModel mainViewModel;

    private PostsViewModel postsViewModel;

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

        rvPostsContent.setLayoutManager(new LinearLayoutManager(this));
        rvPostsContent.setAdapter(postsAdapter);

//        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);

        postsViewModel.PostByTagDto구독하기().observe(this, new Observer<List<PostByTagRespDto>>() {
            @Override
            public void onChanged(List<PostByTagRespDto> postByTagRespDtos) {
                Log.d(TAG, "onChanged: 구독데이터 변경 완");
                postsAdapter.setPostByTagRespDto(postByTagRespDtos);
            }
        });
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NowActivity.class);
                startActivity(intent);
            }
        });

        postsAdapter.setOnClickListener(new PostsAdapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(mContext, DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }
}