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
import com.p609915198.fwb.mvp.contract.SetPasswordContract;
import com.p609915198.fwb.mvp.di.component.DaggerSetPasswordComponent;
import com.p609915198.fwb.mvp.di.module.SetPasswordModule;
import com.p609915198.fwb.mvp.presenter.SetPasswordPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置密码
 * Created by Administrator on 2018/1/6.
 */
public class SetPasswordActivity extends BaseActivity<SetPasswordPresenter> implements SetPasswordContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.bt_next) Button btNext;

    private String phone;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerSetPasswordComponent
                .builder()
                .baseComponent(baseComponent)
                .setPasswordModule(new SetPasswordModule(this)) //请将SetPasswordModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_set_password;
    }

    @Override
    protected void initData() {
        tvCenter.setText("设置密码");
        tvCenter.setVisibility(View.VISIBLE);

        phone = getIntent().getStringExtra("phone");
    }

    @OnClick({R.id.tv_left, R.id.bt_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_next:
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(password)) {
                    showToast("密码不能为空！");
                    return;
                }
                if (password.length() < 6) {
                    showToast("您输入的密码太短了！");
                    return;
                }
                mPresenter.setPassword(phone, password);
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void registerSuccess(String userId) {
        showToast("注册成功！");
        Intent intent = new Intent(this, NameActivity.class);
        launchActivity(intent);
        killMyself();
    }
}
