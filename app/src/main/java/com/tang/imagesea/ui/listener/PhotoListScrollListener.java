package com.tang.imagesea.ui.listener;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.tang.imagesea.utils.LogUtils;

/**
 * Created by tangsir on 2016/11/25.
 */

public class PhotoListScrollListener extends
        RecyclerView.OnScrollListener {

    int totalItemCount;
    private boolean loading = false;
    private int lastSuccessPage = 0;
    private ScrollEndWorker worker;
    private StaggeredGridLayoutManager mGridLayoutManager;

    public PhotoListScrollListener(
            StaggeredGridLayoutManager mGridLayoutManager, ScrollEndWorker worker) {
        this.mGridLayoutManager = mGridLayoutManager;
        this.worker = worker;
    }

    public void setLoadFinished(int page, boolean success) {
        this.loading = false;
        if (success) {
            lastSuccessPage = page;
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        totalItemCount = mGridLayoutManager.getItemCount();


        int mLastVisiblePos[] = new int[]{0,0};
        mGridLayoutManager.findLastVisibleItemPositions(mLastVisiblePos);
        int lastItem = 0;

        for (int pos : mLastVisiblePos) {
            if (pos>lastItem){
                lastItem = pos;
            }
        }

        LogUtils.showLog("onScrolled, lastItem="+lastItem+",loading="+loading);

        if(lastItem >= (totalItemCount-10) && !loading){
            worker.loadMore(lastSuccessPage+1);
            loading = true;
        }

    }
}

