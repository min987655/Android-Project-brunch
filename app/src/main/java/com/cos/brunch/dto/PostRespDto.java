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
public class PostRespDto {
    private int id;
    private String title;
    private String content;
    private String coverImg;
    private String nickName;
    private String createDate;

    @BindingAdapter({"coverImg"})
    public static void loadImage(ImageView view, String coverImg){
        Picasso.get()
                .load(coverImg)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_load)
                .resize(50,50)
                .into(view);
    }
}
