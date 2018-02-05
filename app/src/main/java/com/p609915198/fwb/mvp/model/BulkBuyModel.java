package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.BulkBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/2.
 */
@ActivityScope
public class BulkBuyModel extends BaseModel implements BulkBuyContract.Model {

    @Inject
    public BulkBuyModel() {
        super();
    }
}