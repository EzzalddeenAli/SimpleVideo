package com.liucr.mvvmhelper.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.liucr.mvvmhelper.event.DialogData;

public abstract class BaseVmActivity<B extends ViewDataBinding> extends BaseActivity {

    protected B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, contentView());
        binding.setLifecycleOwner(this);
        initViewModel();
        dataBinding();
        initView();
    }

    public abstract int contentView();

    public abstract void initViewModel();

    public abstract void dataBinding();

    public abstract void initView();

    protected <T extends BaseViewModel> T getViewModel(@NonNull Class<T> modelClass, @Nullable ViewModelProvider.Factory factory) {
        T t = ViewModelProviders.of(this, factory).get(modelClass);
        getLifecycle().addObserver(t);
        return t;
    }

    protected void setProgressDialogData(DialogData dialogData) {
        dialogData.dismiss.observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                getProgressDialog().dismiss();
            }
        });

        dialogData.show.observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                getProgressDialog().show();
            }
        });

        dialogData.contentRes.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null) {
                    getProgressDialog().setMessage(getString(integer));
                } else {
                    getProgressDialog().setMessage(null);
                }
            }
        });
    }

}
