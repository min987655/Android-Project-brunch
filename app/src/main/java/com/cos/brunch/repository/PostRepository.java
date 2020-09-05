package com.cos.brunch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.network.service.PostService;
import com.cos.brunch.network.ServiceGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private static final String TAG = "PostRepository";

    private MutableLiveData<List<Post>> allPosts = new MutableLiveData<>();
    private MutableLiveData<List<PostRespDto>> allPostRespDtos = new MutableLiveData<>();
    private MutableLiveData<List<PostByTagRespDto>> allPostByTagRespDtos = new MutableLiveData<>();
    private PostService PostService = ServiceGenerator.createService(PostService.class);

    private static PostRepository instance = new PostRepository();

    private PostRepository() {
    }

    public static PostRepository getInstance() {
        return instance;
    }

    public MutableLiveData<List<Post>> mtWriterPost(Map<String, Object> headerJwtToken){
        Call<List<Post>> call = PostService.getWriterPost(headerJwtToken);

        Log.d(TAG, "mtWriterPost: headerJwtToken : " + headerJwtToken);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: mtWriterPost : 연결실패 ! " + response.code());
                    return;
                }
                List<Post> postItem = response.body();
                Log.d(TAG, "onResponse: mtWriterPost : postItem : " + postItem);

                for (Post post : postItem) {
                    String coverImg = post.getCoverImg();
                    String picassoImg = "http:" + coverImg;
                    post.setCoverImg(picassoImg);

//                  createDate format 맞춤
                    String serverDate = post.getCreateDate();
                    Log.d(TAG, "onResponse: serverDate : " + serverDate);

                    SimpleDateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

                    try {
                        Date testServerDate = serverDateFormat.parse(serverDate);
                        String testNewDate = newDateFormat.format(testServerDate);

                        String newDate = testNewDate;
                        post.setCreateDate(newDate);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (postItem != null) {
                    allPosts.setValue(postItem);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: getAllPostByTags : error : " + t.getMessage());
            }
        });
        return allPosts;
    }

    public MutableLiveData<List<PostByTagRespDto>> getAllPostByTags() {
        Call<List<PostByTagRespDto>> call = PostService.getPostByTag();
        call.enqueue(new Callback<List<PostByTagRespDto>>() {
            @Override
            public void onResponse(Call<List<PostByTagRespDto>> call, Response<List<PostByTagRespDto>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getAllPostByTags : 연결실패 ! " + response.code());
                    return;
                }
                List<PostByTagRespDto> postByTagRespDtoItems = response.body();
                Log.d(TAG, "onResponse: postByTagRespDtoItems : " + postByTagRespDtoItems);

                for (PostByTagRespDto PostByTagRespDto : postByTagRespDtoItems) {
                    String coverImg = PostByTagRespDto.getCoverImg();
                    String picassoImg = "http:" + coverImg;
                    PostByTagRespDto.setCoverImg(picassoImg);

//                  createDate format 맞춤
                    String serverDate = PostByTagRespDto.getCreateDate();
                    Log.d(TAG, "onResponse: serverDate : " + serverDate);

                    SimpleDateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

                    try {
                        Date testServerDate = serverDateFormat.parse(serverDate);
                        String testNewDate = newDateFormat.format(testServerDate);

                        String newDate = testNewDate;
                        PostByTagRespDto.setCreateDate(newDate);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }

                if (postByTagRespDtoItems != null) {
                    allPostByTagRespDtos.setValue(postByTagRespDtoItems);
                }
            }
            @Override
            public void onFailure(Call<List<PostByTagRespDto>> call, Throwable t) {
                Log.d(TAG, "onFailure: getAllPostByTags : error : " + t.getMessage());
            }
        });
        return allPostByTagRespDtos;
    }

    public MutableLiveData<List<PostRespDto>> getPostRespDtos() {
        Call<List<PostRespDto>> call = PostService.mtPostRespDtos();
        call.enqueue(new Callback<List<PostRespDto>>() {
            @Override
            public void onResponse(Call<List<PostRespDto>> call, Response<List<PostRespDto>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getAllPosts : 연결실패 ! ");
                    return;
                }
                List<PostRespDto> postItems = response.body();
                Log.d(TAG, "onResponse: getAllPosts : postItems : " + postItems);

                for (PostRespDto postRespDto : postItems) {
                    String coverImg = postRespDto.getCoverImg();
                    String picassoImg = "http:" + coverImg;
                    postRespDto.setCoverImg(picassoImg);
                }
                if (postItems != null) {
                    allPostRespDtos.setValue(postItems);
                }
            }
            @Override
            public void onFailure(Call<List<PostRespDto>> call, Throwable t) {
                Log.d(TAG, "onFailure: getAllPosts : error : " + t.getMessage());
            }
        });
        return allPostRespDtos;
    }

    // post/save
    public int save(Map<String, Object> headerJwtToken, Post post) {
        Call<Post> call = PostService.createPost(headerJwtToken, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: save : response.code() : " + response.code());
                    return;
                }
            }
            // 서버에서 돌려주는 값 json 아니라서 타입 오류남. 받을 필요 없어서 처리 안함.
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: save : " + t.getMessage());
            }
        });
        return -1;
    }

    // post/list
    public MutableLiveData<List<Post>> mtPosts() {
        Call<List<Post>> call = PostService.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getPosts : 연결실패 ! ");
                    return;
                }
                List<Post> postItems = response.body();
                Log.d(TAG, "onResponse: getPosts : postItems : " + response.code());

                for (Post posts : postItems) {
                    String coverImg = posts.getCoverImg();
                    String picassoImg = "http:" + coverImg;
                    posts.setCoverImg(picassoImg);
                }
                if (postItems != null) {
                    allPosts.setValue(postItems);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: error : " + t.getMessage());
            }
        });
        return allPosts;
    }
}
