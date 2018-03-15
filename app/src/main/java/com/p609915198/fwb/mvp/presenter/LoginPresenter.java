package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.mvp.contract.LoginContract;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;


/**
 * Created by mark.liu on 2017-9-12.
 */
@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {

    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }

    public void login(String username, String password) {
        mModel.login(username, password)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<String>() {
                          @Override
                          protected void onNext(String userId) {
                              AppConfig.setUserId(userId);
                              EventBus.getDefault().post(new LoginEvent());
                              mRootView.killMyself();
                          }
                      },
                      mRootView.getActivity()
              ));
    }

    public void wxLogin() {
    }
}
