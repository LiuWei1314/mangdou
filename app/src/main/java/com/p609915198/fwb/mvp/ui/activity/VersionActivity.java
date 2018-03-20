package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;

import android.support.annotation.NonNull;

import com.p609915198.fwb.mvp.di.component.DaggerVersionComponent;
import com.p609915198.fwb.mvp.di.module.VersionModule;
import com.p609915198.fwb.mvp.contract.VersionContract;
import com.p609915198.fwb.mvp.presenter.VersionPresenter;


public class VersionActivity extends BaseActivity<VersionPresenter> implements VersionContract.View {

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerVersionComponent
                .builder()
                .baseComponent(baseComponent)
                .versionModule(new VersionModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_version;
    }

    @Override
    public void initData() {

    }
}
