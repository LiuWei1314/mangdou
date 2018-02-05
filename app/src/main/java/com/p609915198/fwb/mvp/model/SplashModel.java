package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.SplashContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@ActivityScope
public class SplashModel extends BaseModel implements SplashContract.Model {

    @Inject
    public SplashModel() {
        super();
    }
}