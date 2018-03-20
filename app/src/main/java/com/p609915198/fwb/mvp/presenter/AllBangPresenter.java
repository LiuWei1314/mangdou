package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.AllBangContract;


@FragmentScope
public class AllBangPresenter extends BasePresenter<AllBangContract.Model, AllBangContract.View> {

    @Inject
    public AllBangPresenter(AllBangContract.Model model, AllBangContract.View rootView) {
        super(model, rootView);
    }
}
