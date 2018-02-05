package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.SendResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.RegisterContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/30.
 */
@ActivityScope
public class RegisterPresenter extends BasePresenter<RegisterContract.Model, RegisterContract.View> {

    @Inject
    public RegisterPresenter(RegisterContract.Model model, RegisterContract.View rootView) {
        super(model, rootView);
    }

    public void sendMsg(String phone) {
        int code = (int) (1000 + (Math.random() * 8999));
        mModel.send(phone, String.valueOf(code))
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber(
                      new SubscriberOnNextListener<HttpResult<SendResponse>>() {
                          @Override
                          protected void onNext(HttpResult<SendResponse> httpResult) {
                              SendResponse sendResponse = httpResult.getResult();
                              if (200 == sendResponse.getCode()) {
                                  mRootView.showToast("发送成功！");
                                  mRootView.toNextPage(String.valueOf(code), phone);
                              } else {
                                  mRootView.showToast("短信发送失败，请稍后重试！");
                              }
                          }
                      },
                      mRootView.getActivity()
              ));
    }
}
