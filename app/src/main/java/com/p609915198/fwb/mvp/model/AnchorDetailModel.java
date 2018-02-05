package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.fwb.mvp.contract.AnchorDetailContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/10.
 */
@ActivityScope
public class AnchorDetailModel extends BaseModel implements AnchorDetailContract.Model {
    @Inject Api mApi;

    @Inject
    public AnchorDetailModel() {
        super();
    }

    @Override
    public Observable<AnchorDetailResponse> anchorDetail(String userId) {
        return mApi.anchorDetail(userId);
    }
}