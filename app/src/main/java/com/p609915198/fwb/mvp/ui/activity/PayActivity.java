package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.PayContract;
import com.p609915198.fwb.mvp.di.component.DaggerPayComponent;
import com.p609915198.fwb.mvp.di.module.PayModule;
import com.p609915198.fwb.mvp.presenter.PayPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忙豆充值
 * Created by Administrator on 2017/10/30.
 */
public class PayActivity extends BaseActivity<PayPresenter> implements PayContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;
    @BindView(R.id.tv_1) TextView mTv1;
    @BindView(R.id.rv) RecyclerView mRv;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerPayComponent
                .builder()
                .baseComponent(baseComponent)
                .payModule(new PayModule(this)) //请将PayModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("忙豆充值");
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity(this, intent);
    }

    @Override
    public void killMyself() {
        ActivityUtils.finishActivity(this);
    }

    @Override
    public void setAdapter(BaseQuickAdapter adapter) {
        mRv.setLayoutManager(new GridLayoutManager(this, 2));
        mRv.setAdapter(adapter);
    }
}
