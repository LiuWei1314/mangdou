package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.ListDownloadContract;


@ActivityScope
public class ListDownloadPresenter extends BasePresenter<ListDownloadContract.Model, ListDownloadContract.View> {

    @Inject
    public ListDownloadPresenter(ListDownloadContract.Model model, ListDownloadContract.View rootView) {
        super(model, rootView);
    }
}
