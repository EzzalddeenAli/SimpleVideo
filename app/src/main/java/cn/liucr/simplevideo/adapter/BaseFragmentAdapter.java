package cn.liucr.simplevideo.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liucr.mvvmhelper.base.BaseFragment;

import java.util.ArrayList;

/**
 * @author sswukang on 2016/6/22 10:17
 * @version 1.0
 *          带泛型的 FragmentPagerAdapter。
 *          第一个构造函数为 FragmentPagerAdapter 常用的构造方式。
 *          第二个构造函数更适合与 ViewPager 搭配使用的控件，如{@link android.support.design.widget.TabLayout}
 */
public class BaseFragmentAdapter<T extends BaseFragment> extends FragmentPagerAdapter {
    private ArrayList<T> fragList; // 碎片集合
    private ArrayList<CharSequence> fragTags; // 碎片tag集合

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public BaseFragmentAdapter(FragmentManager fm, ArrayList<T> fragList) {
        super(fm);
        this.fragList = fragList;
    }

    public BaseFragmentAdapter(FragmentManager fm, ArrayList<T> fragList,
                               ArrayList<CharSequence> fragTags) {
        super(fm);
        this.fragList = fragList;
        this.fragTags = fragTags;

        if (fragList.size() != fragTags.size())
            throw new IllegalArgumentException("Fragment list size must be the same with tag list size.");
    }

    public void setData(ArrayList<T> fragList, ArrayList<CharSequence> fragTags) {
        this.fragList = fragList;
        this.fragTags = fragTags;
        if (fragList.size() != fragTags.size())
            throw new IllegalArgumentException("Fragment list size must be the same with tag list size.");
    }

    @Override
    public T getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        if(fragList == null){
            return 0;
        }
        return fragList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (fragTags == null)
            return "";
        return fragTags.get(position);
    }

}