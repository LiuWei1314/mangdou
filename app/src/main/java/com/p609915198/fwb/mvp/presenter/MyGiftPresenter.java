package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;

import javax.inject.Inject;

import com.p609915198.fwb.mvp.contract.MyGiftContract;


@FragmentScope
public class MyGiftPresenter extends BasePresenter<MyGiftContract.Model, MyGiftContract.View> {

    @Inject
    public MyGiftPresenter(MyGiftContract.Model model, MyGiftContract.View rootView) {
        super(model, rootView);
    }
}
