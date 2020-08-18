package com.cos.brunch.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cos.brunch.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends FragmentStateAdapter {

    private static final String TAG = "MainFragmentAdapter";
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public MainFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Post> posts) {
        super(fragmentActivity);
        this.posts = posts;
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
        // 3번일 때만 2개로
        // 나머지는 그대로
        Fragment fm = fragmentList.get(position);
//        View v = fm.getView();
        Log.d(TAG, "createFragment: position : " + fm);
//        Log.d(TAG, "createFragment: " + v);
//        if(position == 3){
//            TextView tvTitle1 = v.findViewById(R.id.tv_title1);
//            TextView tvTitle2 = v.findViewById(R.id.tv_title2);
//            tvTitle1.setText("동적변경1");
//            tvTitle2.setText("동적변경2");
//        }
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + fragmentList.size());
        return fragmentList.size();
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
        Log.d(TAG, "setPosts: " + posts);
        notifyDataSetChanged();
    }
}
