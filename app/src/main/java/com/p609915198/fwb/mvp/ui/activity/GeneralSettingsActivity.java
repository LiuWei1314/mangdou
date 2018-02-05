package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.mvp.contract.GeneralSettingsContract;
import com.p609915198.fwb.mvp.di.component.DaggerGeneralSettingsComponent;
import com.p609915198.fwb.mvp.di.module.GeneralSettingsModule;
import com.p609915198.fwb.mvp.presenter.GeneralSettingsPresenter;
import com.p609915198.fwb.mvp.ui.dialog.LogoutDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 通用设置
 * Created by Administrator on 2018/1/4 0004.
 */
public class GeneralSettingsActivity extends BaseActivity<GeneralSettingsPresenter> implements GeneralSettingsContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.bt_send) Button mBtLogin;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerGeneralSettingsComponent
                .builder()
                .baseComponent(baseComponent)
                .generalSettingsModule(new GeneralSettingsModule(this)) //请将GeneralSettingsModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_general_settings;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("通用设置");
        mTvCenter.setVisibility(View.VISIBLE);

        initView();
    }

    public void initView() {
        if (AppConfig.isLogin()) {
            mBtLogin.setText("退出登录");
            mBtLogin.setOnClickListener(v -> {
                LogoutDialog logoutDialog = new LogoutDialog(GeneralSettingsActivity.this);
                logoutDialog.setLogoutListener(() -> {
                    AppConfig.setUserId("");
                    showToast("退出登录成功");
                    EventBus.getDefault().post(new LoginEvent());
                    killMyself();
                });
                logoutDialog.show();
            });
        } else {
            mBtLogin.setText("登录");
            mBtLogin.setOnClickListener(v -> launchActivity(new Intent(this, LoginActivity.class)));
        }
    }

    @OnClick({R.id.tv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
        }
    }

    @Subscribe
    public void loginSuccess(LoginEvent loginEvent) {
        initView();
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }
}
