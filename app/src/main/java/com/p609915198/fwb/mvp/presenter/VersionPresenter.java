package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.VersionContract;


@ActivityScope
public class VersionPresenter extends BasePresenter<VersionContract.Model, VersionContract.View> {

    @Inject
    public VersionPresenter(VersionContract.Model model, VersionContract.View rootView) {
        super(model, rootView);
    }
}
