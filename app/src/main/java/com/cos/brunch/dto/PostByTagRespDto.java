package com.cos.brunch.dto;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cos.brunch.R;
import com.squareup.picasso.Picasso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostByTagRespDto {
    private String title;
    private String subTitle;
    private String coverImg;
    private String content;
    private String createDate;
    private String nickName;
    private String tag;

    @BindingAdapter({"coverImg"})
    public static void loadImage(ImageView view, String coverImg){
        Picasso.get()
                .load(coverImg)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_load)
                .into(view);
    }
}
