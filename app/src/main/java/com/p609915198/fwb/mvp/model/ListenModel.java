package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.ListenContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class ListenModel extends BaseModel implements ListenContract.Model {

    @Inject
    public ListenModel() {
        super();
    }
}