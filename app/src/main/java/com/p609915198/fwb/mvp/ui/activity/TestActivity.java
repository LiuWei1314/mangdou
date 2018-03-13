package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.TestContract;
import com.p609915198.fwb.mvp.di.component.DaggerTestComponent;
import com.p609915198.fwb.mvp.di.module.TestModule;
import com.p609915198.fwb.mvp.presenter.TestPresenter;
import com.vondear.rxtools.interfaces.OnRequestListener;
import com.vondear.rxtools.module.wechat.pay.WechatModel;
import com.vondear.rxtools.module.wechat.pay.WechatPayTools;

import javax.inject.Inject;

import butterknife.BindView;


public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View {
    @BindView(R.id.btn) Button btn;

    @Inject Api mApi;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerTestComponent
                .builder()
                .baseComponent(baseComponent)
                .testModule(new TestModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_test;
    }

    @Override
    public void initData() {
        btn.setOnClickListener(v -> test());
    }

    public void test() {
        String valley = "0.01";
        String key = "{user_id=" + 29 + ",valley=" + valley + "}";
        mApi.topupNew(key)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(
                    new ProgressSubscriber<>(new SubscriberOnNextListener<ChargeResponse>() {
                        @Override
                        protected void onNext(ChargeResponse response) {
                            WechatPayTools.wechatPayApp(TestActivity.this,
                                                        AppConfig.WX_APP_ID, //微信分配的APP_ID
                                                        AppConfig.WX_PARTNER_ID, //微信分配的 PARTNER_ID (商户ID)
                                                        AppConfig.WX_SECRET, //微信分配的 PRIVATE_KEY (私钥)
                                                        response.getDanhao(), //订单ID (唯一)
                                                        new OnRequestListener() {
                                                            @Override
                                                            public void onSuccess(String s) {
                                                                ToastUtils.showLong("支付成功");
                                                            }

                                                            @Override
                                                            public void onError(String s) {
                                                                ToastUtils.showLong("支付失败");
                                                            }
                                                        });
                        }
                    }, this, false)
            );
    }
}
