package com.cos.brunch.now;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.User;

import java.util.ArrayList;
import java.util.List;

public class ContentVerticalAdapter extends RecyclerView.Adapter<ContentVerticalAdapter.MyViewHolder> {

    private static final String TAG = "ContentVerticalAdapter";
    private List<List<User>> allUsers;
    private Context context;

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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvNowApply = itemView.findViewById(R.id.rv_now_apply);
        }
    }

}
