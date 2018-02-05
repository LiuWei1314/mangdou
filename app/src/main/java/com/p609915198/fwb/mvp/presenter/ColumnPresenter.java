package com.p609915198.fwb.mvp.presenter;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.net.response.PayWXResponse;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.aliPay.OrderInfoUtil2_0;
import com.p609915198.fwb.app.aliPay.PayResult;
import com.p609915198.fwb.app.events.PayWxSuccessEvent;
import com.p609915198.fwb.mvp.contract.ColumnContract;
import com.p609915198.fwb.mvp.ui.dialog.PayDialog;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.Subscribe;

import java.util.Map;

import javax.inject.Inject;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
public class ColumnPresenter extends BasePresenter<ColumnContract.Model, ColumnContract.View> {
    private RoomDetailResponse mRoomDetailResponse;
    private static final int SDK_PAY_FLAG = 1001;

    @Inject
    public ColumnPresenter(ColumnContract.Model model, ColumnContract.View rootView) {
        super(model, rootView);
    }

    public void getData(String roomId) {
        mModel.roomDetail(roomId, AppConfig.getUserId())
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<RoomDetailResponse>() {
                          @Override
                          protected void onNext(RoomDetailResponse roomDetailResponse) {
                              mRootView.showViews(roomDetailResponse, roomId);

                              mRoomDetailResponse = roomDetailResponse;
                          }
                      },
                      mRootView.getActivity()
              ));
    }

    public void subcribe(String roomId) {
        mModel.subscribeRoom(roomId, AppConfig.getUserId())
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber(
                                 new SubscriberOnNextListener<HttpResult>() {
                                     @Override
                                     protected void onNext(HttpResult result) {
                                         switch (result.getCode()) {
                                             case 200:
                                                 ToastUtils.showShort("订阅成功！");
                                                 getData(roomId);
                                                 break;
                                             case 201:
                                                 ToastUtils.showShort("请不要重复订阅！");
                                                 break;
                                             default:
                                                 ToastUtils.showShort("订阅失败，请稍后重试！");
                                                 break;
                                         }
                                     }
                                 },
                                 mRootView.getActivity()
                         )
              );
    }

    public void buy(RoomDetailResponse roomDetailResponse, String roomId) {
        PayDialog payDialog = PayDialog.newInstance(roomDetailResponse);
        payDialog.setPayListener((money, payWay) -> {
            String userId = AppConfig.getUserId();
            if (null != mRoomDetailResponse) {
                String valley = mRoomDetailResponse.getRoom_price();
                String key = "{user_id=" + userId + ",valley=" + valley + "}";
                mModel.topupNew(key)
                      .compose(RxUtils.bindToLifecycle(mRootView))
                      .subscribe(
                              new ProgressSubscriber<>(new SubscriberOnNextListener<ChargeResponse>() {
                                  @Override
                                  protected void onNext(ChargeResponse response) {
                                      if (0 == payWay) {
                                          // 支付宝
                                          payAli(response);
                                      } else if (1 == payWay) {
                                          // 微信
                                          payWx(response);
                                      }
                                  }
                              }, mRootView.getActivity(), false)
                      );
            }
        });
        payDialog.show(mRootView.getFraManager());
    }

    public void payWx(ChargeResponse response) {
//        mModel.payWx(response.getPay_price(), response.getDanhao())
        // TODO: 2018/1/23 价格要改
        mModel.payWx(0.01, response.getDanhao())
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<PayWXResponse>() {
                          @Override
                          protected void onNext(PayWXResponse wxResponse) {
                              try {
                                  IWXAPI api = WXAPIFactory.createWXAPI(mRootView.getActivity(), AppConfig.WX_APP_ID, false);
                                  PayReq request = new PayReq();
                                  request.appId = wxResponse.getAppid();
                                  request.partnerId = wxResponse.getPartnerid();
                                  request.prepayId = wxResponse.getPrepayid();
                                  request.packageValue = "Sign=WXPay";
                                  request.nonceStr = wxResponse.getNoncestr();
                                  request.timeStamp = wxResponse.getTimestamp();
                                  request.sign = wxResponse.getSign();
                                  api.sendReq(request);
                              } catch (Exception e) {
                                  e.printStackTrace();
                              }
                          }
                      }, mRootView.getActivity(), false
              ));
    }

    public void payAli(ChargeResponse response) {
        boolean rsa2 = false;
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(0.01, response.getDanhao(), "12", "asdf");
        // TODO: 2018/1/23 价格要改
//        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(response.getPay_price(), response.getDanhao(), "12", "asdf");
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String privateKey = AppConfig.ALI_RSA_PRI_KEY;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;
        //异步处理
        Runnable payRunnable = () -> {
            //新建任务
            PayTask alipay = new PayTask(mRootView.getActivity());
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
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        ToastUtils.showShort("支付成功");
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        ToastUtils.showShort("支付失败");
                    }
                    break;
                }
            }
        }
    };

    @Subscribe
    public void wxPaySuccess(PayWxSuccessEvent event) {
        LogUtils.i("-----------------------------");
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }
}
