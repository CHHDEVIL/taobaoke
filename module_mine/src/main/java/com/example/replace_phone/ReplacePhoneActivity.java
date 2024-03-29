package com.example.replace_phone;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_mine.R;
import com.example.module_mine.R2;
import com.example.mvp.BaseActivity;
import com.example.utils.CountDownTimerUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 修改手机号
 */
public class ReplacePhoneActivity extends BaseActivity<ReplacePhoneView, ReplacePhonePresenter> implements ReplacePhoneView {
    @BindView(R2.id.include_back)
    ImageView includeBack;
    @BindView(R2.id.include_title)
    TextView includeTitle;
    @BindView(R2.id.phone_old_num)
    EditText phoneOldNum;
    @BindView(R2.id.phone_new_num)
    EditText phoneNewNum;
    @BindView(R2.id.phone_code)
    EditText phoneCode;
    @BindView(R2.id.phone_get_code)
    TextView phoneGetCode;
    @BindView(R2.id.phone_btn)
    TextView phoneBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_replace_phone;
    }

    @Override
    public void initData() {
        includeTitle.setText(getResources().getString(R.string.update_phone));
    }

    @Override
    public void initClick() {
        includeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        phoneGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getCodeNum();
            }
        });

        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.commit(phoneOldNum.getText().toString(), phoneNewNum.getText().toString(), phoneCode.getText().toString());
            }
        });
    }

    @Override
    public void getCodeSuccess() {
        phoneGetCode.setEnabled(false);
        phoneGetCode.setBackgroundResource(R.drawable.bg_get_code_clicked);
        CountDownTimerUtil.startTimer(this, phoneGetCode);
    }

    @Override
    public ReplacePhoneView createView() {
        return this;
    }

    @Override
    public ReplacePhonePresenter createPresenter() {
        return new ReplacePhonePresenter(this);
    }
}
