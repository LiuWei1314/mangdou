package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-5-24.
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    public MainModel() {
        super();
    }
}