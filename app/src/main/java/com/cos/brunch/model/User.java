package com.cos.brunch.model;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

public class User {

    private String email;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("profileImg")
    private int profileImg;

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
