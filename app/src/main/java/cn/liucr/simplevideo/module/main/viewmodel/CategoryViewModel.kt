package cn.liucr.simplevideo.module.main.viewmodel

import android.app.Application
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import cn.liucr.simplevideo.BR
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.http.SohuHttpManager
import cn.liucr.simplevideo.mode.sohu.Channel
import cn.liucr.simplevideo.mode.sohu.FirstCate
import cn.liucr.simplevideo.module.common.viewmodel.RecyclerViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by liucr on 2018/5/14.
 */
class CategoryViewModel(application: Application) : RecyclerViewModel(application) {

    lateinit var firstCate: FirstCate
    private var channelVideoList: ObservableList<Channel.ChannelVideo> = ObservableArrayList()

    override fun onCreate() {
        super.onCreate()
        getVideo()
    }

    override fun initRecyclerView() {

        itemBinding.map(Channel.ChannelVideo::class.java, BR.channelVideo, R.layout.item_channel_video)
        items.insertList(channelVideoList)
    }

    private fun getVideo() {

        SohuHttpManager.sohuApi.getChannel(16, 1, 10, 1, 1, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.data?.videos?.forEach {
                        channelVideoList.add(it)
                    }
                }, {

                })

    }


}