package com.cos.brunch.screen.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.post.DetailPostAdapter;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.screen.comment.CommentActivity;
import com.cos.brunch.viewmodel.MainViewModel;
import com.cos.brunch.viewmodel.PostsViewModel;

import java.util.List;

public class DetailPostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";
    private Context mContext = DetailPostActivity.this;
    private DetailPostAdapter detailPostAdapter;
    private RecyclerView rvPostPost;
    private MainViewModel mainViewModel;

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
        rvPostPost = findViewById(R.id.rv_detail_post_item);
        rvPostPost.setNestedScrollingEnabled(false);
    }
    private void initData() {
        detailPostAdapter = new DetailPostAdapter();
        rvPostPost.setLayoutManager(new LinearLayoutManager(this));
        rvPostPost.setAdapter(detailPostAdapter);

        mainViewModel = new ViewModelProvider(DetailPostActivity.this).get(MainViewModel.class);
        mainViewModel.DTO구독하기().observe(this, new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                Log.d(TAG, "onChanged: 구독데이터 변경 완");
                detailPostAdapter.setPostRespDto(postRespDtos);
            }
        });
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                Intent intent = new Intent(mContext, CommentActivity.class);
                startActivity(intent);
            }
        });
    }

}