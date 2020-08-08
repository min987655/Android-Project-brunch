package com.cos.brunch.model;

public class Post {

    private String keyword;
    private String title;

    public Post(String keyword, String title) {
        this.keyword = keyword;
        this.title = title;
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


