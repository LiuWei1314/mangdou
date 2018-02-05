package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.ClassifyDetailContract;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;
import com.p609915198.fwb.mvp.ui.adapter.SecondaryCategoryAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
public class ClassifyDetailPresenter extends BasePresenter<ClassifyDetailContract.Model, ClassifyDetailContract.View> {
    private SecondaryCategoryAdapter mAdapter;

    @Inject
    public ClassifyDetailPresenter(ClassifyDetailContract.Model model, ClassifyDetailContract.View rootView) {
        super(model, rootView);
    }

    public void secondCategory(String labelId) {
        mModel.secondaryCategory(labelId)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<SecondaryCategoryResponse>>() {
                          @Override
                          protected void onNext(List<SecondaryCategoryResponse> secondaryCategoryResponses) {
                              mAdapter = new SecondaryCategoryAdapter(secondaryCategoryResponses);
                              mAdapter.setOnItemClickListener((adapter, view, position) -> {
                                  Intent intent = new Intent(mRootView.getActivity(), RoomsMoreActivity.class);
                                  intent.putExtra("labelId", mAdapter.getData().get(position).getCategory_secondary_id());
                                  intent.putExtra("label", mAdapter.getData().get(position).getCategory_secondary_name());
                                  mRootView.launchActivity(intent);
                              });
                              mRootView.setAdapter(mAdapter);
                          }
                      },
                      mRootView.getActivity(),
                      true
              ));
    }
}
