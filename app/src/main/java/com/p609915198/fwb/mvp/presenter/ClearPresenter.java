package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.ClearContract;


@ActivityScope
public class ClearPresenter extends BasePresenter<ClearContract.Model, ClearContract.View> {

    @Inject
    public ClearPresenter(ClearContract.Model model, ClearContract.View rootView) {
        super(model, rootView);
    }
}
