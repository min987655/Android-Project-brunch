package com.cos.brunch.model;

public class User {

    private int profileImg;
    private String nickName;

    public User(int profileImg, String nickName) {
        this.profileImg = profileImg;
        this.nickName = nickName;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
