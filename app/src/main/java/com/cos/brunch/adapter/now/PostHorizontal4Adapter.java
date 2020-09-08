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

public class PostHorizontal4Adapter extends RecyclerView.Adapter<PostHorizontal4Adapter.MyViewHolder> {

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
        postByTagRespDtoItem.add(new PostByTagRespDto("매킨토시. 그리고 스티브 잡스 싸인","","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/SN6/image/M4UrbohEBwpS1Hv27DP4o41KPhw.jpeg","집안에 남는 아이패드 미니가 생겼고, 활용방안을 찾아보는 도중 위의 이미지를 발견하게 된다. 오래된 매킨토시 내부를 걷어내고 아이패드를 장착한 것. 이보다 올드+뉴의 완벽한 조합이 있을까? 바로 폭풍 검색을 시작했고, 몇 주후...","2020-09-03 21:30:00.000000","김글리","IT트렌드"));
        postByTagRespDtoItem.add(new PostByTagRespDto("figma, 그리고 개발자의 활용법","","https://t1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/7Wf3/image/oNTwbgJ72bfHaDfCkiYj9hxgTDE.png","케어닥에서는 figma를 통해 디자인 시스템 UI 라이브러리의 컴포넌트 추상화를 선행해 실제 코드로 구현하고 있습니다. 향 후에는 code first로 Framer X를 도입하기 위한 준비를 하고 있지만 당분간은 MVP 기능을 제외한 사용자 경험 설계와 시안이 필요한 경우에는 figma가 필요할 것 같습니다.","2020-02-25 18:10:00.000000","박다빈","IT트렌드"));
        postByTagRespDtoItem.add(new PostByTagRespDto("페이스북/인스타그램 광고 성과지표 정리","LABBIT","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/3Dfu/image/GOnlLN6xc-LY4LL0vnUEMCweHxw.jpg","광고를 집행하게 되면 광고 관리자의 왼쪽 상단에 광고 관리자를 눌러, 광고 관리자의 홈 화면으로 이동할 수 있습니다. 우리는 이 홈 화면에서 우리가 지금 집행하고 있는 다양한 광고들의 성과들을 한눈에 비교할 수 있습니다. 광고 관리자의 홈 화면으로 돌아옵니다.","2020-02-25 18:10:00.000000","혜니","IT트렌드"));
        postByTagRespDtoItem.add(new PostByTagRespDto("검색엔진 웹사이트 외부 최적화","검색엔진 외부 최적화 총정리 퍼펙트 가이드","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/aPF6/image/Lt2Z1eSw2ifGdNLq9ipL93uRMXw.jpg","구글은 구글 사용자들을 위해 구글 써치 콘솔 (Search Console) 서비스를 무료 제공한다. 이곳에서 웹사이트로 들어오는 인바운드 링크 (inbound links)들을 확인할 수 있다.","2020-05-17 21:34:00.000000","SHUN","IT트렌드"));
        postByTagRespDtoItem.add(new PostByTagRespDto("Apple 유럽에서 재생 에너지 사용 확대","Apple Energy 2030","https://t1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/wjx/image/QebS1TvY9uXiCf1zWYcBtZff1mY.jpg","Apple은 공급망 및 생산 제품의 탄소 중립화 달성에 한 발 다가서게 해 줄 청정, 재생 에너지원인 세계 최대 규모의 내륙 풍력 터빈 두 곳의 건설에 투자할 것이라고 발표했다. 덴마크의 에스비에르 부근에 위치하는 200미터 높이의 이들 터빈은 매년 2만여 가구에 전력 공급이 가능한 62기가 와트시를 생산할 예정이며 강력한 해상 풍력 터빈을 시험해보는 시험장 역할을 하게 된다.","2020-08-02 10:14:00.000000","글지이","IT트렌드"));
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
