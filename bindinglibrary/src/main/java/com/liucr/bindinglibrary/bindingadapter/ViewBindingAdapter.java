package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;

/**
 * Created by liucr on 2018/5/15.
 */
public class ViewBindingAdapter {

    @BindingAdapter(value = {"app:designWidth", "app:designHeight"})
    public static void resetHeightByWidth(View view, int designWidth, int designHeight) {

        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        view.measure(w, h);

        Log.e("liucr", view.getMeasuredWidth() + " : " + view.getMeasuredHeight());

//        float ratio = designHeight / (float) designWidth;
//
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.width = view.getMeasuredWidth();
//        layoutParams.height = (int) (ratio * view.getMeasuredWidth());
//        view.setLayoutParams(layoutParams);
    }

}
