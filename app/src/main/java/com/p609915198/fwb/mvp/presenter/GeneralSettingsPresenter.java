package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.GeneralSettingsContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
@ActivityScope
public class GeneralSettingsPresenter extends BasePresenter<GeneralSettingsContract.Model, GeneralSettingsContract.View> {

    @Inject
    public GeneralSettingsPresenter(GeneralSettingsContract.Model model, GeneralSettingsContract.View rootView) {
        super(model, rootView);
    }
}
