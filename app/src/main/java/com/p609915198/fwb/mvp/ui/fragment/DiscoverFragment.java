package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.DiscoverContract;
import com.p609915198.fwb.mvp.di.component.DaggerDiscoverComponent;
import com.p609915198.fwb.mvp.di.module.DiscoverModule;
import com.p609915198.fwb.mvp.presenter.DiscoverPresenter;
import com.p609915198.fwb.mvp.ui.activity.AnchorMoreActivity;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 发现
 */
public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements DiscoverContract.View {
    @BindView(R.id.tv_hot_sale) TextView tvHotSale;
    @BindView(R.id.tv_famouse) TextView tvFamouse;

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

    @OnClick({R.id.tv_hot_sale, R.id.tv_famouse})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_hot_sale:
                intent = new Intent(mActivity, RoomsMoreActivity.class);
                intent.putExtra("labelId", "7");
                intent.putExtra("label", "热榜必听");
                break;
            case R.id.tv_famouse:
                intent = new Intent(mActivity, AnchorMoreActivity.class);
                intent.putExtra("labelId", "1");
                intent.putExtra("label", "大神主播");
                break;
        }
        launchActivity(intent);
    }
}
