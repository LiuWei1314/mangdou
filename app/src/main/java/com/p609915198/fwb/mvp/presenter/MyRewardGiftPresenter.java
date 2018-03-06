package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.MyRewardGiftContract;

import javax.inject.Inject;

/**
 * 我收到的礼物
 */
@FragmentScope
public class MyRewardGiftPresenter extends BasePresenter<MyRewardGiftContract.Model, MyRewardGiftContract.View> {

    @Inject
    public MyRewardGiftPresenter(MyRewardGiftContract.Model model, MyRewardGiftContract.View rootView) {
        super(model, rootView);
    }
}
