package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.RoomsListResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.HotContract;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;
import com.p609915198.fwb.mvp.ui.adapter.HotAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class HotPresenter extends BasePresenter<HotContract.Model, HotContract.View> {
    private HotAdapter mAdapter;

    @Inject
    public HotPresenter(HotContract.Model model, HotContract.View rootView) {
        super(model, rootView);
    }

    public void initViews() {
        mAdapter = new HotAdapter(new ArrayList<>());
        mAdapter.setHeaderView(mRootView.getHeaderView());
        mAdapter.addHeaderView(mRootView.getMenuView());
        mAdapter.setFooterView(mRootView.getFooterView());
        mAdapter.setClickListener(item -> {
            Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), ColumnActivity.class);
            intent.putExtra("roomId", item.getRoom_id());
            mRootView.launchActivity(intent);
        });
        mAdapter.setOnItemChildClickListener(
                (adapter, view, position) -> {
                    switch (view.getId()) {
                        case R.id.ll_more:
                            Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), RoomsMoreActivity.class);
                            intent.putExtra("labelId", mAdapter.getData().get(position).getLabelid());
                            intent.putExtra("label", mAdapter.getData().get(position).getLabel());
                            mRootView.launchActivity(intent);
                            break;
                        default:
                            break;
                    }
                });
        mRootView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        mModel.getAdData(6).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setHeaderView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));

        mModel.getData(2)
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<RoomsListResponse>>() {
                          @Override
                          protected void onNext(List<RoomsListResponse> roomsListResponses) {
                              mAdapter.setNewData(roomsListResponses);
                          }
                      },
                      ((BaseFragment) mRootView).getActivity(),
                      false
              ));

        mModel.getAdData(5).subscribe(new ProgressSubscriber<>(
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
