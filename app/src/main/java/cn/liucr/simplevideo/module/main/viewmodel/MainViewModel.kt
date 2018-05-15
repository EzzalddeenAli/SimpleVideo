package cn.liucr.simplevideo.module.main.viewmodel

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import cn.liucr.simplevideo.http.SohuHttpManager
import cn.liucr.simplevideo.mode.sohu.FirstCate
import com.liucr.mvvmhelper.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : BaseViewModel(application) {

    var firstCateList: MutableLiveData<List<FirstCate>> = MutableLiveData()
    private var firstCateDisposable: Disposable? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        getFirstCate()
    }

    override fun onCleared() {
        super.onCleared()
        firstCateDisposable?.dispose()
    }

    /**
     * 获取一级分类
     */
    private fun getFirstCate() {

        firstCateDisposable?.dispose()
        firstCateDisposable = SohuHttpManager.sohuApi.firstCate
                .subscribeOn(Schedulers.newThread())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.firstCateList.value = it.data
                }, {
                })
    }

}