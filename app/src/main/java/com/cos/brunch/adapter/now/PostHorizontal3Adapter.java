package com.cos.brunch.adapter.now;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.databinding.ItemNowPostHorizontalBinding;
import com.cos.brunch.dto.PostByTagRespDto;

import java.util.ArrayList;
import java.util.List;

public class PostHorizontal3Adapter extends RecyclerView.Adapter<PostHorizontal3Adapter.MyViewHolder> {

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
        postByTagRespDtoItem.add(new PostByTagRespDto("'파워풀'과 '초격차' 사이","인사, 조직문화 이야기","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/5DJL/image/4T1Id6kfvSL5Vo8GtW7Zjvj47vA.jpg","실리콘밸리의 스타트업 문화를 상징하는 '파워풀'과 국내를 넘어 글로벌 시장을 리딩 하는 거대기업 삼성전자의 조직문화와 인사전략을 대변하는 '초격차' 사이.","2020-09-03 21:30:00.000000","오영은","스타트업경험담"));
        postByTagRespDtoItem.add(new PostByTagRespDto("비영리법인계의 테슬라","Technology NPO","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/77aN/image/H9beZhPxcXehkSzkArH2Aq5xKVk.jpg","처음엔 이렇게 많고 다양한 사람들이 오로지 온라인 서비스만을 통해 마치 오프라인에서 만나듯 여러 가지를 할 수 있다는 점이 신기했지만, 시간이 지날수록 점점 따라가기가 벅차기 시작했다.  20대, 30대 초반의 에너지 넘치는 친구들을 따라가지 못한 것도 있지만, 새롭게 배워야 하는 소프트웨어도 많았고 생전 처음 듣는 약어도 난무해 정신적인 체력이 금세 고갈되어 버렸다.","2020-02-25 18:10:00.000000","요니킴","스타트업경험담"));
        postByTagRespDtoItem.add(new PostByTagRespDto("서비스 기획 체크리스트","가치를 제공하는 서비스를 만들기 위한 여정 첫걸음","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/10tg/image/BD5eszIBJ1Z7ASzN9fjvzJG-RNM.jpg","설문을 의례적인 과제로 생각하는 분들이 많습니다. 작성자의 실력에 따라 향후 마케팅에 활용할 수도 있는 엄청난 데이터를 확보할 수도 있으니, 설문은 특별히 더 고민하여 무엇을 검증하여 어떻게 활용할 수 있는지 깊이 고민해볼 필요가 있습니다. 원하는 답을 얻기 위해선 질문이 명확해야 합니다.","2020-02-25 18:10:00.000000","단보","스타트업경험담"));
        postByTagRespDtoItem.add(new PostByTagRespDto("Day 1의 의미","고객중심의 기업, 아마존","https://t1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/9mJY/image/bYHugskxrTyykcaHbqkbWmJN11g.png","아마존의 플라이 휠을 보면, 이 회사는 고객 경험이 가져다주는 이익을 장기적인 관점에서 이해한 회사라고 생각할 수밖에 없다. 지금 이 순간의 고객이 느끼는 감정이 결국은 다음 주, 다음 달, 내년도에도 우리 서비스를 이용하게 만들 수 있느냐의 유무를 결정한다는 것을 창업 초기부터 지금까지 이해하고 있고, 실행하고 있는 기업이라는 생각을 이 책을 통해 알게 되었던 것 같다.","2020-05-17 21:34:00.000000","푸샵","스타트업경험담"));
        postByTagRespDtoItem.add(new PostByTagRespDto("프라이싱","","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/8yii/image/cRT2G-rHNwfE6zIyRPm2jOcY3z8.jpg","예전에 단순하게 똑똑한 기업이라면 고객이 아닌 다른 곳에서 수익을 낼 수 있지 않을까 생각했었다. 고객이 많아지면 굳이 서비스 비용을 높이지 않고 다른 채널로 매출을 올리고 고객에게는 저렴하게 서비스를 제공하는. 그럼 누이 좋고 매부 좋고일 것 같은데 언제나 어떻게가 문제지.","2020-08-02 10:14:00.000000","최예슬","스타트업경험담"));
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
