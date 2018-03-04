package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.GiftContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class GiftPresenter extends BasePresenter<GiftContract.Model, GiftContract.View> {

    @Inject
    public GiftPresenter(GiftContract.Model model, GiftContract.View rootView) {
        super(model, rootView);
    }
}
