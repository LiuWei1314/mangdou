package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.component.DaggerAllBangComponent;
import com.p609915198.fwb.mvp.di.module.AllBangModule;
import com.p609915198.fwb.mvp.contract.AllBangContract;
import com.p609915198.fwb.mvp.presenter.AllBangPresenter;
import com.p609915198.fwb.R;

public class AllBangFragment extends BaseFragment<AllBangPresenter> implements AllBangContract.View {

    public static AllBangFragment newInstance() {
        Bundle args = new Bundle();
        AllBangFragment fragment = new AllBangFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerAllBangComponent
                .builder()
                .baseComponent(baseComponent)
                .allBangModule(new AllBangModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_all_bang;
    }

    @Override
    public void initData() {

    }
}
