package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.component.DaggerHostBangComponent;
import com.p609915198.fwb.mvp.di.module.HostBangModule;
import com.p609915198.fwb.mvp.contract.HostBangContract;
import com.p609915198.fwb.mvp.presenter.HostBangPresenter;
import com.p609915198.fwb.R;

public class HostBangFragment extends BaseFragment<HostBangPresenter> implements HostBangContract.View {

    public static HostBangFragment newInstance() {
        Bundle args = new Bundle();
        HostBangFragment fragment = new HostBangFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerHostBangComponent
                .builder()
                .baseComponent(baseComponent)
                .hostBangModule(new HostBangModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_host_bang;
    }

    @Override
    public void initData() {

    }
}
