package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.HostBangContract;


@FragmentScope
public class HostBangPresenter extends BasePresenter<HostBangContract.Model, HostBangContract.View> {

    @Inject
    public HostBangPresenter(HostBangContract.Model model, HostBangContract.View rootView) {
        super(model, rootView);
    }
}
