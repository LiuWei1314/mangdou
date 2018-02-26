package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.TitleOfTopContract;
import com.p609915198.fwb.mvp.di.component.DaggerTitleOfTopComponent;
import com.p609915198.fwb.mvp.di.module.TitleOfTopModule;
import com.p609915198.fwb.mvp.presenter.TitleOfTopPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 巅峰称号
 * Created by Administrator on 2017/12/4.
 */
public class TitleOfTopActivity extends BaseActivity<TitleOfTopPresenter> implements TitleOfTopContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.civ_head) CircleImageView mCivHead;
    @BindView(R.id.tv_name) TextView mTvName;
    @BindView(R.id.iv_vip) ImageView mIvVip;
    @BindView(R.id.iv_title) ImageView mIvTitle;
    @BindView(R.id.bt_recharge) Button mBtRecharge;
    @BindView(R.id.tv_consume) TextView mTvConsume;
    @BindView(R.id.tv_level) TextView mTvLevel;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerTitleOfTopComponent
                .builder()
                .baseComponent(baseComponent)
                .titleOfTopModule(new TitleOfTopModule(this)) //请将TitleOfTopModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_title_of_top;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("巅峰称号");
        mTvCenter.setVisibility(View.VISIBLE);

        mPresenter.getData(AppConfig.getUserId());
    }

    @OnClick({R.id.tv_left, R.id.bt_recharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_recharge:
                // TODO: 2017/12/26 充值
                ToastUtils.showShort("充值");
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void initViews(TopResponse response) {
        Glide.with(this).load(response.getImg_url()).into(mCivHead);
        mTvName.setText(response.getBrand());
        mTvLevel.setText("忙豆等级:" + response.getVip_level());
    }
}
