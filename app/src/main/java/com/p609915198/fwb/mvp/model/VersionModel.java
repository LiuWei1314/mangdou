package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;

import com.p609915198.basemodule.di.scope.ActivityScope;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.VersionContract;


@ActivityScope
public class VersionModel extends BaseModel implements VersionContract.Model {

    @Inject
    public VersionModel() {
        super();
    }
}