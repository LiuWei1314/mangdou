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

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class HotPresenter extends BasePresenter<HotContract.Model, HotContract.View> implements HotAdapter.CallBack {

    @Inject
    public HotPresenter(HotContract.Model model, HotContract.View rootView) {
        super(model, rootView);
    }

    public void initHeaderAd(int position) {
        mModel.getAdData(position).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setAdHeaderView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));
    }

    public void initView(int labelType) {
        mModel.getData(labelType)
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<RoomsListResponse>>() {
                          @Override
                          protected void onNext(List<RoomsListResponse> roomsListResponses) {
                              HotAdapter mHotAdapter = new HotAdapter(roomsListResponses);
                              mHotAdapter.setClickListener(HotPresenter.this::clickListener);
                              mHotAdapter.setOnItemChildClickListener(
                                      (adapter, view, position) -> {
                                          switch (view.getId()) {
                                              case R.id.ll_more:
                                                  Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), RoomsMoreActivity.class);
                                                  intent.putExtra("labelId", roomsListResponses.get(position).getLabelid());
                                                  intent.putExtra("label", roomsListResponses.get(position).getLabel());
                                                  mRootView.launchActivity(intent);
                                                  break;
                                              default:
                                                  break;
                                          }
                                      });
                              mRootView.setAdapter(mHotAdapter);
                          }
                      },
                      ((BaseFragment) mRootView).getActivity(),
                      false
              ));
    }

    public void initFooterAd(int position) {
        mModel.getAdData(position).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setAdFooterView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));
    }

    @Override
    public void clickListener(RoomsListResponse.DataBean item) {
        Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), ColumnActivity.class);
        intent.putExtra("roomId", item.getRoom_id());
        mRootView.launchActivity(intent);
    }
}
