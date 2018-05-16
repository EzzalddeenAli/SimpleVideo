package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.annotation.StringRes;
import android.widget.TextView;

public class TextViewBindingAdapter {


    @BindingAdapter("app:text")
    public static void setText(TextView view, Object text) {
        if (text == null) {
            view.setText(null);
            return;
        }

        if (text instanceof Integer) {
            view.setText((Integer) text);
        } else if (text instanceof String) {
            view.setText((String) text);
        }
    }

}
