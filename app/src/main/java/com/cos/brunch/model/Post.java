package com.cos.brunch.model;

public class Post {

    private String keyword;
    private String title;
    private int coverImg;
    private String content;

    public Post(String title, int coverImg, String content) {
        this.title = title;
        this.coverImg = coverImg;
        this.content = content;
    }

    public Post(String keyword, String title, int coverImg, String content) {
        this.keyword = keyword;
        this.title = title;
        this.coverImg = coverImg;
        this.content = content;
    }

    public Post(String keyword, String title, int coverImg) {
        this.keyword = keyword;
        this.title = title;
        this.coverImg = coverImg;
    }

    public Post(String keyword, String title) {
        this.keyword = keyword;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(int coverImg) {
        this.coverImg = coverImg;
    }

    public Post(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


