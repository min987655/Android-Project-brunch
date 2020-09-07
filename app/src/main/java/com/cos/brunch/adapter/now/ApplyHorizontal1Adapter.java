package com.cos.brunch.adapter.now;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemNowApplyHorizontalBinding;
import com.cos.brunch.databinding.ItemNowPostHorizontalBinding;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.model.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ApplyHorizontal1Adapter extends RecyclerView.Adapter<ApplyHorizontal1Adapter.MyViewHolder> {

    private static final String TAG = "ApplyHorizontal1Adapter";
    private static OnClickListener mListener = null;
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
        ItemNowApplyHorizontalBinding itemNowApplyHorizontalBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_now_apply_horizontal,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemNowApplyHorizontalBinding);
    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.itemNowApplyHorizontalBinding.setUser(currentUser);
    }

    public void setUser(List<User> users){
        List<User> UserItem = new ArrayList<>();
        UserItem.add(users.get(18));
        UserItem.add(users.get(15));
        UserItem.add(users.get(3));
        UserItem.add(users.get(14));
        UserItem.add(users.get(11));
        UserItem.add(users.get(6));
        UserItem.add(users.get(17));
        UserItem.add(users.get(8));
        UserItem.add(users.get(10));
        UserItem.add(users.get(15));
        UserItem.add(users.get(7));
        UserItem.add(users.get(2));
        this.users = UserItem;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemNowApplyHorizontalBinding itemNowApplyHorizontalBinding;

        public MyViewHolder(@NonNull ItemNowApplyHorizontalBinding itemNowApplyHorizontalBinding) {
            super(itemNowApplyHorizontalBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemNowApplyHorizontalBinding = itemNowApplyHorizontalBinding;

            itemNowApplyHorizontalBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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

