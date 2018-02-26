package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.MyBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
public class MyBuyModel extends BaseModel implements MyBuyContract.Model {

    @Inject
    public MyBuyModel() {
        super();
    }
}