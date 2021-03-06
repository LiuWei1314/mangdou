package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.QualityContract;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.QualityAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class QualityPresenter extends BasePresenter<QualityContract.Model, QualityContract.View> {
    private QualityAdapter adapter;
    private List<RoomsMoreResponse> data = new ArrayList<>();

    @Inject
    public QualityPresenter(QualityContract.Model model, QualityContract.View rootView) {
        super(model, rootView);
    }

    public void initViews() {
        adapter = new QualityAdapter(data);
        adapter.setHeaderView(mRootView.getHeaderView());
        adapter.addHeaderView(mRootView.getMenuView());
        adapter.addHeaderView(mRootView.getContentView());
        adapter.setFooterView(mRootView.getFooterView());
        adapter.setOnItemClickListener((a, view, position) -> {
            Intent intent = new Intent(mRootView.getActivityImpl(), ColumnActivity.class);
            intent.putExtra("roomId", adapter.getData().get(position).getRoom_id());
            mRootView.launchActivity(intent);
        });
        mRootView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        mModel.getAdData(0).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setHeaderView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));
        mModel.roomsMore("20")
              .map(new Api.HttpResultFunc())
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<RoomsMoreResponse>>() {
                          @Override
                          protected void onNext(List<RoomsMoreResponse> responses) {
                              adapter.setNewData(responses);
                          }
                      },
                      mRootView.getActivityImpl(), false
              ));
        mModel.getAdData(0).subscribe(new ProgressSubscriber<>(
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
