package com.cos.brunch.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cos.brunch.R;
import com.squareup.picasso.Picasso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String subTitle;
    private String content;
    private String coverImg;
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

    @BindingAdapter({"coverImg"})
    public static void loadImage(ImageView view, String coverImg){
        Picasso.get()
                .load(coverImg)
                .error(R.drawable.img_post_write)
                .placeholder(R.drawable.ic_load)
                .resize(50,50)
                .into(view);
    }
}


