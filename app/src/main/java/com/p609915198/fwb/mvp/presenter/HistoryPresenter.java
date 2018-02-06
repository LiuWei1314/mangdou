package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.GetPlayRecordResponse;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
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
        mApi.getPlayRecord(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<GetPlayRecordResponse>>() {
                        @Override
                        protected void onNext(List<GetPlayRecordResponse> getPlayRecordResponses) {
                            mHistoryAdapter = new HistoryAdapter(getPlayRecordResponses);
                            mHistoryAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                                GetPlayRecordResponse recordResponse = (GetPlayRecordResponse) adapter.getData().get(position);
                                String roomId = recordResponse.getRoom_id();
                                List<Audio> audios = recordResponse.getPlay_record();
                                Intent intent = new Intent(((BaseFragment) mRootView).getActivity(), PlayActivity.class);
                                intent.putExtra("roomId", roomId);
                                intent.putExtra("audioList", (ArrayList) audios);
                                intent.putExtra("audio", audios.get(position));
                                RoomDetailResponse roomDetailResponse = new RoomDetailResponse();
                                roomDetailResponse.setRoom_blurcover(recordResponse.getRoom_blurcover());
                                roomDetailResponse.setRoom_cover(recordResponse.getRoom_cover());
                                roomDetailResponse.setRoom_frequency(recordResponse.getRoom_frequency());
                                roomDetailResponse.setRoom_price(recordResponse.getRoom_price());
                                roomDetailResponse.setRoom_name(recordResponse.getRoom_name());
                                roomDetailResponse.setLast_update(recordResponse.getLast_update());
                                roomDetailResponse.setUser_name(recordResponse.getUser_name());
                                intent.putExtra("roomDetail", roomDetailResponse);
                                mRootView.launchActivity(intent);
                            });
                            mRootView.setAdapter(mHistoryAdapter);
                        }
                    }, ((BaseFragment) mRootView).getActivity())
            );
    }
}
