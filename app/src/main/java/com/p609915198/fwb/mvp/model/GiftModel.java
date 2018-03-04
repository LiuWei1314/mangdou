package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.GiftContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class GiftModel extends BaseModel implements GiftContract.Model {

    @Inject
    public GiftModel() {
        super();
    }
}