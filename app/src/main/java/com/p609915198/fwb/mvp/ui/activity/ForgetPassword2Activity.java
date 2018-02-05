package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ForgetPassword2Contract;
import com.p609915198.fwb.mvp.di.component.DaggerForgetPassword2Component;
import com.p609915198.fwb.mvp.di.module.ForgetPassword2Module;
import com.p609915198.fwb.mvp.presenter.ForgetPassword2Presenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/6.
 */
public class ForgetPassword2Activity extends BaseActivity<ForgetPassword2Presenter> implements ForgetPassword2Contract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_phone) TextView tvPhone;
    @BindView(R.id.et_msg) EditText etMsg;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.bt_submit) Button btSubmit;

    private String msg;
    private String phone;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerForgetPassword2Component
                .builder()
                .baseComponent(baseComponent)
                .forgetPassword2Module(new ForgetPassword2Module(this)) //请将ForgetPassword2Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_forget_password_2;
    }

    @Override
    protected void initData() {
        msg = getIntent().getStringExtra("code");
        phone = getIntent().getStringExtra("phone");
        tvCenter.setText("忘记密码");
        tvCenter.setVisibility(View.VISIBLE);
        tvPhone.setText("已向手机" + phone + "发送验证码");
    }

    @OnClick({R.id.tv_left, R.id.bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_submit:
                String code = etMsg.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    showToast("请输入验证码！");
                    return;
                }
                if (!msg.equals(code)) {
                    showToast("您输入的验证码有误！");
                    return;
                }
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(password)) {
                    showToast("密码不能为空！");
                    return;
                }
                mPresenter.resetPassword(phone, password);
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void resetPasswordSuccess() {
        showToast("修改成功！");
        killMyself();
    }
}
