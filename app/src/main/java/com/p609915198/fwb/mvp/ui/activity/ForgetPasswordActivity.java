package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ForgetPasswordContract;
import com.p609915198.fwb.mvp.di.component.DaggerForgetPasswordComponent;
import com.p609915198.fwb.mvp.di.module.ForgetPasswordModule;
import com.p609915198.fwb.mvp.presenter.ForgetPasswordPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码
 * Created by Administrator on 2018/1/5 0005.
 */
public class ForgetPasswordActivity extends BaseActivity<ForgetPasswordPresenter> implements ForgetPasswordContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_phone_num) EditText etPhoneNum;
    @BindView(R.id.bt_next_step) Button btNextStep;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerForgetPasswordComponent
                .builder()
                .baseComponent(baseComponent)
                .forgetPasswordModule(new ForgetPasswordModule(this)) //请将FrogetPasswordModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initData() {
        tvCenter.setText("忘记密码");
        tvCenter.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.bt_next_step})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_next_step:
                String phone = etPhoneNum.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    showToast("手机号码不能为空！");
                    return;
                }
                if (!RegexUtils.isMobileExact(phone)) {
                    showToast("您输入的手机号码有误，请重新输入！");
                    return;
                }
                mPresenter.nextStep(phone);
                break;
        }
    }

    @Override
    public void toNextPage(String code, String phone) {
        Intent intent = new Intent(this, ForgetPassword2Activity.class);
        intent.putExtra("code", code);
        intent.putExtra("phone", phone);
        launchActivity(intent);
        killMyself();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
