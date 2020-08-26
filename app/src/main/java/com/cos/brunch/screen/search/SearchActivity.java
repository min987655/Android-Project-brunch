package com.cos.brunch.screen.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;

public class SearchActivity extends AppCompatActivity {

    private Context mContext = SearchActivity.this;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initObject();
        initListener();
    }

    private void initObject(){
        ivBack = findViewById(R.id.img_toolbar_l);
        ivBack.setImageResource(R.drawable.img_back_b);
    }

    private void initListener(){
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.super.onBackPressed();
            }
        });
    }
}