package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.widget.Button;

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
import com.vondear.rxtools.module.alipay.AliPayModel;
import com.vondear.rxtools.module.alipay.AliPayTools;
import com.vondear.rxtools.view.RxToast;

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
                            pay("0.01", response.getDanhao());
                        }
                    }, this, false)
            );
    }

    public void pay(String money, String danhao) {
        AliPayTools.aliPay(this,
                           AppConfig.ALI_ID,//支付宝分配的APP_ID
                           false,//是否是 RSA2 加密
                           AppConfig.ALI_RSA_PRI_KEY,// RSA 或 RSA2 字符串
                           new AliPayModel(danhao,//订单ID (唯一)
                                           money,//价格
                                           "忙豆测试",//商品名称
                                           "忙豆详情测试"),//商品描述详情 (用于显示在 支付宝 的交易记录里)
                           new OnRequestListener() {
                               @Override
                               public void onSuccess(String s) {RxToast.success("支付成功");}

                               @Override
                               public void onError(String s) {
                                   RxToast.error("支付失败");
                               }
                           });
    }
}
