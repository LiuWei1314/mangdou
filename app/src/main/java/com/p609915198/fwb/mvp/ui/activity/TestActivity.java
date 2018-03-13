package com.p609915198.fwb.mvp.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseActivity;
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
        btn.setOnClickListener(v -> test());
    }

    public void test() {
        String volley = "0.01";
        TopupNewRequest request = new TopupNewRequest("29", volley, "0");
        mApi.topupNew(JSON.toJSONString(request))
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(
                    new ProgressSubscriber(new SubscriberOnNextListener<ChargeResponse>() {
                        @Override
                        protected void onNext(ChargeResponse response) {
                            WXpay(response.getPay_price(), response.getDanhao());

//                            payAli(response);
                        }
                    }, this, false)
            );
    }

    public void WXpay(double price, String danhao) {
        mApi.payWX(price, danhao)
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<PayWXResponse>() {
                        @Override
                        protected void onNext(PayWXResponse wxResponse) {
                            IWXAPI mIWXAPI = WXAPIFactory.createWXAPI(TestActivity.this, AppConfig.WX_APP_ID, true);
                            mIWXAPI.registerApp(AppConfig.WX_APP_ID);
                            try {
                                PayReq req = new PayReq();
                                req.appId = wxResponse.getAppid();
                                req.partnerId = wxResponse.getPartnerid();
                                req.prepayId = wxResponse.getPrepayid();
                                req.nonceStr = wxResponse.getNoncestr();
                                req.timeStamp = wxResponse.getTimestamp();
                                req.packageValue = "Sign=WXPay";
                                req.sign = wxResponse.getSign();
                                mIWXAPI.sendReq(req);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, this, false
            ));
    }

    public void payAli(ChargeResponse response) {
        /*AliPayTools.aliPay(mRootView.getActivity(),
                           AppConfig.ALI_APP_ID,//支付宝分配的APP_ID
                           true,//是否是 RSA2 加密
                           AppConfig.RSA2_PRIVATE,// RSA 或 RSA2 字符串
                           new AliPayModel(response.getDanhao(),//订单ID (唯一)
                                           String.valueOf(response.getPay_price()),//价格
                                           "忙豆听书",//商品名称
                                           "忙豆听书"),//商品描述详情 (用于显示在 支付宝 的交易记录里)
                           new OnRequestListener() {
                               @Override
                               public void onSuccess(String s) {
                                   ToastUtils.showLong("支付成功");
                               }

                               @Override
                               public void onError(String s) {
                                   ToastUtils.showLong("支付失败");
                               }
                           });*/

        boolean rsa2 = true;
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(AppConfig.ALI_APP_ID, rsa2, response.getPay_price(), response.getDanhao());
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String privateKey = AppConfig.RSA2_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;
        //异步处理
        Runnable payRunnable = () -> {
            //新建任务
            PayTask alipay = new PayTask(TestActivity.this);
            //获取支付结果
            Map<String, String> result = alipay.payV2(orderInfo, true);
            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = result;
            mHandler.sendMessage(msg);
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private final int SDK_PAY_FLAG = 100;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    String s;
                    switch (resultStatus) {
                        case "9000":
                            s = "支付成功";
                            break;
                        case "6001":
                            s = "支付取消";
                            break;
                        default:
                            s = "支付失败";
                            break;
                    }
                    ToastUtils.showShort(s);
                    break;
                }
            }
        }
    };
}
