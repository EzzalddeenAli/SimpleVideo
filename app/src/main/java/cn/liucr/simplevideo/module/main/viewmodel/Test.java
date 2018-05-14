package cn.liucr.simplevideo.module.main.viewmodel;

import android.arch.lifecycle.LifecycleService;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import cn.liucr.simplevideo.mode.sohu.FirstCate;

/**
 * Created by liucr on 2018/5/14.
 */
public class Test {

    private MutableLiveData<List<FirstCate>> mMutableLiveData = new MutableLiveData<>();

    private Test(String s) {
        mMutableLiveData.observe(new LifecycleService(), new Observer<List<FirstCate>>() {
            @Override
            public void onChanged(@Nullable List<FirstCate> firstCates) {

            }
        });
    }

    public static Test createTest(String s) {
        return new Test(s);
    }
}
