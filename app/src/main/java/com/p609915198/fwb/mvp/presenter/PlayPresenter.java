package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.PlayContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@ActivityScope
public class PlayPresenter extends BasePresenter<PlayContract.Model, PlayContract.View> {

    @Inject
    public PlayPresenter(PlayContract.Model model, PlayContract.View rootView) {
        super(model, rootView);
    }
}
