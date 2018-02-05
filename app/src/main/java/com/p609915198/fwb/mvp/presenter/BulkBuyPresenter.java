package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.BulkBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/2.
 */
@ActivityScope
public class BulkBuyPresenter extends BasePresenter<BulkBuyContract.Model, BulkBuyContract.View> {

    @Inject
    public BulkBuyPresenter(BulkBuyContract.Model model, BulkBuyContract.View rootView) {
        super(model, rootView);
    }


}
