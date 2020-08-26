package com.cos.brunch.adapter.feed;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class FeedTap1Adapter extends RecyclerView.Adapter<FeedTap1Adapter.MyViewHolder> {

    private static OnClickListener mListener = null;
    private static final String TAG = "FeedTap1Adapter";
    private List<Post> posts = new ArrayList<>();

    public interface OnClickListener {
        void onItemClick(View v, int pos);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.mListener = listener;
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        ItemPostBinding itemPostBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_post,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemPostBinding);

    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Post currentPost = posts.get(position);
        holder.itemPostBinding.setPost(currentPost); // 오브젝트 통채로 넘기면 xml에 변수 값 알아서 찾아 들어감
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + posts.size());
        return posts.size();
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

//    public Post getPostAt(int position){
//        return posts.get(position);
//    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemPostBinding itemPostBinding;

        public MyViewHolder(@NonNull ItemPostBinding itemPostBinding) {
            super(itemPostBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemPostBinding = itemPostBinding;

            itemPostBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if(mListener!=null){
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }

}
