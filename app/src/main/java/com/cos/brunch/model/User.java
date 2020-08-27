package com.cos.brunch.model;

public class User {

    private int id;
    private String password;
    private String snsId; // @앞 아이디 파싱한거
    private String nickName;
    private String email;
    private String bio;
    private String profileImage;
    //        private UserRole userRole;
    private String provider;
    private String providerId;

    public User(String email) {
        this.email = email;
    }

    public User(String password, String snsId, String nickName, String email, String bio, String profileImage, String provider, String providerId) {
        this.password = password;
        this.snsId = snsId;
        this.nickName = nickName;
        this.email = email;
        this.bio = bio;
        this.profileImage = profileImage;
        this.provider = provider;
        this.providerId = providerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSnsId() {
        return snsId;
    }

    public void setSnsId(String snsId) {
        this.snsId = snsId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}


