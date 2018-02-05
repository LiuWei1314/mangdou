package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.GeneralSettingsContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
@ActivityScope
public class GeneralSettingsModel extends BaseModel implements GeneralSettingsContract.Model {

    @Inject
    public GeneralSettingsModel() {
        super();
    }
}