package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.SearchResultContract;

import javax.inject.Inject;


@ActivityScope
public class SearchResultPresenter extends BasePresenter<SearchResultContract.Model, SearchResultContract.View> {

    @Inject
    public SearchResultPresenter(SearchResultContract.Model model, SearchResultContract.View rootView) {
        super(model, rootView);
    }
}
