package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cos.brunch.main.MainFragmentAdapter;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.MainRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {

    private Context mContext = TestActivity.this;
    private static final String TAG = "TestActivity";

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tvTest = findViewById(R.id.tv_test);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.61:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        Log.d(TAG, "MainRepository: call : " + call);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    tvTest.setText("Code: " + response.code());
                    return;
                }
                List<Post> postItems = response.body();
                Log.d(TAG, "onResponse: postItems : " + postItems);

                for (Post post : postItems) {
                    String content = "";
                    content += "id: " + post.getId() + "\n";
                    content += "USER_ID: " + post.getUserId() + "\n";
                    content += "TITLE: " + post.getTitle() + "\n";
                    content += "SUB_TITLE: " + post.getSubTitle() + "\n";
                    content += "POST_TYPE: " + post.getPostType() + "\n";
                    content += "CONTENT: " + post.getContent() + "\n\n";
                    content += "LIKE_TYPE: " + post.getLikeType() + "\n\n";
                    content += "LIKE_COUNT: " + post.getLikeCount() + "\n\n";
                    content += "READ_COUNT: " + post.getReadCount() + "\n\n";
                    content += "CREATE_DATE: " + post.getCreateDate() + "\n\n";
                    tvTest.append(content);
                    Log.d(TAG, "onResponse: tvTest : " + tvTest);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tvTest.setText(t.getMessage());
            }
        });
    }

}