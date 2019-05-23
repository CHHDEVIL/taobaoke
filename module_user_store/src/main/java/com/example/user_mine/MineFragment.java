package com.example.user_mine;

import com.example.user_store.R;
import com.example.mvp.BaseFragment;

/**
 * Created by cuihaohao on 2019/5/16
 * Describe:商城我的页面
 */
public class MineFragment extends BaseFragment<MineView, MinePresenter> implements MineView {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_mine;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initClick() {

    }

    @Override
    public MineView createView() {
        return this;
    }

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter(getContext());
    }
}
