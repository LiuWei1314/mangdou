package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.AnchorMoreContract;
import com.p609915198.fwb.mvp.di.component.DaggerAnchorMoreComponent;
import com.p609915198.fwb.mvp.di.module.AnchorMoreModule;
import com.p609915198.fwb.mvp.presenter.AnchorMorePresenter;
import com.p609915198.fwb.mvp.ui.adapter.AnchorMoreAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主播更多
 * Created by Administrator on 2017/11/9.
 */
public class AnchorMoreActivity extends BaseActivity<AnchorMorePresenter> implements AnchorMoreContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.rv) RecyclerView mRv;

    private String labelId;
    private String label;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerAnchorMoreComponent
                .builder()
                .baseComponent(baseComponent)
                .anchorMoreModule(new AnchorMoreModule(this)) //请将AnchorMoreModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_anchor_more;
    }

    @Override
    protected void initData() {
        labelId = getIntent().getStringExtra("labelId");
        label = getIntent().getStringExtra("label");
        mTvCenter.setText(label);
        mTvCenter.setVisibility(View.VISIBLE);
        mPresenter.initData(labelId, label);
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    @Override
    public void setAdapter(AnchorMoreAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRv.setAdapter(adapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
