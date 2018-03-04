package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.RewardContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class RewardModel extends BaseModel implements RewardContract.Model {

    @Inject
    public RewardModel() {
        super();
    }
}