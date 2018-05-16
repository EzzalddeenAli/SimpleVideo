package com.liucr.bindinglibrary.view.recyclerview.decoration;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by liucr on 2018/5/16.
 */

public class GridLayoutDecoration extends RecyclerView.ItemDecoration {

    private int mSpaceMiddle;
    private int mSpaceEdge;

    public GridLayoutDecoration(int size) {
        setSpace(size);
    }

    public void setSpace(int space) {
        mSpaceMiddle = space;
        mSpaceEdge = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int spanCount = 0; //总列数
        int index = 0;  //item在瀑布流里面是第几列
        int position = parent.getChildAdapterPosition(view); //位置
        int spanSize = 0;

        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            index = lp.getSpanIndex();
            spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
            spanSize = lp.getSpanSize();
        } else if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            index = lp.getSpanIndex();
            spanCount = ((StaggeredGridLayoutManager) parent.getLayoutManager()).getSpanCount();
        }

        /**
         * 这种情况是在 MultiItem 布局当中,就是一个 RecycleView 含有多种布局样式
         * 如果是设置了 item 铺满状态, return
         */
        if (spanSize == spanCount) {
            return;
        }

        if (index == 0) { //第一列
            outRect.left = mSpaceEdge * 2;
            outRect.right = mSpaceMiddle;
        } else if (index == spanCount - 1) { //中间
            outRect.left = mSpaceMiddle;
            outRect.right = mSpaceEdge * 2;
        } else { //最后一列
            outRect.left = mSpaceMiddle;
            outRect.right = mSpaceMiddle;
        }

        //第一行顶部
        if (position < spanCount) {
            outRect.top = mSpaceEdge * 2;
        }

        outRect.bottom = mSpaceEdge * 2;
    }
}
