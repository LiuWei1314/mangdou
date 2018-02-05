package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.fwb.mvp.contract.RoomsMoreContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
public class RoomsMoreModel extends BaseModel implements RoomsMoreContract.Model {
    @Inject Api mApi;

    @Inject
    public RoomsMoreModel() {
        super();
    }

    @Override
    public Observable roomsMore(String laberId) {
        return mApi.roomsMore(laberId);
    }
}