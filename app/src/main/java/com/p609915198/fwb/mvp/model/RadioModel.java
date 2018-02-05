package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.RadioContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class RadioModel extends BaseModel implements RadioContract.Model {

    @Inject
    public RadioModel() {
        super();
    }
}