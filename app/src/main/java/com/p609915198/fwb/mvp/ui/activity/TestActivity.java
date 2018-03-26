package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.base.BaseApplication;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.request.TopupNewRequest;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.net.response.PayWXResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.aliPay.OrderInfoUtil2_0;
import com.p609915198.fwb.aliPay.PayResult;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.TestContract;
import com.p609915198.fwb.mvp.di.component.DaggerTestComponent;
import com.p609915198.fwb.mvp.di.module.TestModule;
import com.p609915198.fwb.mvp.presenter.TestPresenter;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

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
        btn.setOnClickListener(v -> {
            AppConfig.isLogin();
        });
    }

    public void test() {
        TopupNewRequest request = new TopupNewRequest("29", 0.01, "0");
        mApi.topupNew(JSON.toJSONString(request))
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(
                    new ProgressSubscriber(new SubscriberOnNextListener<ChargeResponse>() {
                        @Override
                        protected void onNext(ChargeResponse response) {
//                            payAli(response);
                        }
                    }, this, false)
            );
    }
}
