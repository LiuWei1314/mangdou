
package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadTask;
import com.blankj.utilcode.util.AppUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AppVersionResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.BuildConfig;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.PlayUtilExecutor;
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.mvp.contract.GeneralSettingsContract;
import com.p609915198.fwb.mvp.di.component.DaggerGeneralSettingsComponent;
import com.p609915198.fwb.mvp.di.module.GeneralSettingsModule;
import com.p609915198.fwb.mvp.presenter.GeneralSettingsPresenter;
import com.p609915198.fwb.mvp.ui.dialog.LogoutDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.p609915198.basemodule.net.UrlConstant.DOWNLOAD_AUDIO_ADDRESS;

/**
 * 通用设置
 * Created by Administrator on 2018/1/4 0004.
 */
public class GeneralSettingsActivity extends BaseActivity<GeneralSettingsPresenter> implements GeneralSettingsContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_timed_close) TextView tvTimedClose;
    @BindView(R.id.tv_account_bingding) TextView tvAccountBingding;
    @BindView(R.id.tv_breakpoint) TextView tvBreakpoint;
    @BindView(R.id.switch_breakpoint) Switch switchBreakpoint;
    @BindView(R.id.tv_clear) TextView tvClear;
    @BindView(R.id.tv_version_introduce) TextView tvVersionIntroduce;
    @BindView(R.id.tv_about) TextView tvAbout;
    @BindView(R.id.bt_send) Button btSend;

    @Inject Api mApi;

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

        switchBreakpoint.setChecked(AppConfig.getInstance().getBreakPoint());
        switchBreakpoint.setOnCheckedChangeListener((buttonView, isChecked) -> AppConfig.getInstance().setBreakPoint(isChecked));

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

    @OnClick({R.id.tv_left, R.id.tv_timed_close, R.id.tv_account_bingding, R.id.tv_breakpoint, R.id.tv_clear, R.id.tv_version_introduce, R.id.tv_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_timed_close:
                PlayUtilExecutor.timerDialog(this);
                break;
            case R.id.tv_clear:
                launchActivity(new Intent(this, ClearActivity.class));
                break;
            case R.id.tv_version_introduce:
                update();
                break;
            case R.id.tv_about:
                launchActivity(new Intent(this, AboutUsActivity.class));
                break;
        }
    }

    private void update() {
        mApi.appVersion()
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<AppVersionResponse>() {
                        @Override
                        protected void onNext(AppVersionResponse response) {
                            if (response.isStatus() && null != response.getData()) {
                                if (BuildConfig.VERSION_NAME.equals(response.getData().getVersion())) {
                                    showToast("当前版本是最新的！");
                                } else {
                                    showToast("当前版本不是最新的，正在为您下载最新版本！");

                                    Aria.download(this)
                                        .load(response.getData().getPath())     //读取下载地址
                                        .setFilePath(DOWNLOAD_AUDIO_ADDRESS + "/忙豆听书.apk") //设置文件保存的完整路径
                                        .start();   //启动下载
                                }
                            }
                        }
                    },
                    this
            ));
    }

    @Download.onTaskComplete
    void taskComplete(DownloadTask task) {
        //在这里处理任务完成的状态
        AppUtils.installApp(task.getDownloadPath(), "");
    }
}
