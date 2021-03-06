package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.HostContract;
import com.p609915198.fwb.mvp.ui.activity.AnchorDetailActivity;
import com.p609915198.fwb.mvp.ui.activity.AnchorMoreActivity;
import com.p609915198.fwb.mvp.ui.adapter.HostAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class HostPresenter extends BasePresenter<HostContract.Model, HostContract.View> {
    private HostAdapter hostAdapter;
    private List<AnchorListResponse> data = new ArrayList<>();

    @Inject
    public HostPresenter(HostContract.Model model, HostContract.View rootView) {
        super(model, rootView);
    }

    public void initViews() {
        hostAdapter = new HostAdapter(data);
        hostAdapter.setHeaderView(mRootView.getHeaderView());
        hostAdapter.setFooterView(mRootView.getFooterView());
        hostAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.ll_more:
                    Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), AnchorMoreActivity.class);
                    intent.putExtra("labelId", hostAdapter.getData().get(position).getLabelid());
                    intent.putExtra("label", hostAdapter.getData().get(position).getLabel());
                    mRootView.launchActivity(intent);
                    break;
            }
        });
        hostAdapter.setCallBack(item -> {
            Intent intent = new Intent(mRootView.getActivityImpl(), AnchorDetailActivity.class);
            intent.putExtra("DataBean", item);
            mRootView.launchActivity(intent);
        });
        mRootView.setAdapter(hostAdapter);

        initData();
    }

    private void initData() {
        mModel.getAdData(8).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setHeaderView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));

        mModel.getData()
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<AnchorListResponse>>() {
                          @Override
                          protected void onNext(List<AnchorListResponse> anchorListResponses) {
                              hostAdapter.setNewData(anchorListResponses);
                          }
                      },
                      ((BaseFragment) mRootView).getActivity(),
                      false
              ));

        mModel.getAdData(7)
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<HomeAdResponse>>() {
                          @Override
                          protected void onNext(List<HomeAdResponse> homeAdRespons) {
                              mRootView.setFooterView(homeAdRespons);
                          }
                      },
                      ((BaseFragment) mRootView).getActivity(),
                      false
              ));
    }
}
