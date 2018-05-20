package cn.liucr.simplevideo.module.video.viewmodel;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.liucr.mvvmhelper.base.BaseViewModel;
import com.liucr.mvvmhelper.event.SingleLiveEvent;
import com.liucr.mvvmhelper.utils.LogUtil;
import com.sohuvideo.api.SohuPlayerDefinition;
import com.sohuvideo.api.SohuPlayerError;
import com.sohuvideo.api.SohuPlayerItemBuilder;
import com.sohuvideo.api.SohuPlayerLoadFailure;
import com.sohuvideo.api.SohuPlayerMonitor;
import com.sohuvideo.api.SohuVideoPlayer;

import java.util.List;

import cn.liucr.simplevideo.mode.sohu.Channel;
import cn.liucr.simplevideo.module.video.view.player.MediaController;
import cn.liucr.simplevideo.module.video.view.player.VideoProgress;

/**
 * Created by Administrator on 2017/3/23/023.
 */

public class VideoViewModel extends BaseViewModel implements MediaController.OnMediaControllerClickListener {

    public ObservableField<String> coverImageUrl = new ObservableField<>();
    public ObservableField<Boolean> isShowCover = new ObservableField<>(true);
    public ObservableField<Boolean> isShowCenterPlay = new ObservableField<>(true);
    public ObservableField<Boolean> isShowLoading = new ObservableField<>(false);
    public MutableLiveData<VideoProgress> updateProgress = new MutableLiveData<>();
    public MutableLiveData<Boolean> isFullScreen = new MutableLiveData<>();
    public SingleLiveEvent<Void> showControllerView = new SingleLiveEvent<>();

    public Channel.ChannelVideo channelVideo;
    public SohuVideoPlayer mSohuVideoPlayer;
    private SohuPlayerItemBuilder currentBuilder;

    private boolean mIsFullScreen = false;

