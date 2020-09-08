package com.cos.brunch.adapter.feed;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemFeedApplyBinding;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

import java.util.ArrayList;
import java.util.List;

public class FeedTap2Adapter extends RecyclerView.Adapter<FeedTap2Adapter.MyViewHolder> {

    private static OnClickListener mListener = null;
    private static final String TAG = "FeedTap2Adapter";
    private List<User> users = new ArrayList<>();

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
        ItemFeedApplyBinding itemFeedApplyBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_feed_apply,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemFeedApplyBinding);

    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        User currentUser = users.get(position);
        holder.itemFeedApplyBinding.setUser(currentUser); // 오브젝트 통채로 넘기면 xml에 변수 값 알아서 찾아 들어감
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + users.size());
        return users.size()-75;
    }

    public void setPostRespDtos(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemFeedApplyBinding itemFeedApplyBinding;

        public MyViewHolder(@NonNull ItemFeedApplyBinding itemFeedApplyBinding) {
            super(itemFeedApplyBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemFeedApplyBinding = itemFeedApplyBinding;

            itemFeedApplyBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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
