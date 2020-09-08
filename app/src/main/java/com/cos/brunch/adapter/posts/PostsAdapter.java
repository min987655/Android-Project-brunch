package com.cos.brunch.adapter.posts;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.databinding.ItemPostTagBinding;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private static OnClickListener mListener = null;
    private static final String TAG = "PostsAdapter";
    private List<PostByTagRespDto> postByTagRespDtos = new ArrayList<>();

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
        ItemPostTagBinding itemPostTagBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_post_tag,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemPostTagBinding);

    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        PostByTagRespDto currentPost = postByTagRespDtos.get(position);
        holder.itemPostTagBinding.setPostByTagRespDto(currentPost); // 오브젝트 통채로 넘기면 xml에 변수 값 알아서 찾아 들어감
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + postByTagRespDtos.size());
        return postByTagRespDtos.size();
    }

    public void setPostByTagRespDto(List<PostByTagRespDto> postByTagRespDtos){
        List<PostByTagRespDto> postByTagRespDtoItem = new ArrayList<>();
        postByTagRespDtoItem.add(new PostByTagRespDto("어린이와 강아지와 집","어느날","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/3iPJ/image/PDwgaZrxak8sq8wq9ikL4Kn8CqM.jpg","오전 산책을 어쩌다 빡세게 했다. 오늘은 요술상자와 함께~ 어제와 같은 코스로 가다가 갈림길에서 다른 곳으로 가봤다. 사실 어제는 어느 정도 가다 뒤돌아 나왔는데 오늘은 그냥 가보자 싶어서 쭉 갔다.","Sep 04. 2020","길여행가","그림웹툰"));
        postByTagRespDtoItem.add(new PostByTagRespDto("여행지에서의 조식","소노문단양","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/I5V/image/ye_widPHN2ZVHflrcWqz4RaUTTI.jpg","나보다 늦게 일어나던 습관을 이기고 나를 깨운다. 아침을잘 먹지 않던 습관을 깨뜨리고 꼬박꼬박 챙겨 먹는다. 평소엔 먹지도 않던 맛없는 빵과 볶음밥, 감자튀김, 베이컨 등으로 인하여 과식을 한다. 나도 덩달아 과식한다.","Sep 07. 2020","드루","그림웹툰"));
        postByTagRespDtoItem.add(new PostByTagRespDto("딴상","오래오래","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/4Led/image/tnVeLuxFAnnqIRj2n1C5GkAyjcE.jpg","어느 날은 집에 다와 현관문 밖까지 나온 엄마와 마주쳤는데 엄마가 날 보고 깜짝 놀라 해 같이 놀랬다. 내 문자를 받고 현관문 뒤 숨으려다가 나와 마주친 것이다.","Sep 05. 2020","박다빈","그림웹툰"));
        postByTagRespDtoItem.add(new PostByTagRespDto("화장실이 깨끗한 회사가 번창한다.","일상을 빛내고 싶지만 무엇부터 해야 할지 모르는 당신에게 ","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/a6h3/image/ipzsTVRpLsNVvwOp8eJgLJ_ILH4.jpg","나의 화장실은 어땠더라. 그 길로 화장실을 청소했다. 구석구석 피어난 곰팡이와 물때를 닦아내며 곳곳에 숨어있던 초조함과 나태함도 지워낸다.","Aug 22. 2020","날숭이","그림웹툰"));
        postByTagRespDtoItem.add(new PostByTagRespDto("17년 된 샤프에 대한 단상","","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/1aBA/image/EIv5-SwZruMZJY8ux0d0xRFvYVw.JPG","마음이 불안할 때 가끔 샤프 말고 연필이 땡긴다. 매끈하게 정제된 디자인에 심 갈아 끼우면서 쓰기 쉽게 사용할 수 있는 샤프보다, 투박한 모습에 관리가 필요해 보이는 연필 한 자루에 마음이 간다. 연필 한 자루 손에 꼭 쥐고서 종이에다가 하고 싶은 말을 끄적끄적거리면 토닥토닥 마음 깊숙이 위로를 받는다.","Sep 03. 2020","허지영","그림웹툰"));
        postByTagRespDtoItem.add(new PostByTagRespDto("발레, 잡설","최근에 그랬다","https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/guest/image/lEDQTwpfvM6e5m0vQtnOYDJCF_Q.JPG","더해가는 나이는 거칠고 무겁다. 육중한 파도의 무게와 같다. 어떻게 생각해도 하나의 책이 완결한 형식인 것과 비슷한 이치다. 또 한 사람의 삶은 책과 흡사하다. 몰락의 내러티브도 있지만 수직으로 달궈지는 서사도 있다.","Sep 04. 2020","지안","감성에세이"));
        this.postByTagRespDtos = postByTagRespDtoItem;
        notifyDataSetChanged();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemPostTagBinding itemPostTagBinding;

        public MyViewHolder(@NonNull ItemPostTagBinding itemPostTagBinding) {
            super(itemPostTagBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemPostTagBinding = itemPostTagBinding;

            itemPostTagBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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
