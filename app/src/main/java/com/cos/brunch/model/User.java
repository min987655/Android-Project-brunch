package com.cos.brunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

    public User(String nickName, String bio) {
        this.nickName = nickName;
        this.bio = bio;
    }

    public User(String nickName, String bio, String profileImage) {
        this.nickName = nickName;
        this.bio = bio;
        this.profileImage = profileImage;
    }

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
}


