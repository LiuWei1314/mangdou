package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.SetPasswordContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class SetPasswordPresenter extends BasePresenter<SetPasswordContract.Model, SetPasswordContract.View> {

    @Inject
    public SetPasswordPresenter(SetPasswordContract.Model model, SetPasswordContract.View rootView) {
        super(model, rootView);
    }

    public void setPassword(String phone, String password) {
        mModel.register(phone, password)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<Integer>() {
                          @Override
                          protected void onNext(Integer userId) {
                              AppConfig.setUserId(String.valueOf(userId));
                              mRootView.registerSuccess(String.valueOf(userId));
                          }
                      },
                      mRootView.getActivity()
              ));
    }
}
