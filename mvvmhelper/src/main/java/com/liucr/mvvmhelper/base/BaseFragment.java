package com.liucr.mvvmhelper.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    protected B binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, contentView(), container, false);
        binding.setLifecycleOwner(this);
        dataBinding();
        initView();
        return binding.getRoot();
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

    protected <T extends BaseViewModel> T getViewModelByActivity(@NonNull Class<T> modelClass, @Nullable ViewModelProvider.Factory factory) {
        T t = ViewModelProviders.of(getActivity(), factory).get(modelClass);
        getLifecycle().addObserver(t);
        return t;
    }
}
