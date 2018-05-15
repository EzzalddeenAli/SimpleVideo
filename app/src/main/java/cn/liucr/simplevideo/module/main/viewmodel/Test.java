package cn.liucr.simplevideo.module.main.viewmodel;

import android.arch.lifecycle.LifecycleService;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.liucr.mvvmhelper.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import cn.liucr.simplevideo.mode.sohu.FirstCate;

/**
 * Created by liucr on 2018/5/14.
 */
public class Test {

    private List<BaseFragment> mBaseFragments = new ArrayList<>();

    private Test(String s) {

    }

    public static Test createTest(String s) {
        return new Test(s);
    }
}
