package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;

import android.support.annotation.NonNull;

import com.p609915198.fwb.mvp.di.component.DaggerClearComponent;
import com.p609915198.fwb.mvp.di.module.ClearModule;
import com.p609915198.fwb.mvp.contract.ClearContract;
import com.p609915198.fwb.mvp.presenter.ClearPresenter;


public class ClearActivity extends BaseActivity<ClearPresenter> implements ClearContract.View {

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerClearComponent
                .builder()
                .baseComponent(baseComponent)
                .clearModule(new ClearModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_clear;
    }

    @Override
    public void initData() {

    }
}
