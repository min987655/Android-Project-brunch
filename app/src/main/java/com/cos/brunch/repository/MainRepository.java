package com.cos.brunch.repository;

import android.util.Log;
import android.widget.TextView;

import com.cos.brunch.JsonPlaceHolderApi;
import com.cos.brunch.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRepository {

    private static final String TAG = "MainRepository";

    private TextView tvTest;

    public MainRepository() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.61:8080/brunch/posts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // 쿼리스트링 만들기
//        Map<String, String > queryString = new HashMap<>();
//        queryString.put("sort_by", "rating");
//        queryString.put("page","2");

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        Log.d(TAG, "MainRepository: call : " + call);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    tvTest.setText("Code: " + response.code());
                    return;
                }
                List<Post> postItem = response.body();

                for (Post post : postItem) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "USER_ID: " + post.getUserId() + "\n";
                    content += "TITLE: " + post.getTitle() + "\n";
                    content += "SUB_TITLE: " + post.getSubTitle() + "\n";
                    content += "POST_TYPE: " + post.getPostType() + "\n";
                    content += "CONTENT: " + post.getContent() + "\n\n";
                    content += "LIKE_TYPE: " + post.getLikeType() + "\n\n";
                    content += "LIKE_COUNT: " + post.getLikeCount() + "\n\n";
                    content += "READ_COUNT: " + post.getReadCount() + "\n\n";
                    content += "CREATE_DATE: " + post.getCreateDate() + "\n\n";
//                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
            }
        });
    }
}
