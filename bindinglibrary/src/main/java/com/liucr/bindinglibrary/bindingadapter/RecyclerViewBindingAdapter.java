package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.liucr.bindinglibrary.util.UiUtil;
import com.liucr.bindinglibrary.view.recyclerview.decoration.GridLayoutDecoration;
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemChildClickListener;
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemChildLongClickListener;
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemClickListener;
import com.liucr.bindinglibrary.view.recyclerview.listener.OnItemLongClickListener;
import com.liucr.bindinglibrary.view.recyclerview.viewholder.BaseViewHolder;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @author liucr on 2017/5/13.
 */

public class RecyclerViewBindingAdapter {

    // RecyclerView
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"app:itemBinding", "app:items",
            "app:onItemChildClickListener", "app:itemChildClickIds",            //子View点击事件
            "app:onItemChildLongClickListener", "app:itemChildLongClickIds",    //子View长按事件
            "app:onItemClickListener", "app:onItemLongClickListener"},          //item点击事件，item长按事件
            requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView,
                                      ItemBinding<T> itemBinding,
                                      List<T> items,
                                      final OnItemChildClickListener onItemChildClickListener, final List<Integer> itemChildClickIds,
                                      final OnItemChildLongClickListener onItemChildLongClickListener, final List<Integer> itemChildLongClickIds,
                                      final OnItemClickListener onItemClickListener, final OnItemLongClickListener onItemLongClickListener) {
        if (itemBinding == null) {
            throw new IllegalArgumentException("itemBinding must not be null");
        }

        BindingRecyclerViewAdapter adapter = (BindingRecyclerViewAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new BindingRecyclerViewAdapter<>();
            recyclerView.setAdapter(adapter);
        }
        adapter.setItemBinding(itemBinding);
        adapter.setItems(items);
        adapter.setViewHolderFactory(new BindingRecyclerViewAdapter.ViewHolderFactory() {
            @Override
            public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {

                BaseViewHolder baseViewHolder = new BaseViewHolder(binding.getRoot());

                baseViewHolder.setOnItemClickListener(onItemClickListener);
                baseViewHolder.setOnItemLongClickListener(onItemLongClickListener);
                baseViewHolder.setOnItemChildClickListener(onItemChildClickListener);
                baseViewHolder.setOnItemChildLongClickListener(onItemChildLongClickListener);

                baseViewHolder.setOnLongClickChildIdList(itemChildLongClickIds);
                baseViewHolder.setOnClickChildIdList(itemChildClickIds);
                baseViewHolder.build();
                return baseViewHolder;
            }
        });
    }

    @BindingAdapter(value = {"app:animator"})
    public static void setItemDecoration(RecyclerView recyclerView, RecyclerView.ItemAnimator animator) {
        recyclerView.setItemAnimator(animator);
    }

    @BindingAdapter(value = {"app:itemDecoration"})
    public static void addItemDecoration(RecyclerView recyclerView, RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }

    @BindingAdapter(value = {"app:gridDecoration"})
    public static void addItemDecoration(RecyclerView recyclerView, int gridDecoration) {
        gridDecoration = (int) (gridDecoration * UiUtil.getScreenDensity());
        GridLayoutDecoration gridLayoutDecoration = new GridLayoutDecoration(gridDecoration);
        recyclerView.addItemDecoration(gridLayoutDecoration);
    }

    @BindingAdapter(value = "app:focusable")
    public static void setFocusable(RecyclerView recyclerView, boolean focusable) {
        recyclerView.setFocusable(focusable);
    }
}
