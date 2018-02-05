package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.fwb.mvp.contract.ForgetPassword2Contract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class ForgetPassword2Model extends BaseModel implements ForgetPassword2Contract.Model {
    @Inject Api mApi;

    @Inject
    public ForgetPassword2Model() {
        super();
    }

    @Override
    public Observable resetPassword(String phone, String password) {
        return mApi.changePwdPhone(phone, password);
    }
}