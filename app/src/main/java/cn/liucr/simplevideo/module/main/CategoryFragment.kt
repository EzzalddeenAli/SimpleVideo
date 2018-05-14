package cn.liucr.simplevideo.module.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.constant.Constant
import cn.liucr.simplevideo.databinding.FragmentCategoryBinding
import cn.liucr.simplevideo.mode.sohu.FirstCate
import cn.liucr.simplevideo.module.main.viewmodel.CategoryViewModel
import cn.liucr.simplevideo.module.main.viewmodel.MainViewModel
import com.liucr.mvvmhelper.base.BaseFragment

/**
 * Created by liucr on 2018/5/14.
 */

class CategoryFragment : BaseFragment() {

//    private lateinit var binding: FragmentCategoryBinding
//    private lateinit var categoryViewModel: CategoryViewModel
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_category, container, false)
//        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
//        binding.viewModel = categoryViewModel
//        return binding.root
//    }
//
//    companion object {
//        fun createCategoryFragment(firstCate: FirstCate): CategoryFragment {
//            val bundle = Bundle()
//            bundle.putSerializable(Constant.FIRST_CATE, firstCate)
//
//            val categoryFragment = CategoryFragment()
//            categoryFragment.arguments = bundle
//            return categoryFragment
//        }
//    }
}