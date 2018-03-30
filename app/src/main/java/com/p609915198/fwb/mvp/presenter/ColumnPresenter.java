package com.p609915198.fwb.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ColumnContract;
import com.p609915198.fwb.utils.PayUtil;

import javax.inject.Inject;

/**
 * @author mark.liu
 * Created by mark.liu on 2017-10-17.
 */
@ActivityScope
public class ColumnPresenter extends BasePresenter<ColumnContract.Model, ColumnContract.View> {
    @Inject Api mApi;

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
                          }
                      },
                      mRootView.getActivity()
              ));
    }

    public void subcribe(String roomId) {
        mApi.bookRoom(roomId, AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber(
                               new SubscriberOnNextListener<HttpResult>() {
                                   @Override
                                   protected void onNext(HttpResult result) {
                                       switch (result.getCode()) {
                                           case 200:
                                               ToastUtils.showShort("订阅成功！");
                                               mRootView.refreshSubscribe();
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
        PayUtil.buy(mRootView.getActivity(), mApi, mRootView.getFraManager(), Double.valueOf(roomDetailResponse.getRoom_price()));
    }
}
