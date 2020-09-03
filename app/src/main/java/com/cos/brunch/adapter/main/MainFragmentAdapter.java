package com.cos.brunch.adapter.main;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.cos.brunch.R;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.feed.FeedFrag1;
import com.cos.brunch.screen.feed.FeedFrag2;
import com.cos.brunch.screen.main.MainFrag1;
import com.cos.brunch.screen.main.MainFrag2;
import com.cos.brunch.screen.main.MainFrag3;
import com.cos.brunch.screen.main.MainFrag4;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends FragmentStateAdapter {

    private static final String TAG = "MainFragmentAdapter";
    private List<Fragment> fragmentList = new ArrayList<>();
    public static List<PostRespDto> postsRespDtos = new ArrayList<>();

    public MainFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<PostRespDto> postsRespDtos) {
        super(fragmentActivity);
        this.postsRespDtos = postsRespDtos;
        Log.d(TAG, "MainFragmentAdapter: ");
    }

//     FragmentList에 아이템 추가하는 함수 필요
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
        Log.d(TAG, "MainFragmentAdapter : addFragment: " + fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fm = fragmentList.get(position);
//
//        switch (position) {
//            case 0:
//                return new MainFrag1();
//            case 1:
//                return new MainFrag2();
//            case 2:
//                return new MainFrag3();
//            case 3:
//                return new MainFrag4();
//            case 4:
//                return new MainFrag2();
//        }
//        return new MainFrag1();
        Log.d(TAG, "createFragment: position : " + fm);
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + fragmentList.size());
        return fragmentList.size();
//        return 20;
    }
}
