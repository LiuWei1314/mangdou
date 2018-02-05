package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.request.ChangeUserInfoRequest;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.NameContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class NameModel extends BaseModel implements NameContract.Model {
    @Inject Api mApi;

    @Inject
    public NameModel() {
        super();
    }

    @Override
    public Observable<HttpResult> setName(String name) {
        ChangeUserInfoRequest request = new ChangeUserInfoRequest();
        request.setUser_id(AppConfig.getUserId());
        request.setName(name);
        return mApi.changeUserInfo(request);
    }
}