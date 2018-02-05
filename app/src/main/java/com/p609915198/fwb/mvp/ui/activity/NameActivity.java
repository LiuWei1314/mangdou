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
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.mvp.contract.NameContract;
import com.p609915198.fwb.mvp.di.component.DaggerNameComponent;
import com.p609915198.fwb.mvp.di.module.NameModule;
import com.p609915198.fwb.mvp.presenter.NamePresenter;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 输入昵称
 * Created by Administrator on 2018/1/6.
 */
public class NameActivity extends BaseActivity<NamePresenter> implements NameContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_name) EditText etName;
    @BindView(R.id.bt_finish) Button btFinish;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerNameComponent
                .builder()
                .baseComponent(baseComponent)
                .nameModule(new NameModule(this)) //请将NameModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_name;
    }

    @Override
    protected void initData() {
        tvCenter.setText("设置昵称");
        tvCenter.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.bt_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_finish:
                String name = etName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    showToast("昵称不能为空！");
                    return;
                }
                mPresenter.setName(name);
                break;
        }
    }

    @Override
    public void setNameSuccess() {
        showToast("设置成功");
        Intent intent = new Intent(this, MainActivity.class);
        launchActivity(intent);
        EventBus.getDefault().post(new LoginEvent());
        killMyself();
    }

    @Override
    public void setNameFail(String msg) {
        showToast("设置名称失败：" + msg);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
