package com.liucr.bindinglibrary.util;

import android.content.Context;
import android.util.Log;

/**
 * Created by liucr on 2018/5/16.
 */
public class UiUtil {

    private static UiCache sUiCache;

    public static void init(Context context) {
        sUiCache = new UiCache();
        sUiCache.screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        sUiCache.screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        sUiCache.density = context.getResources().getDisplayMetrics().density;
        Log.e("UiCache>> ", context.getResources().getDisplayMetrics().toString());
    }

    public static int getScreenWidth() {
        return sUiCache.screenWidth;
    }

    public static int getScreenHeight() {
        return sUiCache.screenHeight;
    }

    public static float getScreenDensity() {
        return sUiCache.density;
    }

    private static final class UiCache {
        int screenWidth;
        int screenHeight;
        float density;
    }

}
