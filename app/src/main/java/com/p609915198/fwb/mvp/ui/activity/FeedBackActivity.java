package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.FeedBackContract;
import com.p609915198.fwb.mvp.di.component.DaggerFeedBackComponent;
import com.p609915198.fwb.mvp.di.module.FeedBackModule;
import com.p609915198.fwb.mvp.presenter.FeedBackPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈
 */
public class FeedBackActivity extends BaseActivity<FeedBackPresenter> implements FeedBackContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;

    @Inject Api mApi;
    @BindView(R.id.et) EditText et;
    @BindView(R.id.bt) Button bt;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerFeedBackComponent
                .builder()
                .baseComponent(baseComponent)
                .feedBackModule(new FeedBackModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_feed_back;
    }

    @Override
    public void initData() {
        tvCenter.setText("意见反馈");
        tvCenter.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt:
                String msg = bt.getText().toString();
                if (TextUtils.isEmpty(msg.trim())) {
                    showToast("反馈的内容不能为空");
                } else {
                    mApi.feedBack(AppConfig.getUserId(), msg)
                        .compose(RxUtils.bindToLifecycle(this))
                        .subscribe(new ProgressSubscriber(
                                new SubscriberOnNextListener<HttpResult>() {
                                    @Override
                                    protected void onNext(HttpResult result) {
                                        if (result.getCode() == 200) {
                                            showToast("反馈成功！");
                                            et.setText("");
                                        } else {
                                            showToast("反馈失败！");
                                        }
                                    }
                                },
                                this
                        ));
                }
                break;
        }
    }
}
