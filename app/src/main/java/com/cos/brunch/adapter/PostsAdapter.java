package com.cos.brunch.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private static final String TAG = "PostsAdapter";
    private List<Post> posts = new ArrayList<>();

//    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
//    private static OnItemClickListener mListener = null;
//
//    public interface OnItemClickListener {
//        void onItemClick(View v, int position) ;
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mListener = listener ;
//    }
//
//    public void addPost(Post post) {
//        posts.add(post);
//    }

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
        holder.itemPostBinding.setPostList(currentPost); // 오브젝트 통채로 넘기면 xml에 변수 값 알아서 찾아 들어감
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

    public Post getPostAt(int position){
        return posts.get(position);
    }


    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemPostBinding itemPostBinding;

        public MyViewHolder(@NonNull ItemPostBinding itemPostBinding) {
            super(itemPostBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemPostBinding = itemPostBinding;

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d(TAG, "onClick: 아이템 클릭 됨 ");
//                    int position = getAdapterPosition() ;
//                    if (position != RecyclerView.NO_POSITION) {
//                        mListener.onItemClick(v, position);
//                    }
//                }
//            });

        }

    }

}
