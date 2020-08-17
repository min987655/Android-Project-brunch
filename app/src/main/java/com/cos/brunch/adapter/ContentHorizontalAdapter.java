package com.cos.brunch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentHorizontalAdapter extends RecyclerView.Adapter<ContentHorizontalAdapter.MyViewHolder> {

    private static final String TAG = "ContentHorizontalAdapter";
    private List<User> users;

    public ContentHorizontalAdapter(List<User> users) {
        this.users = users;
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_now_content_apply_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);
        holder.setItem(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imgApplyNickname;
        private TextView tvApplyNickname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgApplyNickname = itemView.findViewById(R.id.img_apply_profile);
            tvApplyNickname = itemView.findViewById(R.id.tv_apply_nickname);
        }

        public void setItem(User user) {
            imgApplyNickname.setImageResource(user.getProfileImg());
            tvApplyNickname.setText(user.getNickName());
        }
    }

}
