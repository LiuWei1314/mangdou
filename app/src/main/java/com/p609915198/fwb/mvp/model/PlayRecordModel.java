package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.GetPlayRecordRequest;
import com.p609915198.basemodule.net.response.GetPlayRecordResponse;
import com.p609915198.fwb.mvp.contract.PlayRecordContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/7.
 */
@ActivityScope
public class PlayRecordModel extends BaseModel implements PlayRecordContract.Model {
    @Inject Api mApi;

    @Inject
    public PlayRecordModel() {
        super();
    }

    @Override
    public Observable<List<GetPlayRecordResponse>> getPlayRecord(GetPlayRecordRequest request) {
        return mApi.getPlayRecord(request.getUser_id());
    }
}