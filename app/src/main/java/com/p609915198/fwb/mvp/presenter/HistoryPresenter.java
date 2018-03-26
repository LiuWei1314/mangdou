package com.p609915198.fwb.mvp.presenter;

import android.app.Activity;
import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.RecordSearchResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.HistoryContract;
import com.p609915198.fwb.mvp.ui.activity.PlayActivity;
import com.p609915198.fwb.mvp.ui.adapter.HistoryAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/6.
 */
@ActivityScope
public class HistoryPresenter extends BasePresenter<HistoryContract.Model, HistoryContract.View> {
    @Inject Api mApi;

    private HistoryAdapter mHistoryAdapter;

    @Inject
    public HistoryPresenter(HistoryContract.Model model, HistoryContract.View rootView) {
        super(model, rootView);
    }

    public void initAdapter() {
        mApi.recordSearch(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<RecordSearchResponse>>() {
                        @Override
                        protected void onNext(List<RecordSearchResponse> recordSearchRespons) {
                            mHistoryAdapter = new HistoryAdapter(recordSearchRespons);
                            mHistoryAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                                RecordSearchResponse recordResponse = (RecordSearchResponse) adapter.getData().get(position);
                                String roomId = recordResponse.getRoom_id();
                                Intent intent = new Intent((Activity) mRootView, PlayActivity.class);
                                intent.putExtra("roomId", roomId);
                                intent.putExtra("audioList", (ArrayList) recordResponse.getAudio_list());
                                intent.putExtra("audio", recordResponse.getAudio_list().get(position));
                                intent.putExtra("roomDetail", recordResponse.getRoom_detail());
                                mRootView.launchActivity(intent);
                            });
                            mRootView.setAdapter(mHistoryAdapter);
                        }
                    }, (Activity) mRootView)
            );
    }
}
