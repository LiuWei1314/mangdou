package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ListDownloadContract;
import com.p609915198.fwb.mvp.di.component.DaggerListDownloadComponent;
import com.p609915198.fwb.mvp.di.module.ListDownloadModule;
import com.p609915198.fwb.mvp.presenter.ListDownloadPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 批量下载
 */
public class ListDownloadActivity extends BaseActivity<ListDownloadPresenter> implements ListDownloadContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_total_num) TextView tvTotalNum;
    @BindView(R.id.tv_choose) TextView tvChoose;
    @BindView(R.id.rv_1) RecyclerView rv1;
    @BindView(R.id.rv_2) RecyclerView rv2;

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

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}
}
