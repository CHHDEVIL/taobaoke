package com.example.order.fragment_all;

import android.content.Context;

import com.example.module_mine.R;
import com.example.mvp.BasePresenter;
import com.example.order.adapter.RvListAdapter;

import java.util.List;

public class AllOrderPresenter extends BasePresenter<AllOrderView> {

    private RvListAdapter adapter;

    public AllOrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected void onViewDestroy() {

    }

    public void loadData(List list) {
        if (adapter == null) {
            adapter = new RvListAdapter(mContext, list, R.layout.rv_order_list);
            getView().loadUI(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
