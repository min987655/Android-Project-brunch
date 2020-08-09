package com.cos.brunch.now;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentHorizontal2Adapter extends RecyclerView.Adapter<ContentHorizontal2Adapter.MyViewHolder> {

    private static final String TAG = "ContentHorizontalAdapter";
    private List<Post> posts;

    public ContentHorizontal2Adapter(List<Post> posts) {
        this.posts = posts;
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_now_content_content_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.setItem(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgNowContentCover;
        private TextView tvNowContentTitle, tvNowApplyNickname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNowContentCover = itemView.findViewById(R.id.img_now_content_cover);
            tvNowContentTitle = itemView.findViewById(R.id.tv_now_content_title);
            tvNowApplyNickname = itemView.findViewById(R.id.tv_now_apply_nickname);
        }

        public void setItem(Post post) {
            imgNowContentCover.setImageResource(R.drawable.img_cover);
            tvNowContentTitle.setText("꿈이 꼭 있어야할까.");
            tvNowApplyNickname.setText("닉네임");
        }
    }

}
