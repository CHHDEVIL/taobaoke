package com.example.commidity_list;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mvp.BasePresenter;

public class CommidityListPresenter extends BasePresenter<CommidityListView> {
    public CommidityListPresenter(Context context) {
        super(context);
    }

    @Override
    protected void onViewDestroy() {

    }
}