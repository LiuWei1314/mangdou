package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.HistoryContract;
import com.p609915198.fwb.mvp.di.component.DaggerHistoryComponent;
import com.p609915198.fwb.mvp.di.module.HistoryModule;
import com.p609915198.fwb.mvp.presenter.HistoryPresenter;
import com.p609915198.fwb.mvp.ui.adapter.HistoryAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/6.
 */
public class HistoryActivity extends BaseActivity<HistoryPresenter> implements HistoryContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.rv) RecyclerView rv;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerHistoryComponent
                .builder()
                .baseComponent(baseComponent)
                .historyModule(new HistoryModule(this)) //请将HistoryModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_history;
    }

    @Override
    protected void initData() {
        tvCenter.setText("播放历史");
        tvCenter.setVisibility(View.VISIBLE);

        mPresenter.initAdapter();
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    @Override
    public void setAdapter(HistoryAdapter adapter) {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(adapter);
    }
}
