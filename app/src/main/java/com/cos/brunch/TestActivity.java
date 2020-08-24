package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.screen.main.MainActivity;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";
    private Button button;
    private Context mContext = TestActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post(1, 1, "1.제목_통신테스트", "1.소제목_통신테스트", "1.본문_통신테스트", "에세이", "ok", 0, 0, null);

                BrunchService brunchService = BrunchService.retrofit.create(BrunchService.class);

                Call<Post> test1 = brunchService.createPost(post);
                test1.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if(!response.isSuccessful()) {
                            Log.d(TAG, "onResponse: 연결 실패 ! " + response.code());
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
//                Intent intent = new Intent(mContext, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}