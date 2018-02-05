package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.response.SendResponse;
import com.p609915198.fwb.mvp.contract.ForgetPasswordContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
@ActivityScope
public class ForgetPasswordModel extends BaseModel implements ForgetPasswordContract.Model {
    @Inject Api mApi;

    @Inject
    public ForgetPasswordModel() {
        super();
    }

    @Override
    public Observable<HttpResult<SendResponse>> send(String phone, String code) {
        return mApi.send(code, phone);
    }
}