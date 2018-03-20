package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.BangContract;
import com.p609915198.fwb.mvp.di.component.DaggerBangComponent;
import com.p609915198.fwb.mvp.di.module.BangModule;
import com.p609915198.fwb.mvp.presenter.BangPresenter;

/**
 * 榜单
 */
public class BangActivity extends BaseActivity<BangPresenter> implements BangContract.View {

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerBangComponent
                .builder()
                .baseComponent(baseComponent)
                .bangModule(new BangModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_bang;
    }

    @Override
    public void initData() {

    }
}
