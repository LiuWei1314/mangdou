package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;

import com.p609915198.basemodule.di.scope.ActivityScope;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.ClearContract;


@ActivityScope
public class ClearModel extends BaseModel implements ClearContract.Model {

    @Inject
    public ClearModel() {
        super();
    }
}