package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.ForgetPassword2Contract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class ForgetPassword2Presenter extends BasePresenter<ForgetPassword2Contract.Model, ForgetPassword2Contract.View> {

    @Inject
    public ForgetPassword2Presenter(ForgetPassword2Contract.Model model, ForgetPassword2Contract.View rootView) {
        super(model, rootView);
    }

    public void resetPassword(String phone, String password) {
        mModel.resetPassword(phone, password)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber(
                      new SubscriberOnNextListener() {
                          @Override
                          protected void onNext(Object o) {
                              mRootView.resetPasswordSuccess();
                          }
                      },
                      mRootView.getActivity()
              ));
    }
}
