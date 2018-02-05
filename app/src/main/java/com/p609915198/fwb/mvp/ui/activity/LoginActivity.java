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
import com.p609915198.fwb.mvp.contract.LoginContract;
import com.p609915198.fwb.mvp.di.component.DaggerLoginComponent;
import com.p609915198.fwb.mvp.di.module.LoginModule;
import com.p609915198.fwb.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_phone_num) EditText etPhoneNum;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.bt_login) Button btLogin;
    @BindView(R.id.tv_forget_password) TextView tvForgetPassword;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerLoginComponent
                .builder()
                .baseComponent(baseComponent)
                .loginModule(new LoginModule(this)) //请将LoginModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        tvCenter.setText("帐号密码登录");
        tvCenter.setVisibility(View.VISIBLE);
        tvRight.setText("注册");
        tvRight.setTextSize(16);
        tvRight.setTextColor(getResources().getColor(R.color.main_text_selected));
        tvRight.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.bt_login, R.id.tv_forget_password, R.id.iv_wechat_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_right:
                launchActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.bt_login:
                String username = etPhoneNum.getText().toString();
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    showToast("帐号或密码不能为空！");
                    return;
                }
                mPresenter.login(username, password);
                break;
            case R.id.tv_forget_password:
                launchActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.iv_wechat_login:
                mPresenter.wxLogin();
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Intent getIntentImpl() {
        return getIntent();
    }
}
