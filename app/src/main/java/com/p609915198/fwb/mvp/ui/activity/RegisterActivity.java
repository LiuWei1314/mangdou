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
import com.p609915198.fwb.mvp.contract.RegisterContract;
import com.p609915198.fwb.mvp.di.component.DaggerRegisterComponent;
import com.p609915198.fwb.mvp.di.module.RegisterModule;
import com.p609915198.fwb.mvp.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 手机注册
 * Created by Administrator on 2017/12/30.
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_phone_num) EditText etPhoneNum;
    @BindView(R.id.bt_send) Button btLogin;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerRegisterComponent
                .builder()
                .baseComponent(baseComponent)
                .registerModule(new RegisterModule(this)) //请将RegisterModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        tvCenter.setText("手机注册");
        tvCenter.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.bt_send, R.id.tv_register_protocol})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_send:
                String phone = etPhoneNum.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    showToast("手机号码不能为空！");
                    return;
                }
                if (!RegexUtils.isMobileExact(phone)) {
                    showToast("您输入的手机号码有误，请重新输入！");
                    return;
                }
                mPresenter.sendMsg(phone);
                break;
            case R.id.tv_register_protocol:
                break;
        }
    }

    @Override
    public void toNextPage(String msg, String phone) {
        Intent intent = new Intent(this, Register2Activity.class);
        intent.putExtra("msg", msg);
        intent.putExtra("phone", phone);
        launchActivity(intent);
        killMyself();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
