package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.SearchResultContract;

import javax.inject.Inject;


@ActivityScope
public class SearchResultModel extends BaseModel implements SearchResultContract.Model {

    @Inject
    public SearchResultModel() {
        super();
    }
}