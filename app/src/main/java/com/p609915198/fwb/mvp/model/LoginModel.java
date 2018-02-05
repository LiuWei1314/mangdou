package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.LoginResponse;
import com.p609915198.fwb.mvp.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-12.
 */
@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {
    @Inject Api mApi;

    @Inject
    public LoginModel() {
        super();
    }

    @Override
    public Observable<String> login(String username, String password) {
        return mApi.login(username, password);
    }
}