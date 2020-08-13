package com.cos.brunch.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.now.NowActivity;
import com.cos.brunch.posts.PostsActivity;
import com.cos.brunch.posts.PostsAdapter;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";
    private Context mContext = PostActivity.this;
    private PostAdapter postAdapter;
    private RecyclerView rvPostPost;

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
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));
        postAdapter.addPost(new Post("","평화로운 주말 스케치",R.drawable.img_cover, "세 달쯤 전부터 TV 리모컨의 왼쪽 방향키가 잘 눌리지 않았다. 말하자면 유튜브 메인화면에서"));

        rvPostPost.setLayoutManager(new LinearLayoutManager(this));
        rvPostPost.setAdapter(postAdapter);
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