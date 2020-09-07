package com.cos.brunch.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cos.brunch.R;
import com.squareup.picasso.Picasso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public User(int id, String password, String snsId, String nickName, String email, String bio, String profileImage, String provider, String providerId) {
        this.id = id;
        this.password = password;
        this.snsId = snsId;
        this.nickName = nickName;
        this.email = email;
        this.bio = bio;
        this.profileImage = profileImage;
        this.provider = provider;
        this.providerId = providerId;
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

    @BindingAdapter({"profileImage"})
    public static void loadImage(ImageView view, String profileImage){
        Picasso.get()
                .load(profileImage)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_load)
                .resize(50,50)
                .into(view);
    }
}


