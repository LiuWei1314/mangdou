package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;

import android.support.annotation.NonNull;

import com.p609915198.fwb.mvp.di.component.DaggerAboutUsComponent;
import com.p609915198.fwb.mvp.di.module.AboutUsModule;
import com.p609915198.fwb.mvp.contract.AboutUsContract;
import com.p609915198.fwb.mvp.presenter.AboutUsPresenter;


public class AboutUsActivity extends BaseActivity<AboutUsPresenter> implements AboutUsContract.View {

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerAboutUsComponent
                .builder()
                .baseComponent(baseComponent)
                .aboutUsModule(new AboutUsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initData() {

    }
}
