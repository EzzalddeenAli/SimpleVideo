package cn.liucr.simplevideo.module.video

import android.arch.lifecycle.Observer
import android.content.pm.ActivityInfo
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.LinearLayout
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.constant.Constant
import cn.liucr.simplevideo.databinding.ActivityVideoBinding
import cn.liucr.simplevideo.mode.sohu.Channel
import cn.liucr.simplevideo.module.video.view.player.MediaController
import cn.liucr.simplevideo.module.video.view.player.VideoProgress
import cn.liucr.simplevideo.module.video.viewmodel.VideoViewModel
import com.liucr.mvvmhelper.base.BaseVmActivity
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : BaseVmActivity<ActivityVideoBinding>() {


    private lateinit var mMediaController: MediaController

    private lateinit var videoViewModel: VideoViewModel

    override fun contentView(): Int {
        return R.layout.activity_video
    }

    override fun initViewModel() {
        val channelVideo = intent?.getSerializableExtra(Constant.CHANNEL_VIDEO) as Channel.ChannelVideo
        videoViewModel = getViewModel(VideoViewModel::class.java, null)
        videoViewModel.channelVideo = channelVideo
        lifecycle.addObserver(videoViewModel)

        videoViewModel.isFullScreen.observe(this, Observer<Boolean> {
            if (it != null) {
                if (it) {
                    setFullScreenMode()
                } else {
                    setLiteScreenMode()
                }
            }
        })

        videoViewModel.updateProgress.observe(this, Observer<VideoProgress> {
            if (it != null) {
                updataProgress(it.currentPosition, it.duration)
            }
        })

        videoViewModel.showControllerView.observe(this, Observer<Void> {
            showControllerView()
        })
    }

    override fun dataBinding() {
        binding.videoViewModule = videoViewModel
        binding.setLifecycleOwner(this)
    }

    override fun initView() {
        //控制层View
        mMediaController = MediaController(this, videoViewModel)
        val lp = FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        mediaControllerLayout.addView(mMediaController.contentView, lp)
    }


    /**
     * 显示控制窗口
     */
    fun showControllerView() {
        mMediaController.showController()
    }

    /**
     * 隐藏控制窗口
     */
    fun hideControllerView() {
        mMediaController.hideControl()
    }

    /**
     * 更新进度条
     * @param current
     * @param duration
     */
    fun updataProgress(current: Int, duration: Int) {
        mMediaController.setProgress(current, duration)
    }

    /**
     * 设置为小屏模式
     */
    fun setLiteScreenMode() {

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        mMediaController.hideControl()//隐藏状态栏
        videoLayout.isFullScreen = false

        mMediaController.setFullScreenMode(false)
    }

    /**
     * 设置为大屏幕模式
     */
    fun setFullScreenMode() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        mMediaController.hideControl()//隐藏状态栏
        videoLayout.isFullScreen = true

        mMediaController.setFullScreenMode(true)
    }

}