package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MineContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class MinePresenter extends BasePresenter<MineContract.Model, MineContract.View> {

    @Inject
    public MinePresenter(MineContract.Model model, MineContract.View rootView) {
        super(model, rootView);
    }

    public void initUserInfo() {
        mModel.userBaseInfo(AppConfig.getUserId())
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<UserBaseInfoResponse>() {
                          @Override
                          protected void onNext(UserBaseInfoResponse userBaseInfoResponse) {
                              mRootView.showUserInfo(userBaseInfoResponse);
                          }
                      },
                      mRootView.getActivityImpl(),
                      false
              ));
    }
}
