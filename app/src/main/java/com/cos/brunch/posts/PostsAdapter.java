package com.cos.brunch.posts;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private static final String TAG = "PostsAdapter";
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_post, parent, false);
        return new MyViewHolder(view);
    }

    // 껍데기에 데이터 바인등
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post post = posts.get(position);
        Log.d(TAG, "onBindViewHolder: " + post);
        holder.setItem(post);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + posts.size());
        return posts.size();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPostTitle, tvPostContent;
        private ImageView ivPostCover;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostTitle = itemView.findViewById(R.id.tv_post_title);
            tvPostContent = itemView.findViewById(R.id.tv_post_content);
            ivPostCover = itemView.findViewById(R.id.iv_post_cover);
        }

        public void setItem(Post post) {
            Log.d(TAG, "setItem: ");
            tvPostTitle.setText(post.getTitle());
            tvPostContent.setText(post.getContent());
            ivPostCover.setImageResource(post.getCoverImg());
        }
    }

}
