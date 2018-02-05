package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.RadioContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class RadioPresenter extends BasePresenter<RadioContract.Model, RadioContract.View> {

    @Inject
    public RadioPresenter(RadioContract.Model model, RadioContract.View rootView) {
        super(model, rootView);
    }
}
