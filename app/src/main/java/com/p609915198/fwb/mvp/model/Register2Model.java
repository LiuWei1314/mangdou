package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.Register2Contract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class Register2Model extends BaseModel implements Register2Contract.Model {

    @Inject
    public Register2Model() {
        super();
    }
}