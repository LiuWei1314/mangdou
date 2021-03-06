package com.p609915198.fwb.mvp.model;


import javax.inject.Inject;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ExpenseContract;


@ActivityScope
public class ExpenseModel extends BaseModel implements ExpenseContract.Model {

    @Inject
    public ExpenseModel() {
        super();
    }
}