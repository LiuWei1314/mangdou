package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.AnchorDetailContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */
@ActivityScope
public class AnchorDetailPresenter extends BasePresenter<AnchorDetailContract.Model, AnchorDetailContract.View> {

    @Inject
    public AnchorDetailPresenter(AnchorDetailContract.Model model, AnchorDetailContract.View rootView) {
        super(model, rootView);
    }

    public void init(String userId) {
        mModel.anchorDetail(userId)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<AnchorDetailResponse>() {
                          @Override
                          protected void onNext(AnchorDetailResponse anchorDetailResponse) {

                          }
                      },
                      mRootView.getActivity(),
                      true
              ));
    }
}
