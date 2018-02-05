package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.DowloadAllBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/2.
 */
@ActivityScope
public class DowloadAllBuyPresenter extends BasePresenter<DowloadAllBuyContract.Model, DowloadAllBuyContract.View> {

    @Inject
    public DowloadAllBuyPresenter(DowloadAllBuyContract.Model model, DowloadAllBuyContract.View rootView) {
        super(model, rootView);
    }
}
