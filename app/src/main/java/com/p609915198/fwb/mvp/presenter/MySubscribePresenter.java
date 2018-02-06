package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.MySubscribeContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/6.
 */
@ActivityScope
public class MySubscribePresenter extends BasePresenter<MySubscribeContract.Model, MySubscribeContract.View> {

    @Inject
    public MySubscribePresenter(MySubscribeContract.Model model, MySubscribeContract.View rootView) {
        super(model, rootView);
    }
}
