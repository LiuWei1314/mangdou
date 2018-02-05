package com.p609915198.fwb.mvp.model;

import android.text.TextUtils;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.RoomDetailRequest;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.mvp.contract.ColumnContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
public class ColumnModel extends BaseModel implements ColumnContract.Model {
    @Inject Api mApi;

    @Inject
    public ColumnModel() {
        super();
    }

    @Override
    public Observable<RoomDetailResponse> roomDetail(String roomId, String userId) {
        RoomDetailRequest request = new RoomDetailRequest();
        request.setRoom_id(roomId);
        if (!TextUtils.isEmpty(userId)) {
            request.setUser_id(userId);
        }
        return mApi.roomDetail(request);
    }

    @Override
    public Observable subscribeRoom(String roomId, String userId) {
        return mApi.subscribeRoom(roomId, userId);
    }

    @Override
    public Observable topupNew(String key) {
        return mApi.topupNew(key);
    }

    @Override
    public Observable payWx(double valley, String danhao) {
        return mApi.payWX(valley, danhao);
    }
}