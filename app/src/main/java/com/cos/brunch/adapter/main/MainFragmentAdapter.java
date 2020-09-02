package com.cos.brunch.adapter.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;

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

    // FragmentList에 아이템 추가하는 함수 필요
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
        Log.d(TAG, "MainFragmentAdapter : addFragment: " + fragment);
    }

    // 프레그먼트에서 뷰 찾는법 확인하여 타이틀에 뿌리기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!(오류남 !!!!!!)
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fm = fragmentList.get(position);
        Log.d(TAG, "createFragment: position : " + fm);
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + fragmentList.size());
        return fragmentList.size();
    }
//
//    public void setPostsRespDtos(List<PostRespDto> postsRespDtos){
//        this.postsRespDtos = postsRespDtos;
//        Log.d(TAG, "setPosts: " + postsRespDtos);
//        notifyDataSetChanged();
//    }
}
