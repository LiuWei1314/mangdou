package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.HomePageContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class HomePageModel extends BaseModel implements HomePageContract.Model {

    @Inject
    public HomePageModel() {
        super();
    }
}