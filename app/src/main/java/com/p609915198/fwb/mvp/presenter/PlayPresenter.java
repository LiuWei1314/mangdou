package com.p609915198.fwb.mvp.presenter;

import android.app.Activity;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.PlayContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@ActivityScope
public class PlayPresenter extends BasePresenter<PlayContract.Model, PlayContract.View> {
    @Inject Api mApi;

    @Inject
    public PlayPresenter(PlayContract.Model model, PlayContract.View rootView) {
        super(model, rootView);
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
                               (Activity) mRootView
                       )
            );
    }
}
