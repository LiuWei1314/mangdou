package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ChooseContract;

import javax.inject.Inject;


@ActivityScope
public class ChoosePresenter extends BasePresenter<ChooseContract.Model, ChooseContract.View> {

    @Inject
    public ChoosePresenter(ChooseContract.Model model, ChooseContract.View rootView) {
        super(model, rootView);
    }
}
