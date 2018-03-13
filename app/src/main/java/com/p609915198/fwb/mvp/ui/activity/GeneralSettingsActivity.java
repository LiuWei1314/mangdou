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

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * 通用设置
 * Created by Administrator on 2018/1/4 0004.
 */
public class GeneralSettingsActivity extends BaseActivity<GeneralSettingsPresenter> implements GeneralSettingsContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_3) TextView tv3;
    @BindView(R.id.tv_4) TextView tv4;
    @BindView(R.id.tv_5) TextView tv5;
    @BindView(R.id.bt_send) Button btSend;

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
        tvCenter.setText("通用设置");
        tvCenter.setVisibility(View.VISIBLE);

//        switch1.setChecked(AppConfig.getPush());
//        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                AppConfig.setPush(isChecked);
//            }
//        });
//        switch2.setChecked(AppConfig.getFlowProtect());
//        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                AppConfig.setFlowProtect(isChecked);
//            }
//        });

        initView();
    }

    public void initView() {
        if (AppConfig.isLogin(false)) {
            btSend.setText("退出登录");
            btSend.setOnClickListener(v -> {
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
            btSend.setText("登录");
            btSend.setOnClickListener(v -> launchActivity(new Intent(this, LoginActivity.class)));
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

    @OnClick({R.id.tv_3, R.id.tv_4, R.id.tv_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_3:
                launchActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.tv_4:
                Observable.timer(500, TimeUnit.MILLISECONDS)
                          .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(c -> showToast("清除成功！"));
                break;
            case R.id.tv_5:
                Observable.timer(500, TimeUnit.MILLISECONDS)
                          .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(c -> showToast("清除成功！"));
                break;
            case R.id.tv_left:
                killMyself();
                break;
        }
    }
}
