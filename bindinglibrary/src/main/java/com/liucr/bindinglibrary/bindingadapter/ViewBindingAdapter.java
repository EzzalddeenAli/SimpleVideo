package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.liucr.bindinglibrary.util.UiUtil;

/**
 * Created by liucr on 2018/5/15.
 */
public class ViewBindingAdapter {

    @BindingAdapter(value = {"app:screenWidthShare"})
    public static void resetHeightWidthBy(View view, int screenWidthShare) {
        resetHeightWidthBy(view, screenWidthShare, 0);
    }

    @BindingAdapter(value = {"app:screenWidthShare", "app:allSpace"})
    public static void resetHeightWidthBy(View view, int screenWidthShare, int allSpace) {

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        int screenWidth = (int) (UiUtil.getScreenWidth() - allSpace * UiUtil.getScreenDensity());
        int width = screenWidth / screenWidthShare;
        int height = (int) (width * (layoutParams.height / (float) layoutParams.width));

        if (layoutParams.width != width
                || layoutParams.height != height) {
            layoutParams.width = width;
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }
    }
}
