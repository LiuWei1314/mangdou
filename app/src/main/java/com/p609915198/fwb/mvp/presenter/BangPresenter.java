package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.BangContract;


@ActivityScope
public class BangPresenter extends BasePresenter<BangContract.Model, BangContract.View> {

    @Inject
    public BangPresenter(BangContract.Model model, BangContract.View rootView) {
        super(model, rootView);
    }
}
