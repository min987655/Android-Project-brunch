package com.cos.brunch.adapter.now;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.MyViewHolder> {

    private static final String TAG = "KeywordAdapter";
    private List<Tag> tags = new ArrayList<>();

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    private static OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    // 껍데기 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_now_keyword_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    // 껍데기에 데이터 바인등
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tag tag = tags.get(position);
        Log.d(TAG, "onBindViewHolder: " + tag);
        holder.setItem(tag);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + tags.size());
        return tags.size();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private Button btnKeyword;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnKeyword = itemView.findViewById(R.id.btn_keyword);
            Log.d(TAG, "MyViewHolder: " + btnKeyword.toString());

            btnKeyword.setOnClickListener(new View.OnClickListener() {
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

        public void setItem(Tag tag) {
            Log.d(TAG, "setItem: ");
            btnKeyword.setText(tag.getTag());
        }
    }

}
