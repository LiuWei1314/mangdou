package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.AboutUsContract;


@ActivityScope
public class AboutUsPresenter extends BasePresenter<AboutUsContract.Model, AboutUsContract.View> {

    @Inject
    public AboutUsPresenter(AboutUsContract.Model model, AboutUsContract.View rootView) {
        super(model, rootView);
    }
}
