package com.cos.brunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;

@Builder
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String subTitle;
    private String content;
    private String postType;
    private String likeType;
    private Integer likeCount;
    private Integer readCount;
    private String createDate;
    //    @Expose

    public Post(Integer id, Integer userId, String title, String subTitle, String content, String postType, String likeType, Integer likeCount, Integer readCount, String createDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.postType = postType;
        this.likeType = likeType;
        this.likeCount = likeCount;
        this.readCount = readCount;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}


