package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageViewBindingAdapter {

    @BindingAdapter("app:image")
    public static void imageLoader(ImageView imageView, Object image) {
        imageLoader(imageView, image, new RequestOptions().centerInside());
    }

    @BindingAdapter(value = {"app:image", "app:placeholder", "app:error"}, requireAll = false)
    public static void imageLoader(ImageView imageView, Object image, int placeholder, int error) {
        imageLoader(imageView, image, RequestOptions.placeholderOf(placeholder).error(error).centerInside());
    }

    @BindingAdapter(value = {"app:image", "app:requestOptions"})
    public static void imageLoader(ImageView imageView, Object image, RequestOptions requestOptions) {
        Glide.with(imageView.getContext())
                .load(image)
                .apply(requestOptions)
                .into(imageView);
    }
}
