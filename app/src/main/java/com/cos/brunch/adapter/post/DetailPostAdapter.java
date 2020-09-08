package com.cos.brunch.adapter.post;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.posts.PostsAdapter;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.databinding.ItemPostDetailBinding;
import com.cos.brunch.databinding.ItemPostTagBinding;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DetailPostAdapter extends RecyclerView.Adapter<DetailPostAdapter.MyViewHolder> {

    private static final String TAG = "PostAdapter";
    private List<PostRespDto> postRespDtos = new ArrayList<>();

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    private static OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        ItemPostDetailBinding itemPostDetailBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_post_detail,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemPostDetailBinding);
    }

    // 껍데기에 데이터 바인등
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        PostRespDto currentPostRespDto = postRespDtos.get(position);
        Log.d(TAG, "onBindViewHolder: " + currentPostRespDto);
        holder.itemPostDetailBinding.setPostRespDto(currentPostRespDto);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + postRespDtos.size());
        return postRespDtos.size();
    }

    public void setPostRespDto(List<PostRespDto> postRespDtos){
        List<PostRespDto> postRespDtoItem = new ArrayList<>();
        postRespDtoItem.add(postRespDtos.get(5));
        postRespDtoItem.add(postRespDtos.get(3));
        postRespDtoItem.add(postRespDtos.get(10));
        postRespDtoItem.add(postRespDtos.get(13));
        this.postRespDtos = postRespDtoItem;
        notifyDataSetChanged();
    }


    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemPostDetailBinding itemPostDetailBinding;

        public MyViewHolder(@NonNull ItemPostDetailBinding itemPostDetailBinding) {
            super(itemPostDetailBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemPostDetailBinding = itemPostDetailBinding;

            itemPostDetailBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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
