package cn.liucr.simplevideo.adapter.bindingadapter;

import android.databinding.BindingAdapter;

import com.sohuvideo.api.SohuScreenView;
import com.sohuvideo.api.SohuVideoPlayer;

public class SohuScreenViewBindingAdapter {


    @BindingAdapter("sohuvideo_player")
    public static void setSohuVideoPlayer(SohuScreenView sohuScreenView, SohuVideoPlayer sohuVideoPlayer) {
        sohuVideoPlayer.setSohuScreenView(sohuScreenView);
    }

}
