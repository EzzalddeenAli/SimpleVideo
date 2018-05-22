package cn.liucr.simplevideo.module.main

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.constant.Constant
import cn.liucr.simplevideo.databinding.FragmentCategoryBinding
import cn.liucr.simplevideo.mode.sohu.FirstCate
import cn.liucr.simplevideo.module.main.viewmodel.CategoryViewModel
import cn.liucr.simplevideo.module.video.VideoActivity
import com.liucr.mvvmhelper.base.BaseFragment
import com.liucr.mvvmhelper.utils.LogUtil

/**
 * Created by liucr on 2018/5/14.
 */

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private var categoryViewModel: CategoryViewModel? = null

    override fun contentView(): Int {
        return R.layout.fragment_category
    }

    override fun initViewModel() {

        if (categoryViewModel == null) {
            val firstCate = arguments?.getSerializable(Constant.FIRST_CATE)
            categoryViewModel = getViewModel(CategoryViewModel::class.java, null)
            categoryViewModel?.firstCate = firstCate as FirstCate
        }
    }

    override fun dataBinding() {

        binding.viewModel = categoryViewModel

        categoryViewModel?.startActivity?.observe(this, Observer<Intent> {
            it?.let {
                it.setClass(context, VideoActivity::class.java)
                startActivity(it)
            }
        })
    }

    override fun initView() {
        LogUtil.e(categoryViewModel!!.firstCate.cate_name + "  >>  " + this.toString() + "    " + this.lifecycle.currentState)
    }

    companion object {
        fun createCategoryFragment(firstCate: FirstCate): CategoryFragment {
            val bundle = Bundle()
            bundle.putSerializable(Constant.FIRST_CATE, firstCate)

            val categoryFragment = CategoryFragment()
            categoryFragment.arguments = bundle
            return categoryFragment
        }
    }

}