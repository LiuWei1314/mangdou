package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.mvp.contract.RoomDetailContract;
import com.p609915198.fwb.mvp.ui.adapter.RoomDetailAdapter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
public class RoomDetailPresenter extends BasePresenter<RoomDetailContract.Model, RoomDetailContract.View> {
    private RoomDetailAdapter mRoomDetailAdapter;

    @Inject
    public RoomDetailPresenter(RoomDetailContract.Model model, RoomDetailContract.View rootView) {
        super(model, rootView);
    }

    public void initCommon(RoomDetailResponse response) {
        mRoomDetailAdapter = new RoomDetailAdapter(response.getRoom_reply());
        mRootView.setAdapter(mRoomDetailAdapter);
    }
}
