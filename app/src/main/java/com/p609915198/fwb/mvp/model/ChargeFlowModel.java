package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ChargeFlowContract;

import javax.inject.Inject;


@ActivityScope
public class ChargeFlowModel extends BaseModel implements ChargeFlowContract.Model {

    @Inject
    public ChargeFlowModel() {
        super();
    }
}