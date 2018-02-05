package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.DialogScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.PlayBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/2.
 */
@DialogScope
public class PlayBuyModel extends BaseModel implements PlayBuyContract.Model {

    @Inject
    public PlayBuyModel() {
        super();
    }
}