package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.PayContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/10/30.
 */
@ActivityScope
public class PayPresenter extends BasePresenter<PayContract.Model, PayContract.View> {

    @Inject
    public PayPresenter(PayContract.Model model, PayContract.View rootView) {
        super(model, rootView);
    }
}
