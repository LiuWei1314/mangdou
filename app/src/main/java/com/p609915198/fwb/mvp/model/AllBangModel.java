package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;

import com.p609915198.basemodule.di.scope.FragmentScope;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.AllBangContract;


@FragmentScope
public class AllBangModel extends BaseModel implements AllBangContract.Model {

    @Inject
    public AllBangModel() {
        super();
    }
}