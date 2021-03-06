package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.AnchorDetailContract;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.AnchorDetailAdapter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */
@ActivityScope
public class AnchorDetailPresenter extends BasePresenter<AnchorDetailContract.Model, AnchorDetailContract.View> {
    private AnchorDetailAdapter mAnchorDetailAdapter;

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
                              mAnchorDetailAdapter = new AnchorDetailAdapter(anchorDetailResponse.getClassics_works());
                              mAnchorDetailAdapter.setOnItemClickListener((adapter, view, position) -> {
                                  Intent intent = new Intent(mRootView.getActivity(), ColumnActivity.class);
                                  intent.putExtra("roomId", anchorDetailResponse.getClassics_works().get(position).getRoom_id());
                                  mRootView.launchActivity(intent);
                              });
                              mRootView.setAdapter(mAnchorDetailAdapter);
                          }
                      },
                      mRootView.getActivity(),
                      true
              ));
    }
}
