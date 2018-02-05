package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.AlreadyBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerAlreadyBuyComponent;
import com.p609915198.fwb.mvp.di.module.AlreadyBuyModule;
import com.p609915198.fwb.mvp.presenter.AlreadyBuyPresenter;
import com.p609915198.fwb.mvp.ui.adapter.AlreadyBuyAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 已购声音
 * Created by Administrator on 2017/11/14.
 */
public class AlreadyBuyActivity extends BaseActivity<AlreadyBuyPresenter> implements AlreadyBuyContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.rv) RecyclerView mRv;

    @Inject AlreadyBuyAdapter mAlreadyBuyAdapter;
    @Inject RecyclerView.LayoutManager mLayoutManager;
    @Inject RecyclerView.ItemDecoration mItemDecoration;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerAlreadyBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .alreadyBuyModule(new AlreadyBuyModule(this)) //请将AlreadyBuyModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_already_buy;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("已购声音");
        mTvCenter.setVisibility(View.VISIBLE);

        mRv.setLayoutManager(mLayoutManager);
        mRv.addItemDecoration(mItemDecoration);
        mRv.setAdapter(mAlreadyBuyAdapter);

        mPresenter.initData();
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
