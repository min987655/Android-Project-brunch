package com.cos.brunch.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ApplyFragmentAdapter extends FragmentStateAdapter {

    private static final String TAG = "ApplyFragmentAdapter";
    private List<Fragment> fragmentList = new ArrayList<>();

    public ApplyFragmentAdapter(@NonNull FragmentActivity fa, List<Fragment> fragmentList) {
        super(fa);
        this.fragmentList = fragmentList;
        Log.d(TAG, "ApplyFragmentAdapter: 됨?");
    }

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
        Log.d(TAG, "addFragment: " + fragment);
    }

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
}
