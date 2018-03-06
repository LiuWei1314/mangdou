package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.FeedBackContract;


@ActivityScope
public class FeedBackPresenter extends BasePresenter<FeedBackContract.Model, FeedBackContract.View> {

    @Inject
    public FeedBackPresenter(FeedBackContract.Model model, FeedBackContract.View rootView) {
        super(model, rootView);
    }
}
