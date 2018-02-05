package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.response.SendResponse;
import com.p609915198.fwb.mvp.contract.RegisterContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/30.
 */
@ActivityScope
public class RegisterModel extends BaseModel implements RegisterContract.Model {
    @Inject Api mApi;

    @Inject
    public RegisterModel() {
        super();
    }

    @Override
    public Observable<HttpResult<SendResponse>> send(String phone, String code) {
        return mApi.send(code, phone);
    }
}