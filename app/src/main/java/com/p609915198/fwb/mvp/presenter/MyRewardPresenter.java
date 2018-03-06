package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.MyRewardContract;


@FragmentScope
public class MyRewardPresenter extends BasePresenter<MyRewardContract.Model, MyRewardContract.View> {

    @Inject
    public MyRewardPresenter(MyRewardContract.Model model, MyRewardContract.View rootView) {
        super(model, rootView);
    }
}
