package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.ListenContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class ListenPresenter extends BasePresenter<ListenContract.Model, ListenContract.View> {

    @Inject
    public ListenPresenter(ListenContract.Model model, ListenContract.View rootView) {
        super(model, rootView);
    }
}
