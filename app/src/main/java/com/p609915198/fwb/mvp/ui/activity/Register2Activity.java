package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.Register2Contract;
import com.p609915198.fwb.mvp.di.component.DaggerRegister2Component;
import com.p609915198.fwb.mvp.di.module.Register2Module;
import com.p609915198.fwb.mvp.presenter.Register2Presenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 输入验证码
 * Created by Administrator on 2018/1/6.
 */
public class Register2Activity extends BaseActivity<Register2Presenter> implements Register2Contract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_phone) TextView tvPhone;
    @BindView(R.id.et_msg) EditText etMsg;
    @BindView(R.id.bt_register) Button btRegister;

    private String msg;
    private String phone;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerRegister2Component
                .builder()
                .baseComponent(baseComponent)
                .register2Module(new Register2Module(this)) //请将Register2Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_register2;
    }

    @Override
    protected void initData() {
        msg = getIntent().getStringExtra("msg");
        phone = getIntent().getStringExtra("phone");

        tvCenter.setText("手机注册");
        tvCenter.setVisibility(View.VISIBLE);
        tvPhone.setText("你的手机号：" + phone);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void toNextPage(String phone) {
        Intent intent = new Intent(this, SetPasswordActivity.class);
        intent.putExtra("phone", phone);
        launchActivity(intent);
        killMyself();
    }

    @OnClick({R.id.tv_left, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_register:
                String code = etMsg.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    showToast("验证码不能为空！");
                    return;
                }
                if (msg.equals(code)) {
                    mPresenter.register(msg, phone);
                } else {
                    showToast("您输入的验证码有误！");
                }
                break;
        }
    }
}
