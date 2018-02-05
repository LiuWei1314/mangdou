package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.TitleOfTopContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/4.
 */
@ActivityScope
public class TitleOfTopPresenter extends BasePresenter<TitleOfTopContract.Model, TitleOfTopContract.View> {

    @Inject
    public TitleOfTopPresenter(TitleOfTopContract.Model model, TitleOfTopContract.View rootView) {
        super(model, rootView);
    }

    public void getData(String userId) {
        mModel.top(userId)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<TopResponse>() {
                          @Override
                          protected void onNext(TopResponse topResponse) {
                              mRootView.initViews(topResponse);
                          }
                      },
                      mRootView.getActivity(),
                      true
              ));
    }
}
