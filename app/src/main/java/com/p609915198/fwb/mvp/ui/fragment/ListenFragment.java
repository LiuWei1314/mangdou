package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ListenContract;
import com.p609915198.fwb.mvp.di.component.DaggerListenComponent;
import com.p609915198.fwb.mvp.di.module.ListenModule;
import com.p609915198.fwb.mvp.presenter.ListenPresenter;

import butterknife.BindView;

/**
 * Created by mark.liu on 2017-9-12.
 * 我听
 */
public class ListenFragment extends BaseFragment<ListenPresenter> implements ListenContract.View {
    @BindView(R.id.tv_download_size) TextView tvDownloadSize;
    @BindView(R.id.tv_history_size) TextView tvHistorySize;
    @BindView(R.id.tv_buy_size) TextView tvBuySize;
    @BindView(R.id.rv) RecyclerView rv;

    public static ListenFragment newInstance() {
        Bundle args = new Bundle();
        ListenFragment fragment = new ListenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerListenComponent
                .builder()
                .baseComponent(baseComponent)
                .listenModule(new ListenModule(this)) //请将ListenModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_listen;
    }

    @Override
    protected void initData() {

    }
}
