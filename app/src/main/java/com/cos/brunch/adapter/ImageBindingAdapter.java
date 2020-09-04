//package com.cos.brunch.adapter;
//
//import android.widget.ImageView;
//
//import androidx.databinding.BindingAdapter;
//
//import com.bumptech.glide.Glide;
//import com.cos.brunch.R;
//
//public class ImageBindingAdapter {
//
//    @BindingAdapter({"coverImg"})
//    public static void loadImage(ImageView view, String coverImg){
//        Glide.with(view.getContext())
//                .load(coverImg)
//                .error(R.drawable.ic_error)
//                .placeholder(R.drawable.ic_load)
//                .into(view);
//    }
//}