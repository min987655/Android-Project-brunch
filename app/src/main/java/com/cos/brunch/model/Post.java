package com.cos.brunch.model;

public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String subTitle;
    private String content;
    private String postType;
    private Integer readCount;
    private String createDate;

    public Post(Integer userId, String title, String subTitle, String content, String postType, Integer readCount, String createDate) {
        this.userId = userId;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.postType = postType;
        this.readCount = readCount;
        this.createDate = createDate;
    }

    public Post(String title, String subTitle, String content) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
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