    public VideoViewModel(@NonNull Application application) {
        super(application);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initViewModel() {
        mSohuVideoPlayer = new SohuVideoPlayer();
        mSohuVideoPlayer.setSohuPlayerMonitor(mSohuPlayerMonitor);

        isShowCover.set(true);
        if (!TextUtils.isEmpty(channelVideo.getHor_pic())) {
            coverImageUrl.set(channelVideo.getHor_pic());
        } else {
            coverImageUrl.set(channelVideo.getHor_high_pic());
        }

        setPlayerData(channelVideo);
    }


    /**
     * 点击中间播放按钮
     *
     * @param view
     */
    public final void clickCenterPlay(View view) {
        if (mSohuVideoPlayer != null) {
            mSohuVideoPlayer.play();
            isShowCenterPlay.set(false);
        }
    }

    /**
     * 点击屏幕
     *
     * @param view
     */
    public final void clickVideoLayout(View view) {
        showControllerView.call();
    }

    /**
     * 播放器回调
     */
    private final SohuPlayerMonitor mSohuPlayerMonitor = new SohuPlayerMonitor() {

        @Override
        public void onPreparing() {
            LogUtil.d("onPreparing");
//            mProgressBar.setVisibility(View.VISIBLE);
//            mWindowPic.setVisibility(View.VISIBLE);
//            mStartPlayBtn.setVisibility(View.GONE);
//            if (mSohuVideoPlayer.isAdvertInPlayback()) {
//                mMediaController.hideControl();
//            }
            super.onPreparing();
        }

        @Override
        public void onPrepared() {
            LogUtil.d("onPrepared");
//            mProgressBar.setVisibility(View.GONE);
//            mWindowPic.setVisibility(View.GONE);
//            mStartPlayBtn.setVisibility(View.GONE);
//            if (!mSohuVideoPlayer.isAdvertInPlayback() && mMediaController != null) {
//                mMediaController.showController();
//            }
            super.onPrepared();
        }

        @Override
        public void onStop() {
            LogUtil.d("onStop");
//            mProgressBar.setVisibility(View.GONE);
//            mWindowPic.setVisibility(View.VISIBLE);
//            mStartPlayBtn.setVisibility(View.VISIBLE);
//            if (mMediaController != null) {
//                mMediaController.updatePlayPauseState(false);
//            }
            super.onStop();
        }

        @Override
        public void onPlayOver(SohuPlayerItemBuilder sohuPlayerItemBuilder) {
            LogUtil.d("onPlayOver" + "  " + sohuPlayerItemBuilder.getTitle());
            super.onPlayOver(sohuPlayerItemBuilder);
        }

        @Override
        public void onComplete() {
            LogUtil.d("onComplete");
//            playNext();
            super.onComplete();
        }

        @Override
        public void onBuffering(int progress) {
            LogUtil.d("onBuffering");
//            mProgressBar.setVisibility(progress == 100 ? View.GONE
//                    : View.VISIBLE);
            super.onBuffering(progress);
        }

        @Override
        public void onPlay() {
            LogUtil.d("onPlay");
//            mWindowPic.setVisibility(View.GONE);
//            mProgressBar.setVisibility(View.GONE);
//            mStartPlayBtn.setVisibility(View.GONE);
//            if (!mSohuVideoPlayer.isAdvertInPlayback() && mMediaController != null) {
//                mMediaController.showController();
//            }
//            if (mMediaController != null) {
//                mMediaController.updatePlayPauseState(true);
//            }
            super.onPlay();
        }

        @Override
        public void onStartLoading() {
            isShowCenterPlay.set(false);
            isShowLoading.set(true);
            LogUtil.d("onStartLoading");
            isShowCover.set(false);
//            isDataSourceLoading = true;
//            updateLoadingUI();
            super.onStartLoading();
        }

        @Override
        public void onLoadSuccess() {
            isShowLoading.set(false);
            LogUtil.d("onLoadSuccess");
//            isDataSourceLoading = false;
            super.onLoadSuccess();
        }

        @Override
        public void onLoadFail(SohuPlayerLoadFailure sohuPlayerLoadFailure) {
            isShowLoading.set(false);
            isShowCenterPlay.set(true);
            LogUtil.d("onLoadFail = " + sohuPlayerLoadFailure);
            String text = new String();
            switch (sohuPlayerLoadFailure) {
                case IP_LIMIT:
                    text = "由于版权限制，该视频无法播放。";
                    break;
                case UNREACHED:
                    text = "网络发生错误，点击重试。";
                    break;
            }
            if (!TextUtils.isEmpty(text)) {
//                handleError(text);
            }
//            if (isFinishing()) {
//                return;
//            }
            super.onLoadFail(sohuPlayerLoadFailure);
        }

        @Override
        public void onError(SohuPlayerError sohuPlayerError) {
            LogUtil.d("onError = " + sohuPlayerError);
            String text = new String();
            switch (sohuPlayerError) {
                case INTERNAL:
                    text = "播放器发生错误，点击重试。";
                    break;
                case NETWORK:
                    text = "播放器网络发生错误，点击重试。";
                    break;
            }
            if (!TextUtils.isEmpty(text)) {
//                handleError(text);
            }
            super.onError(sohuPlayerError);
        }

        @Override
        public void onPause() {
            LogUtil.d("onPause ");
//            if (mMediaController != null) {
//                mMediaController.updatePlayPauseState(false);
//            }
            super.onPause();
        }

        @Override
        public void onPausedAdvertShown() {
            LogUtil.d("onPausedAdvertShown ");
//            if (mMediaController != null) {
//                mMediaController.hideControl();
//            }
            super.onPausedAdvertShown();
        }

        @Override
        public void onProgressUpdated(int currentPosition, int duration) {
            LogUtil.d("onProgressUpdated ");
            updateProgress.setValue(new VideoProgress(currentPosition, duration));
        }


        @Override
        public void onPlayItemChanged(SohuPlayerItemBuilder sohuPlayerItemBuilder, int index) {

            LogUtil.d("onPlayItemChanged ");
//            currentBuilder = sohuPlayerItemBuilder;
//
//            if (mMediaController != null) {
//                mMediaController.setTitle(sohuPlayerItemBuilder.getTitle());
//                mMediaController.updateDefinition();
//            }

        }

        @Override
        public void onDefinitionChanged() {
            LogUtil.d("onDefinitionChanged ");
//            if (mMediaController != null)

            super.onDefinitionChanged();
        }
    };

    @Override
    public void onPlayPauseClicked() {
        if (mSohuVideoPlayer != null) {
            if (mSohuVideoPlayer.isPlaybackState()) {
                mSohuVideoPlayer.pause();
            } else {
                mSohuVideoPlayer.play();
            }
        }
    }

    @Override
    public void onSeekTo(int pos) {
        if (mSohuVideoPlayer != null) {
            mSohuVideoPlayer.seekTo(pos);
        }
    }

    @Override
    public void onFullScreenClicked() {
        if (!mIsFullScreen) {
            isFullScreen.setValue(true);
            mIsFullScreen = true;
        }
    }

    @Override
    public void onFullBackClicked() {

        if (mIsFullScreen) {
            isFullScreen.setValue(false);
            if (mSohuVideoPlayer != null) {
                mSohuVideoPlayer.removePadBySelf();
            }
        }
    }

    @Override
    public int getCurrentDefinition() {
//        if (mSohuVideoPlayer != null) {
//            return mSohuVideoPlayer.getCurrentDefinition();
//        }
        return SohuPlayerDefinition.PE_DEFINITION_FLUENCY;
    }

    @Override
    public List<Integer> getSupportDefinitions() {
//        if (mSohuVideoPlayer != null) {
//            return mSohuVideoPlayer.getSupportDefinitions();
//        }
        return null;
    }

    @Override
    public void changeDefinition(int definition) {
//        if (mSohuVideoPlayer != null) {
//            mSohuVideoPlayer.changeDefinition(definition);
//        }
    }

    @Override
    public boolean isAdvertInPlayback() {
//        if (mSohuVideoPlayer != null) {
//            return mSohuVideoPlayer.isAdvertInPlayback();
//        }
        return true;
    }

    @Override
    public int getCurrentPosition() {
//        if (mSohuVideoPlayer != null) {
//            return mSohuVideoPlayer.getCurrentPosition();
//        }
        return 0;
    }

    @Override
    public int getDuration() {
//        if (mSohuVideoPlayer != null) {
//            return mSohuVideoPlayer.getDuration();
//        }
        return 0;
    }

    @Override
    public void onPlayNextClicked() {
//        playNext();
    }

    @Override
    public void onLiteBackClicked() {
//        finish();
    }

    /**
     * 设置播放数据
     *
     * @param channelVideo
     */
    public void setPlayerData(Channel.ChannelVideo channelVideo) {
        if (channelVideo == null) {
            return;
        }

        int site = channelVideo.getSite();
        long aid = channelVideo.getAid();
        long vid = channelVideo.getVid();
        currentBuilder = new SohuPlayerItemBuilder("0", aid, vid, site);

        if (currentBuilder != null) {
            mSohuVideoPlayer.setDataSource(currentBuilder);
        }

    }

    public void setChannelVideo(Channel.ChannelVideo channelVideo) {
        this.channelVideo = channelVideo;
    }
}
