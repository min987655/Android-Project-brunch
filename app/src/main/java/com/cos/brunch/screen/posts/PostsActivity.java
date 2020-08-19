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

import com.cos.brunch.R;
import com.cos.brunch.adapter.PostsAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private static final String TAG = "PostsActivity";
    private Context mContext = PostsActivity.this;
    private PostsAdapter postsAdapter;
    private RecyclerView rvPostsContent;

    private MainViewModel mainViewModel;

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

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // 콜백함수 : 컬랙션을 덮어 씌움
        mainViewModel.구독하기().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다.");
                postsAdapter.setPosts(posts);
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
//        postsAdapter.setOnItemClickListener(new PostsAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Intent intent = new Intent(mContext, PostActivity.class);
//                startActivity(intent);
//            }
//        });
    }


}