package cn.liucr.simplevideo.module.main

import android.arch.lifecycle.Observer
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.adapter.BaseFragmentAdapter
import cn.liucr.simplevideo.databinding.ActivityMainBinding
import cn.liucr.simplevideo.mode.sohu.FirstCate
import cn.liucr.simplevideo.module.main.viewmodel.MainViewModel
import com.liucr.mvvmhelper.base.BaseFragment
import com.liucr.mvvmhelper.base.BaseVmActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseVmActivity<ActivityMainBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var fragmentAdapter: BaseFragmentAdapter<BaseFragment<*>>
    private var categoryFragmentList: ArrayList<BaseFragment<*>> = ArrayList()
    private var categoryNameList: ArrayList<CharSequence> = ArrayList()

    override fun contentView(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel() {
        mainViewModel = getViewModel(MainViewModel::class.java, null)
    }

    override fun dataBinding() {
        binding.viewModel = mainViewModel
    }

    override fun initView() {
        setSupportActionBar(toolbar)
        initViewPager()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    /**
     * 初始化viewPager相关东西
     */
    private fun initViewPager() {
        mainTabLayout.setupWithViewPager(mainViewPager)
        fragmentAdapter = BaseFragmentAdapter(supportFragmentManager, categoryFragmentList, categoryNameList)
        mainViewPager.adapter = fragmentAdapter

        mainViewModel.firstCateList.observe(this, Observer<List<FirstCate>> {
            if (it != null) {
                setPagerFragment(it)
            }
        })
    }

    /**
     * 装载分类页面
     */
    private fun setPagerFragment(firstCateList: List<FirstCate>) {
        categoryFragmentList.clear()
        categoryNameList.clear()

        firstCateList.forEach {
            val categoryFragment = CategoryFragment.createCategoryFragment(it)
            categoryFragmentList.add(categoryFragment)
            categoryNameList.add(it.cate_name)
        }
        fragmentAdapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_search -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
