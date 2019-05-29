package com.example.browsinghistory.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.adapter.MyRecyclerAdapter;
import com.example.adapter.RecyclerViewHolder;
import com.example.browsinghistory.bean.BrowsingHistoryChildBean;
import com.example.browsinghistory.bean.BrowsingHistoryParentBean;
import com.example.module_user_mine.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihaohao on 2019/5/27
 * Describe:
 */
public class BrowsingHistoryParentAdapter extends MyRecyclerAdapter<BrowsingHistoryParentBean> {

    private boolean isParentCompile;
    private BrowsingHistoryChildAdapter browsingHistoryChildAdapter;
    private List<BrowsingHistoryChildBean> list;
    private boolean flag = true;

    public BrowsingHistoryParentAdapter(Context context, List<BrowsingHistoryParentBean> mList, int mLayoutId) {
        super(context, mList, mLayoutId);
    }

    public BrowsingHistoryParentAdapter(Context context, List<BrowsingHistoryParentBean> mList, int mLayoutId, boolean parentCompile) {
        super(context, mList, mLayoutId);
        this.isParentCompile = parentCompile;
    }

    @Override
    public void convert(RecyclerViewHolder holder, BrowsingHistoryParentBean data, int position) {
        holder.setText(R.id.browsing_history_parent_time, data.getTime());
        if (isParentCompile) {
            holder.getView(R.id.browsing_history_parent_check).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.browsing_history_parent_check).setVisibility(View.GONE);
        }
        viewOnClickListener.ViewOnClick(holder.getView(R.id.browsing_history_parent_check), position);

        RecyclerView browsingHistoryParentRec = holder.getView(R.id.browsing_history_parent_rec);
        list = new ArrayList<>();
        list.add(new BrowsingHistoryChildBean(R.drawable.img_108, "2019夏季新款纯棉白色短袖女T恤个性字母简约......", "￥39.90", "12345人付款", "97%好评", "班迪卡旗舰店", false));
        list.add(new BrowsingHistoryChildBean(R.drawable.img_108, "2019夏季新款纯棉白色短袖女T恤个性字母简约......", "￥39.90", "12345人付款", "97%好评", "班迪卡旗舰店", false));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        browsingHistoryParentRec.setLayoutManager(linearLayoutManager);
        browsingHistoryChildAdapter = new BrowsingHistoryChildAdapter(context, list, R.layout.item_browsing_history_child, false);
        browsingHistoryParentRec.setAdapter(browsingHistoryChildAdapter);

        browsingHistoryChildAdapter.setViewTwoOnClickListener(new ViewTwoOnClickListener() {
            @Override
            public void ViewTwoOnClick(final View view1, View view2, final int position) {
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        flag = true;
                        check(position);
                    }
                });

                view2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
        browsingHistoryChildAdapter.setChildCompile(isParentCompile);
    }

    //选中recycler的item
    private void check(int position) {

        if (list.get(position).isCheck()) {
            list.get(position).setCheck(false);
        } else {
            list.get(position).setCheck(true);
        }

        browsingHistoryChildAdapter.notifyDataSetChanged();

//        for (int i = 0; i < list.size(); i++) {
//            if (!list.get(i).isCheck()) {
//                isCheckAll = false;
//                flag = false;
//            }
//
//        }

//        if (getView() != null) {
//            getView().isCheckAll(flag);
//        }

    }

    public void setCompile(boolean compile) {
        isParentCompile = compile;
        notifyDataSetChanged();
    }
}
