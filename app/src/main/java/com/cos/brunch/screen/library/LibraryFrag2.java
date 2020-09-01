package com.cos.brunch.screen.library;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.library.LibraryTap1Adapter;
import com.cos.brunch.adapter.library.LibraryTap2Adapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class LibraryFrag2 extends Fragment {

    private static final String TAG = "LibraryFrag2";
    public LibraryTap2Adapter libraryTap2Adapter;
    private RecyclerView rvLibraryContent2;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag2_library, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvLibraryContent2 = v.findViewById(R.id.rv_library_content2);
        libraryTap2Adapter = new LibraryTap2Adapter();
    }

    private void initData(){

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvLibraryContent2.setLayoutManager(layoutManager);
        rvLibraryContent2.setAdapter(libraryTap2Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+posts);

                libraryTap2Adapter.setPosts(posts);

            }
        });
    }

    private void initlistener() {
        libraryTap2Adapter.setOnClickListener(new LibraryTap2Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }

}
