package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.fwb.mvp.contract.MineContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class MineModel extends BaseModel implements MineContract.Model {
    @Inject Api mApi;

    @Inject
    public MineModel() {
        super();
    }

    @Override
    public Observable<UserBaseInfoResponse> userBaseInfo(String userId) {
        return mApi.userBaseInfo(userId);
    }
}