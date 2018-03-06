package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;

import com.p609915198.basemodule.di.scope.FragmentScope;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.MyGiftContract;


@FragmentScope
public class MyGiftModel extends BaseModel implements MyGiftContract.Model {

    @Inject
    public MyGiftModel() {
        super();
    }
}