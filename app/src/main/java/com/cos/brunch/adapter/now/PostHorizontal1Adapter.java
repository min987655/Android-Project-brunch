package com.cos.brunch.adapter.now;

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
import com.cos.brunch.adapter.library.LibraryTap1Adapter;
import com.cos.brunch.databinding.ItemNowPostHorizontalBinding;
import com.cos.brunch.databinding.ItemPostBinding;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostHorizontal1Adapter extends RecyclerView.Adapter<PostHorizontal1Adapter.MyViewHolder> {

    private static final String TAG = "PostHorizontal1Adapter";
    private static OnClickListener mListener = null;
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
        ItemNowPostHorizontalBinding itemNowPostHorizontalBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_now_post_horizontal,
                parent, // 뷰그룹(해당 프로젝트에서는 리사이클러뷰)
                false
        );
        return new MyViewHolder(itemNowPostHorizontalBinding);
    }

    // 껍데기에 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        PostByTagRespDto currentPostByTagRespDto = postByTagRespDtos.get(position);
        holder.itemNowPostHorizontalBinding.setPostByTagRespDto(currentPostByTagRespDto);
    }

    @Override
    public int getItemCount() {
        return postByTagRespDtos.size();
    }

    public void setPostByTagRespDto(List<PostByTagRespDto> postByTagRespDtos){
        List<PostByTagRespDto> postByTagRespDtoItem = new ArrayList<>();
        postByTagRespDtoItem.add(new PostByTagRespDto("지구 질풍노도","September 2020","http://t1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/guest/image/SP_X8k9KoZF6meldK9LlYHw_kQ8.png","더해가는 나이는 거칠고 무겁다. 육중한 파도의 무게와 같다. 어떻게 생각해도 하나의 책이 완결한 형식인 것과 비슷한 이치다. 또 한 사람의 삶은 책과 흡사하다. 몰락의 내러티브도 있지만 수직으로 달궈지는 서사도 있다.","2020-05-17 21:34:00.000000","박다빈","감성에세이"));
        postByTagRespDtoItem.add(new PostByTagRespDto("어른스러운 사람","상처받지 않는 사람이 아니라 상처를 티 내지 않는 사람","http://t1.daumcdn.net/brunch/service/user/9eoA/image/Vu1bPRHryjeUWkHHqRGzfCnghek.jpg","이번에도 언제나 그렇듯이 단호하게 이별을 맞이했지만 왠지 마음이 명쾌하지는 않았다. 헤어져야 한다는 사실은 명확했지만 대체 우리가 왜 헤어지는지에 대한 답이 여전히 의뭉스러웠기 때문이었다. 표면적인 이유는 내가 너무 어른스러운 탓에 그가 공연히 부렸던 심술이 화근이었다. 맘에도 없는 행동들이 맘 같지 않은 결과를 만든 것이다. 그렇다고 해서 다시 헤어짐을 무를 것도 아니었다. 내 입 밖으로 헤어짐이 나온 순간 단 한 번도 그 결과를 뒤집어본 적이 없는 나였으니까. 필연적으로 맞이하는 모든 이별 앞에 이토록 단호해지는 것은 그만큼 고민이 길었다는 것과 함께 내가 어른스러운 사람임을 마지막까지 증명해 보이는 과정이었다","2020-08-02 10:14:00.000000","허지영","감성에세이"));
//        postByTagRespDtoItem.add(postByTagRespDtos.get(0));
        postByTagRespDtoItem.add(new PostByTagRespDto("훌륭한 시는 아직 쓰여지지 않았다.","감성 에세이","http://t1.daumcdn.net/brunch/service/guest/image/AFMSkyRmdHcJBTnL6LjCKCwK8TE.JPG","더해가는 나이는 거칠고 무겁다. 육중한 파도의 무게와 같다. 어떻게 생각해도 하나의 책이 완결한 형식인 것과 비슷한 이치다. 또 한 사람의 삶은 책과 흡사하다. 몰락의 내러티브도 있지만 수직으로 달궈지는 서사도 있다.","2020-09-03 21:30:00.000000","지안","감성에세이"));
        postByTagRespDtoItem.add(new PostByTagRespDto("젊다는 것은 어떤 의미인가","자기성찰 에세이","http://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/3gjW/image/S1_Ta9uPcd-Vf-8VumTVaPrzvAA.JPG","학창 시절 나는 달리기를 지지리도 못하는 아이였다. 선두팀 주자였는데 뛰다 보면 후발팀 주자가 되어 있는 경우도 여러 번이었을 정도니. 아이러니하게도 자신하는 종목은 오래달리기였다. 오래달리기는 속도전이 아니었다. 끝까지 페이스가 무너지지 않도록 하는 것. 승인은 거기에 있었다.","2020-02-25 18:10:00.000000","드루","감성에세이"));

        this.postByTagRespDtos = postByTagRespDtoItem;
        notifyDataSetChanged();
    }

    // 인플레이터된 데이터 들어갈 뷰홀더
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemNowPostHorizontalBinding itemNowPostHorizontalBinding;

        public MyViewHolder(@NonNull ItemNowPostHorizontalBinding itemNowPostHorizontalBinding) {
            super(itemNowPostHorizontalBinding.getRoot()); // view. 부모에게 view를 넘겨줌
            this.itemNowPostHorizontalBinding = itemNowPostHorizontalBinding;

            itemNowPostHorizontalBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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
