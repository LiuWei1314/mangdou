package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.fwb.mvp.contract.TitleOfTopContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/4.
 */
@ActivityScope
public class TitleOfTopModel extends BaseModel implements TitleOfTopContract.Model {
    @Inject Api mApi;

    @Inject
    public TitleOfTopModel() {
        super();
    }

    @Override
    public Observable<TopResponse> top(String userId) {
        return mApi.top(userId);
    }
}