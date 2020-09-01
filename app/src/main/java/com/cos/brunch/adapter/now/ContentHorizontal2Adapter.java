package com.cos.brunch.adapter.now;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;

import java.util.List;

public class ContentHorizontal2Adapter extends RecyclerView.Adapter<ContentHorizontal2Adapter.MyViewHolder> {

    private static final String TAG = "ContentHorizontalAdapter";
    private List<Post> posts;
    private List<PostRespDto> postRespDtos;

    public ContentHorizontal2Adapter(List<PostRespDto> postRespDtos) {
        this.postRespDtos = postRespDtos;
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
        PostRespDto postRespDto = postRespDtos.get(position);
        holder.setItem(postRespDto);
    }

    @Override
    public int getItemCount() {
        return postRespDtos.size();
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

        public void setItem(PostRespDto postRespDto) {
            imgNowContentCover.setImageResource(R.drawable.img_cover);
            tvNowContentTitle.setText("꿈이 꼭 있어야할까.");
            tvNowApplyNickname.setText("닉네임");
        }
    }

}
