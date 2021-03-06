package com.p609915198.fwb.mvp.presenter;

import android.app.Activity;
import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.RecordSearchResponse;
import com.p609915198.basemodule.net.response.RecordSearchResult;
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
    private List<RecordSearchResponse> data = new ArrayList<>();

    @Inject
    public HistoryPresenter(HistoryContract.Model model, HistoryContract.View rootView) {
        super(model, rootView);
    }

    public void initAdapter() {
        mHistoryAdapter = new HistoryAdapter(data);
        mHistoryAdapter.setOnItemClickListener((adapter, view, position) -> {
            RecordSearchResponse recordResponse = (RecordSearchResponse) adapter.getData().get(position);
            String roomId = recordResponse.getRoom_id();
            Intent intent = new Intent((Activity) mRootView, PlayActivity.class);
            intent.putExtra("roomId", roomId);
            intent.putExtra("audioList", (ArrayList) recordResponse.getAudio_list());
            intent.putExtra("audio", recordResponse.getAudio_list().get(0));
            intent.putExtra("roomDetail", recordResponse.getRoom_detail());
            mRootView.launchActivity(intent);
        });
        mRootView.setAdapter(mHistoryAdapter);


        mApi.recordSearch(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<RecordSearchResult>() {
                        @Override
                        protected void onNext(RecordSearchResult result) {
                            if (result.getCode() == 200 && null != result.getMsg()) {
                                data.clear();
                                data.addAll(result.getMsg());
                                mHistoryAdapter.notifyDataSetChanged();
                            }
                        }
                    }, (Activity) mRootView)
            );
    }

    public void deleteRecord() {
        mApi.clearRecord(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<HttpResult>() {
                        @Override
                        protected void onNext(HttpResult result) {
                            if (result.getCode() == 200) {
                                mRootView.showToast("删除成功！");

                                data.clear();
                                mHistoryAdapter.notifyDataSetChanged();
                            } else {
                                mRootView.showToast("删除失败！");
                            }
                        }
                    },
                    (Activity) mRootView
            ));
    }
}
