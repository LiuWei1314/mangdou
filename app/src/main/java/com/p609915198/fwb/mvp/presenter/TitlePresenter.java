package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.TitleContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class TitlePresenter extends BasePresenter<TitleContract.Model, TitleContract.View> {

    @Inject
    public TitlePresenter(TitleContract.Model model, TitleContract.View rootView) {
        super(model, rootView);
    }
}
