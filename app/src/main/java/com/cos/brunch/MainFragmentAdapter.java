package com.cos.brunch;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends FragmentStateAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    // 오브젝트 데이터 (배열)

    public MainFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    // FragmentList에 아이템 추가하는 함수 필요
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    // 프레그먼트에서 뷰 찾는법 확인하여 타이틀에 뿌리기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!(오류남 !!!!!!)
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 3번일 떄만 2개로
        // 나머지는 그대로
        View v = fragmentList.get(position).getView();
        if(position == 3){
            TextView tvTitle1 = v.findViewById(R.id.tv_title);
            TextView tvTitle2 = v.findViewById(R.id.tv_title2);
            tvTitle1.setText("동적변경1");
            tvTitle2.setText("동적변경2");
        }
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
