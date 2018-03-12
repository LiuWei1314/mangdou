package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.TestContract;


@ActivityScope
public class TestPresenter extends BasePresenter<TestContract.Model, TestContract.View> {

    @Inject
    public TestPresenter(TestContract.Model model, TestContract.View rootView) {
        super(model, rootView);
    }
}
