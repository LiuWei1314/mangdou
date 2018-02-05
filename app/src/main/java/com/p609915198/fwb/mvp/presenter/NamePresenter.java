package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.NameContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class NamePresenter extends BasePresenter<NameContract.Model, NameContract.View> {

    @Inject
    public NamePresenter(NameContract.Model model, NameContract.View rootView) {
        super(model, rootView);
    }

    public void setName(String name) {
        mModel.setName(name)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<HttpResult>() {
                          @Override
                          protected void onNext(HttpResult httpResult) {
                              if (httpResult.getCode() == 200) {
                                  mRootView.setNameSuccess();
                              } else {
                                  mRootView.setNameFail(httpResult.getMsg());
                              }
                          }
                      },
                      mRootView.getActivity()
              ));
    }
}
