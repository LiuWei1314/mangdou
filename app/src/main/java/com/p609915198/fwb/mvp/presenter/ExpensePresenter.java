package com.p609915198.fwb.mvp.presenter;


import javax.inject.Inject;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ExpenseContract;


@ActivityScope
public class ExpensePresenter extends BasePresenter<ExpenseContract.Model, ExpenseContract.View> {

    @Inject
    public ExpensePresenter(ExpenseContract.Model model, ExpenseContract.View rootView) {
        super(model, rootView);
    }
}
