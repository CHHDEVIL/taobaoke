package com.example.order_assess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.module_user_mine.R;
import com.example.module_user_mine.R2;
import com.example.mvp.BaseActivity;
import com.example.order_assess.adapter.OrderAssessAdapter;
import com.example.utils.SpaceItemDecoration;
import com.example.view.RatingBarView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAssessActivity extends BaseActivity<OrderAssessView, OrderAssessPresenter> implements OrderAssessView {
    @BindView(R2.id.include_back)
    ImageView includeBack;
    @BindView(R2.id.include_title)
    TextView includeTitle;
    @BindView(R2.id.order_assess_img)
    ImageView orderAssessImg;
    @BindView(R2.id.order_assess_name)
    TextView orderAssessName;
    @BindView(R2.id.order_assess_good)
    RadioButton orderAssessGood;
    @BindView(R2.id.order_assess_middle)
    RadioButton orderAssessMiddle;
    @BindView(R2.id.order_assess_bad)
    RadioButton orderAssessBad;
    @BindView(R2.id.order_assess_radio_group)
    RadioGroup orderAssessRadioGroup;
    @BindView(R2.id.order_assess_edit)
    EditText orderAssessEdit;
    @BindView(R2.id.order_assess_rv)
    RecyclerView orderAssessRv;
    @BindView(R2.id.order_assess_depict)
    RatingBarView orderAssessDepict;
    @BindView(R2.id.order_assess_logistics)
    RatingBarView orderAssessLogistics;
    @BindView(R2.id.order_assess_service)
    RatingBarView orderAssessService;
    @BindView(R2.id.order_assess_niming_img)
    CheckBox orderAssessNimingImg;
    @BindView(R2.id.order_assess_niming)
    LinearLayout orderAssessNiming;
    @BindView(R2.id.order_assess_btn)
    TextView orderAssessBtn;
    @BindView(R2.id.order_assess_addpic)
    ImageView mAddPic;

    private final int TAKE_PHOTO_CODE = 0x111;
    private final int PHOTO_ALBUM_CODE = 0x222;
    private boolean isNiming = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_assess;
    }

    @Override
    public void initData() {
        includeTitle.setText("订单评价");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        orderAssessRv.setLayoutManager(layoutManager);
        orderAssessRv.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10), 0, 0, 0));
        presenter.loadData();
    }

    @Override
    public void initClick() {
        includeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        orderAssessNiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNiming = !isNiming;
                orderAssessNimingImg.setChecked(isNiming);
            }
        });

        mAddPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addPic();
            }
        });
    }

    @Override
    public void showAdd() {
        mAddPic.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideAdd() {
        mAddPic.setVisibility(View.GONE);
    }

    @Override
    public void showRv() {
        orderAssessRv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRv() {
        orderAssessRv.setVisibility(View.GONE);
    }

    @Override
    public void loadRv(OrderAssessAdapter adapter) {
        orderAssessRv.setAdapter(adapter);
    }

    @Override
    public void takePhoto(Intent intent) {
        startActivityForResult(intent, TAKE_PHOTO_CODE);
    }

    @Override
    public void photoAlbum(Intent intent) {
        startActivityForResult(intent, PHOTO_ALBUM_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case TAKE_PHOTO_CODE:
                presenter.updateList();
                break;
            case PHOTO_ALBUM_CODE:
                presenter.parseUri(data);
                break;
        }
    }

    @Override
    public OrderAssessView createView() {
        return this;
    }

    @Override
    public OrderAssessPresenter createPresenter() {
        return new OrderAssessPresenter(this);
    }
}
