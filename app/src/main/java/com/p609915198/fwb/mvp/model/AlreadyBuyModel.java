package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.AlreadyBuyRequest;
import com.p609915198.fwb.mvp.contract.AlreadyBuyContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
public class AlreadyBuyModel extends BaseModel implements AlreadyBuyContract.Model {

    @Inject
    public AlreadyBuyModel(Api api) {
        super();
    }

    @Override
    public Observable getAlreadyBuyData(AlreadyBuyRequest request) {
        return null;
    }
}