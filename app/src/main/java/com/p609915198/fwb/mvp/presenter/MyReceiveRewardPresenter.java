package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.MyReceiveRewardContract;


@FragmentScope
public class MyReceiveRewardPresenter extends BasePresenter<MyReceiveRewardContract.Model, MyReceiveRewardContract.View> {

    @Inject
    public MyReceiveRewardPresenter(MyReceiveRewardContract.Model model, MyReceiveRewardContract.View rootView) {
        super(model, rootView);
    }
}
