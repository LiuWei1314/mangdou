package com.p609915198.fwb.mvp.model;import com.p609915198.basemodule.base.BaseModel;import com.p609915198.basemodule.di.scope.ActivityScope;import com.p609915198.fwb.mvp.contract.ListBuyContract;import javax.inject.Inject;@ActivityScopepublic class ListBuyModel extends BaseModel implements ListBuyContract.Model {    @Inject    public ListBuyModel() {        super();    }}