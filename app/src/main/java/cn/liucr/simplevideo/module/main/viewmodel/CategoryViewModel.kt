package cn.liucr.simplevideo.module.main.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import cn.liucr.simplevideo.BR
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.http.SohuHttpManager
import cn.liucr.simplevideo.mode.sohu.Channel
import cn.liucr.simplevideo.mode.sohu.FirstCate
import cn.liucr.simplevideo.module.common.viewmodel.RecyclerViewModel
import com.liucr.bindinglibrary.view.smartrefreshlayout.LoadMoreState
import com.liucr.bindinglibrary.view.smartrefreshlayout.RefreshState
import com.liucr.mvvmhelper.utils.LogUtil
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by liucr on 2018/5/14.
 */
class CategoryViewModel(application: Application) : RecyclerViewModel(application), OnLoadMoreListener, OnRefreshListener {

    lateinit var firstCate: FirstCate
    private var channelVideoList: ObservableList<Channel.ChannelVideo> = ObservableArrayList()

    val refreshState = MutableLiveData<Int>()
    val loadMoreState = MutableLiveData<Int>()

    var page: Int = 1

    override fun onCreate() {
        super.onCreate()
        if (channelVideoList.size == 0) {
            getVideo()
        }
    }

    override fun initRecyclerView() {

        itemBinding.map(Channel.ChannelVideo::class.java, BR.channelVideo, R.layout.item_channel_video)
        items.insertList(channelVideoList)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        channelVideoList.clear()
        page = 1
        getVideo()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        getVideo()
    }

    private fun getVideo() {

        SohuHttpManager.sohuApi.getChannel(16, 1, 10, page, 1, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.data?.videos?.forEach {
                        channelVideoList.add(it)
                    }
                    page++
                    refreshState.value = RefreshState.REFRESH_SUCCESS
                    loadMoreState.value = LoadMoreState.LOAD_MORE_COMPLETE
                }, {

                })

    }

    override fun onCleared() {
        super.onCleared()
        LogUtil.e(this.toString())
    }

}