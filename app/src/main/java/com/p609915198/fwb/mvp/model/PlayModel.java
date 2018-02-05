package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.PlayContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@ActivityScope
public class PlayModel extends BaseModel implements PlayContract.Model {

    @Inject
    public PlayModel() {
        super();
    }
}