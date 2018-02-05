package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.DiscoverContract;
import com.p609915198.fwb.mvp.di.component.DaggerDiscoverComponent;
import com.p609915198.fwb.mvp.di.module.DiscoverModule;
import com.p609915198.fwb.mvp.presenter.DiscoverPresenter;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by mark.liu on 2017-9-12.
 * 发现
 */
public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements DiscoverContract.View {

    @BindView(R.id.tv_hot_sale) TextView tvHotSale;
    @BindView(R.id.tv_famouse) TextView tvFamouse;
    @BindView(R.id.tv_activity) TextView tvActivity;
    Unbinder unbinder;

    public static DiscoverFragment newInstance() {
        Bundle args = new Bundle();
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerDiscoverComponent
                .builder()
                .baseComponent(baseComponent)
                .discoverModule(new DiscoverModule(this)) //请将DownloadModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initData() {

    }
}
