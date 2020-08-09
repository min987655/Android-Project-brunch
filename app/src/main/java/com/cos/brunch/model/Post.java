package com.cos.brunch.model;

public class Post {

    private String keyword;
    private String title;
    private String coverImg;

    public Post(String keyword, String title, String coverImg) {
        this.keyword = keyword;
        this.title = title;
        this.coverImg = coverImg;
    }

    public Post(String keyword, String title) {
        this.keyword = keyword;
        this.title = title;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
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


