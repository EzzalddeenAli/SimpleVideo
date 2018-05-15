package cn.liucr.simplevideo.module.main.viewmodel;

import android.support.annotation.NonNull;

import com.liucr.mvvmhelper.base.BaseFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucr on 2018/5/14.
 */
public class Test  implements OnLoadMoreListener{

    private List<BaseFragment> mBaseFragments = new ArrayList<>();

    private Test(String s) {

    }

    public static Test createTest(String s) {
        return new Test(s);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }
}
