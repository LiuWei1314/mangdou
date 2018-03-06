package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;

import android.support.annotation.NonNull;

import com.p609915198.fwb.mvp.di.component.DaggerListDownloadComponent;
import com.p609915198.fwb.mvp.di.module.ListDownloadModule;
import com.p609915198.fwb.mvp.contract.ListDownloadContract;
import com.p609915198.fwb.mvp.presenter.ListDownloadPresenter;

/**
 * 批量下载
 */
public class ListDownloadActivity extends BaseActivity<ListDownloadPresenter> implements ListDownloadContract.View {

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerListDownloadComponent
                .builder()
                .baseComponent(baseComponent)
                .listDownloadModule(new ListDownloadModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_list_download;
    }

    @Override
    public void initData() {

    }
}
