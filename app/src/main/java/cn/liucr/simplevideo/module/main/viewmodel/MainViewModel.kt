package cn.liucr.simplevideo.module.main.viewmodel

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import cn.liucr.simplevideo.http.ApiConstant
import cn.liucr.simplevideo.http.SohuHttpManager
import cn.liucr.simplevideo.mode.sohu.FirstCate
import com.liucr.mvvmhelper.base.BaseViewModel
import com.liucr.mvvmhelper.utils.LogUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : BaseViewModel(application) {

    var firstCateList: MutableLiveData<List<FirstCate>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        getFirstCate()
    }

    private fun getFirstCate() {
        SohuHttpManager.getDouBanApi().getFirstCate(ApiConstant.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.firstCateList.value = it.data
                    LogUtil.d(it.toString())
                }, {
                    LogUtil.d(it.toString())
                })
    }

}