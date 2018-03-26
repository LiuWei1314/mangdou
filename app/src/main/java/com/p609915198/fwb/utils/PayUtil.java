package com.p609915198.fwb.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;

import com.alibaba.fastjson.JSON;
import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.request.TopupNewRequest;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.net.response.PayWXResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.aliPay.OrderInfoUtil2_0;
import com.p609915198.fwb.aliPay.PayResult;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.ui.dialog.PayDialog;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

/**
 * Created by mark.liu on 2018-3-23.
 */
public class PayUtil {
    public static void buy(Activity context, Api mApi, FragmentManager fragmentManager, double price) {
        PayDialog payDialog = PayDialog.newInstance(price);
        payDialog.setPayListener((money, payWay) -> {
            String type = "0";// todo支付类型 0=冲值|1=打赏|2=礼物
            TopupNewRequest request = new TopupNewRequest(AppConfig.getUserId(), price, type);
            mApi.topupNew(JSON.toJSONString(request))
                .compose(RxUtils.bindToLifecycle((IView) context))
                .subscribe(
                        new ProgressSubscriber<>(new SubscriberOnNextListener<ChargeResponse>() {
                            @Override
                            protected void onNext(ChargeResponse response) {
                                switch (payWay) {
                                    case 0:
                                        // 支付宝
                                        payAli(response, context);
                                        break;
                                    case 1:
                                        // 微信
                                        payWx(response, context, mApi);
                                        break;
                                }
                            }
                        }, context, false)
                );
        });
        payDialog.show(fragmentManager);
    }

    private static void payWx(ChargeResponse response, Activity context, Api mApi) {
        mApi.payWX(response.getPay_price(), response.getDanhao())
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<PayWXResponse>() {
                        @Override
                        protected void onNext(PayWXResponse wxResponse) {
                            IWXAPI mIWXAPI = WXAPIFactory.createWXAPI(context, AppConfig.WX_APP_ID, true);
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
                    }, context, false
            ));
    }

    private static void payAli(ChargeResponse response, Activity context) {
        boolean rsa2 = true;
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(AppConfig.ALI_APP_ID, rsa2, response.getPay_price(), response.getDanhao());
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String privateKey = AppConfig.RSA2_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;
        //异步处理
        Runnable payRunnable = () -> {
            //新建任务
            PayTask alipay = new PayTask(context);
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

    private static final int SDK_PAY_FLAG = 100;

    private static Handler mHandler = new Handler() {
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
