package com.cos.brunch.now;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.User;
import com.cos.brunch.posts.PostsActivity;

import java.util.ArrayList;
import java.util.List;

public class ContentVerticalAdapter extends RecyclerView.Adapter<ContentVerticalAdapter.MyViewHolder> {

    private static final String TAG = "ContentVerticalAdapter";
    private List<List<User>> allUsers;
    private Context context;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    private static OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public ContentVerticalAdapter(List<List<User>> allUsers, Context context) {
        this.allUsers = allUsers;
        this.context = context;
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_now_content_vertical, parent, false);
        return new MyViewHolder(view);
    }

    // 껍데기에 데이터 바인드
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ContentHorizontalAdapter contentHorizontalAdapter = new ContentHorizontalAdapter(allUsers.get(position));

        holder.rvNowApply.setHasFixedSize(true);
        holder.rvNowApply.setLayoutManager(new LinearLayoutManager(context
                , LinearLayoutManager.HORIZONTAL
                ,false));
        holder.rvNowApply.setAdapter(contentHorizontalAdapter);
    }

    @Override
    public int getItemCount() {
        return allUsers.size();
    }


    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView rvNowApply;
        private TextView tvNowApplyKeyword;
        private RelativeLayout nowApplyMore, nowContentMore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nowContentMore = itemView.findViewById(R.id.now_content_more);
            rvNowApply = itemView.findViewById(R.id.rv_now_apply);
            tvNowApplyKeyword =itemView.findViewById(R.id.tv_now_apply_keyword);
            tvNowApplyKeyword.setText("그림·웹툰");

            nowContentMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(v, position);
                    }
                }
            });

        }

    }

}
