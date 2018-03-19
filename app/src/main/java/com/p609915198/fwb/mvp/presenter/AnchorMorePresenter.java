package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AnchorMoreResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.AnchorMoreContract;
import com.p609915198.fwb.mvp.ui.activity.AnchorDetailActivity;
import com.p609915198.fwb.mvp.ui.adapter.AnchorMoreAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
public class AnchorMorePresenter extends BasePresenter<AnchorMoreContract.Model, AnchorMoreContract.View> {
    private AnchorMoreAdapter adapter;

    @Inject
    public AnchorMorePresenter(AnchorMoreContract.Model model, AnchorMoreContract.View rootView) {
        super(model, rootView);
    }

    public void initData(String labelId, String label) {
        mModel.anchorMore(labelId)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<AnchorMoreResponse>>() {
                          @Override
                          protected void onNext(List<AnchorMoreResponse> anchorMoreResponses) {
                              adapter = new AnchorMoreAdapter(anchorMoreResponses);
                              adapter.setOnItemClickListener((adapter, view, position) -> {
                                  // 主播详情
                                  Intent intent = new Intent(mRootView.getActivity(), AnchorDetailActivity.class);
                                  intent.putExtra("AnchorMoreResponse", anchorMoreResponses.get(position));
                                  mRootView.launchActivity(intent);
                              });
                              adapter.setOnItemChildClickListener((adapter, view, position) -> {
                                  switch (view.getId()) {
                                      case R.id.tv_subscribe:
                                          // 订阅
                                          if (AppConfig.isLogin()) {

                                          } else {
                                              mRootView.showToast("请先登录！");
                                          }
                                          break;
                                  }
                              });
                              mRootView.setAdapter(adapter);
                          }
                      },
                      mRootView.getActivity()
              ));
    }

    public void subscribe() {
      /*  mModel.subscribe()
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<HttpResult>() {
                          @Override
                          protected void onNext(HttpResult httpResult) {
                              if (200 == httpResult.getCode()) {
                                  mRootView.showToast("订阅成功！");
                              } else {
                                  mRootView.showToast("订阅失败！");
                              }
                          }
                      },
                      mRootView.getActivity()
              ));*/
    }
}
