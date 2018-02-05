package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.PayContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/10/30.
 */
@ActivityScope
public class PayModel extends BaseModel implements PayContract.Model {

    @Inject
    public PayModel() {
        super();
    }
}