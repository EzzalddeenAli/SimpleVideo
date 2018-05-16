package cn.liucr.simplevideo.module.main.viewmodel

import android.annotation.SuppressLint
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
import com.liucr.bindinglibrary.view.smartrefreshlayout.state.LoadMoreState
import com.liucr.bindinglibrary.view.smartrefreshlayout.state.RefreshState
import com.liucr.bindinglibrary.viewmodel.state.StateViewModel
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

    val stateViewModel: StateViewModel = StateViewModel()

    val refreshState = MutableLiveData<Int>()
    val loadMoreState = MutableLiveData<Int>()

    var page: Int = 1

    override fun onCreate() {
        super.onCreate()
        if (channelVideoList.size == 0) {
            getVideo()
            refreshState.value = RefreshState.REFRESH_TRIGGER
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

    @SuppressLint("CheckResult")
    private fun getVideo() {

        SohuHttpManager.sohuApi.getChannel(firstCate.cate_id, 1, 10, page, 1, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.data?.videos?.forEach {
                        channelVideoList.add(it)
                    }
                    page++
                    refreshState.value = RefreshState.REFRESH_SUCCESS
                    loadMoreState.value = LoadMoreState.LOAD_MORE_COMPLETE
                    stateViewModel.viewState.value = StateViewModel.State.STATE_CONTENT
                }, {
                    refreshState.value = RefreshState.REFRESH_FAIL
                    loadMoreState.value = LoadMoreState.LOAD_MORE_FAIL
                    stateViewModel.viewState.value = StateViewModel.State.STATE_ERROR
                    stateViewModel.viewErrorContent.value = it.message.toString()
                })

    }

    override fun onCleared() {
        super.onCleared()
        LogUtil.e(this.toString())
    }

}