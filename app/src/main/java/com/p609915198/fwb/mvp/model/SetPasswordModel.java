package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.fwb.mvp.contract.SetPasswordContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class SetPasswordModel extends BaseModel implements SetPasswordContract.Model {
    @Inject Api mApi;

    @Inject
    public SetPasswordModel() {
        super();
    }

    @Override
    public Observable<Integer> register(String phone, String password) {
        return mApi.register(phone, password);
    }
}