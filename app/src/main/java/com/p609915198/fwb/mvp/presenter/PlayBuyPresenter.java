package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.DialogScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.PlayBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/2.
 */
@DialogScope
public class PlayBuyPresenter extends BasePresenter<PlayBuyContract.Model, PlayBuyContract.View> {

    @Inject
    public PlayBuyPresenter(PlayBuyContract.Model model, PlayBuyContract.View rootView) {
        super(model, rootView);
    }
}
