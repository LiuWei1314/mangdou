package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.DiscoverContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class DiscoverPresenter extends BasePresenter<DiscoverContract.Model, DiscoverContract.View> {

    @Inject
    public DiscoverPresenter(DiscoverContract.Model model, DiscoverContract.View rootView) {
        super(model, rootView);
    }
}
