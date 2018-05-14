package cn.liucr.simplevideo.module.main;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liucr.mvvmhelper.base.BaseFragment;

import cn.liucr.simplevideo.R;
import cn.liucr.simplevideo.constant.Constant;
import cn.liucr.simplevideo.databinding.FragmentCategoryBinding;
import cn.liucr.simplevideo.mode.sohu.FirstCate;

/**
 * Created by liucr on 2018/5/14.
 */
public class CategoryFragment1 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCategoryBinding categoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);
        return categoryBinding.getRoot();
    }

    public static CategoryFragment createCategoryFragment(FirstCate firstCate) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.FIRST_CATE, firstCate);

        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setArguments(bundle);
        return categoryFragment;
    }
}
