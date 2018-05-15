package cn.liucr.simplevideo.module.common.viewmodel

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemChildClickListener
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemChildLongClickListener
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemClickListener
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemLongClickListener
import com.liucr.mvvmhelper.base.BaseViewModel
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import java.util.*

/**
 * Created by liucr on 2018/5/7.
 */
abstract class RecyclerViewModel(application: Application) : BaseViewModel(application), OnItemClickListener, OnItemChildClickListener, OnItemLongClickListener, OnItemChildLongClickListener {

    val items = MergeObservableList<Any>()
    val itemBinding = OnItemBindClass<Any>()

    val mItemChildClickIds: List<Int> = ArrayList()
    val mItemChildLongClickIds: List<Int> = ArrayList()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        initRecyclerView()
    }

    abstract fun initRecyclerView()

    override fun onItemChildClick(position: Int, viewId: Int) {

    }

    override fun onItemChildLongClick(Position: Int, viewId: Int) {

    }

    override fun onItemClick(position: Int) {

    }

    override fun onItemLongClick(position: Int) {

    }
}
