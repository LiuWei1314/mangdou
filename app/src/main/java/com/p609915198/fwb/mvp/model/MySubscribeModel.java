package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.MySubscribeContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/6.
 */
@ActivityScope
public class MySubscribeModel extends BaseModel implements MySubscribeContract.Model {

    @Inject
    public MySubscribeModel() {
        super();
    }
}