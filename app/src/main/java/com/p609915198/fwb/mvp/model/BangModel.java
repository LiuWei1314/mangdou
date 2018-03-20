package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;

import com.p609915198.basemodule.di.scope.ActivityScope;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.BangContract;


@ActivityScope
public class BangModel extends BaseModel implements BangContract.Model {

    @Inject
    public BangModel() {
        super();
    }
}